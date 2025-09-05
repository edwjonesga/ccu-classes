#!/bin/bash

echo "Refreshing assignment files from the class repository..."

# Hardcoded repository URL
REPO_URL="https://github.com/edwjonesga/edwjones-ccu.git"
ASSIGNMENT_PATH="classes/csc-385"

# Create a temporary directory for cloning
temp_dir=$(mktemp -d)
if [ ! -d "$temp_dir" ]; then
    echo "Failed to create temporary directory."
    exit 1
fi

# Clone the repository
echo "Cloning the class repository into a temporary directory..."
git clone --depth=1 "$REPO_URL" "$temp_dir" > /dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "Failed to clone the repository. Please check your internet connection."
    rm -rf "$temp_dir"
    exit 1
fi

# Find available assignments
assignments_dir="$temp_dir/$ASSIGNMENT_PATH"
if [ ! -d "$assignments_dir" ]; then
    echo "Could not find the assignments directory in the repository."
    echo "The repository structure may have changed. Please contact your instructor."
    rm -rf "$temp_dir"
    exit 1
fi

assignments=$(find "$assignments_dir" -mindepth 1 -maxdepth 1 -type d -exec basename {} \;)
if [ -z "$assignments" ]; then
  echo "No assignments found in the repository."
  rm -rf "$temp_dir"
  exit 1
fi

# Ask the user to select an assignment
echo ""
echo "Please select the assignment you want to refresh:"
select assignment in $assignments; do
  if [ -n "$assignment" ]; then
    echo "You selected: $assignment"
    break
  else
    echo "Invalid selection. Please try again."
  fi
done

# Ask about wiping the directory
echo ""
echo "WARNING: This will copy the original assignment files into your workspace."
read -p "Do you want to DELETE the existing '$assignment' directory first? This will erase any work you have in it. (y/n): " wipe_choice
wipe_choice=${wipe_choice,,}

# Copy the files
if [[ "$wipe_choice" == "y" ]]; then
  if [ -d "/workspace/$assignment" ]; then
    echo "Removing existing directory: /workspace/$assignment"
    rm -rf "/workspace/$assignment"
  fi
fi

echo "Copying assignment files to /workspace/$assignment..."
cp -r "$temp_dir/$ASSIGNMENT_PATH/$assignment" /workspace/
if [ $? -eq 0 ]; then
  echo "Assignment '$assignment' has been successfully refreshed."
else
  echo "An error occurred while copying the files."
fi


# Clean up
rm -rf "$temp_dir"
echo "Operation completed."
