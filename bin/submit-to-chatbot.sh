#!/bin/bash

# Endpoint for the chatbot attachment upload
ENDPOINT_URL="https://uploadattachment-qjoo55pcba-uc.a.run.app"

# Prompt for the attachment code
echo "Please enter your attachment code:"
read attachmentCode

# Find files in the current directory and its subdirectories, and the Dockerfile from the parent
# The script is expected to be run from an assignment directory, so '../' refers to the course root.
files_to_select=()
while IFS= read -r file; do
    # Use a placeholder to make the Dockerfile path more readable
    if [[ "$file" == ../Dockerfile ]]; then
        display_path="COURSE_ROOT/Dockerfile"
    else
        # remove leading ./
        display_path=${file#./}
    fi
    files_to_select+=("$file|$display_path")
done < <(find . -type f -not -path "./.git/*" -o -type f -path '../Dockerfile')


# Interactively select files
function interactive_select() {
    # The list of files to choose from
    local -n options=$1
    # The array to store the indices of selected files
    local -n selected_indices_ref=$2

    local cursor=0
    local count=${#options[@]}
    local selected=()
    for ((i=0; i<count; i++)); do
        selected+=("false")
    done

    # Make sure we restore terminal settings on exit
    trap 'tput cnorm; stty echo; exit' SIGINT EXIT

    # Hide cursor and disable echoing characters
    tput civis
    stty -echo

    # Clear screen for the menu
    tput clear

    while true; do
        # Move cursor to top left
        tput cup 0 0

        echo "Select files to upload. Use arrow keys to navigate, space to select, enter to confirm."
        echo "---------------------------------------------------------------------------------"

        for i in $(seq 0 $(($count-1))); do
            local display_path=$(echo "${options[$i]}" | cut -d'|' -f2)
            local prefix="[ ]"
            if [ "${selected[$i]}" = "true" ]; then
                prefix="[x]"
            fi

            if [ $i -eq $cursor ]; then
                # Highlight current line
                echo -e " > \e[7m$prefix $display_path\e[0m"
            else
                echo "   $prefix $display_path"
            fi
        done

        # Read a single keystroke
        read -rsn1 key
        # If it's an escape sequence, read more
        if [[ $key == $'\x1b' ]]; then
            read -rsn2 -t 0.1 key
            if [[ $key == '[A' ]]; then # Up arrow
                cursor=$(( (cursor - 1 + count) % count ))
            elif [[ $key == '[B' ]]; then # Down arrow
                cursor=$(( (cursor + 1) % count ))
            fi
        elif [[ $key == ' ' ]]; then # Space bar
            if [ "${selected[$cursor]}" = "true" ]; then
                selected[$cursor]="false"
            else
                selected[$cursor]="true"
            fi
        elif [[ $key == '' ]]; then # Enter key
            break
        fi
    done

    # Clear the menu from the screen
    tput clear

    # Show cursor and re-enable echo
    tput cnorm
    stty echo

    # Populate the array of selected indices for the caller
    for i in $(seq 0 $(($count-1))); do
        if [ "${selected[$i]}" = "true" ]; then
            # We use 1-based indexing for the result
            selected_indices_ref+=($((i+1)))
        fi
    done

    # Remove the trap so we don't exit
    trap - SIGINT EXIT
}

# Let the user select files using the interactive menu
selected_indices=()
interactive_select files_to_select selected_indices

# Prepare the data payload
json_payload="{\"attachmentCode\":\"$attachmentCode\",\"data\":{\"files\":{}}}"


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