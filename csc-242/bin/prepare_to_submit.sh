#!/bin/bash
echo "Preparing submission..."
run-tests.sh
if grep -q "FAILURE" test-results.txt; then
  echo "Tests failed. Fix your code before submission!"
  exit 1
fi
zip -r /workspace/Assignment.zip . Dockerfile
echo "Submission package created: Assignment.zip"
