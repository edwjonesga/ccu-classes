#!/bin/bash
echo "Downloading new Dockerfile..."
curl -L -o /workspace/Dockerfile "https://raw.githubusercontent.com/edwjonesga/assignment-tools/refs/heads/main/Dockerfile"
if [ $? -eq 0 ]; then
  echo "Dockerfile updated successfully."
  echo "Please exit the container, rebuild it with commands from the assignment page."
else
  echo "Failed to download the new Dockerfile. Please check the link or your connection."
fi
