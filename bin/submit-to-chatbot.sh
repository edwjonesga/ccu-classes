#!/bin/bash

# Endpoint for the chatbot attachment upload
ENDPOINT_URL="https://uploadattachment-qjoo55pcba-uc.a.run.app"

# Prompt for the attachment code
echo "Please enter your attachment code:"
read attachmentCode

# Find files in the current directory and the Dockerfile from the parent
# The script is expected to be run from an assignment directory, so '../' refers to the course root.
files_to_select=()
while IFS= read -r file; do
    # Use a placeholder to make the Dockerfile path more readable
    if [[ "$file" == ../Dockerfile ]]; then
        display_path="COURSE_ROOT/Dockerfile"
    else
        display_path=$(basename "$file")
    fi
    files_to_select+=("$file|$display_path")
done < <(find . -type f -maxdepth 1 -o -type f -path '../Dockerfile')


# Let the user select files
echo "Select which files to upload (e.g., 1 2 4). To select all, type 'all':"
for i in "${!files_to_select[@]}"; do
    original_path=$(echo "${files_to_select[$i]}" | cut -d'|' -f2)
    printf "%d) %s\n" $((i+1)) "$original_path"
done

read -p "Your selection: " -a selection

# Prepare the data payload
json_payload="{\"attachmentCode\":\"$attachmentCode\",\"data\":{\"files\":{}}}"
selected_indices=()

if [[ "${selection[0]}" == "all" ]]; then
    for i in "${!files_to_select[@]}"; do
        selected_indices+=($((i+1)))
    done
else
    selected_indices=("${selection[@]}")
fi


for index in "${selected_indices[@]}"; do
    file_info=${files_to_select[$((index-1))]}
    file_path_actual=$(echo "$file_info" | cut -d'|' -f1)

    if [ -f "$file_path_actual" ]; then
        # Base64 encode the file content to ensure it's JSON-safe
        content=$(base64 -w 0 "$file_path_actual")
        filename=$(basename "$file_path_actual")

        # Add file to JSON payload
        json_payload=$(echo "$json_payload" | jq --arg name "$filename" --arg content "$content" '.data.files[$name] = $content')
    else
        echo "Warning: File not found at $file_path_actual. Skipping."
    fi
done

# Send the data using curl
echo "Uploading files..."
response=$(curl -s -X POST -H "Content-Type: application/json" -d "$json_payload" "$ENDPOINT_URL")

# Display the response
echo "Server response:"
echo "$response" | jq .

# Check for success and provide feedback
if echo "$response" | jq -e '.success' > /dev/null; then
    echo "Files uploaded successfully!"
else
    error_message=$(echo "$response" | jq -r '.error')
    echo "An error occurred: $error_message"
fi