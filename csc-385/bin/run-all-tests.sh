#!/bin/bash
echo "Searching for all directories in the current workspace..."
mapfile -t directories < <(find . -maxdepth 1 -type d -not -name ".*" -not -name "bin" -print0 | xargs -0 -n1)

for dir in "${directories[@]}"; do
  if [ -d "$dir" ]; then
    echo ""
    echo "Processing directory: $dir"
    cd "$dir"

    # Delete all .class files
    echo "Deleting all .class files..."
    find . -name "*.class" -type f -delete

    # Delete previous test results
    echo "Removing previous test results..."
    rm -f test-results.txt

    # Run compile.sh
    echo "Compiling Java files..."
    compile.sh

    # Run tests
    echo "Running tests..."
    run-tests.sh

    # Print test results
    echo "Displaying test results for: $dir"
    if [ -f test-results.txt ]; then
      cat test-results.txt
    else
      echo "No test results found."
    fi

    # Pause and wait for input before proceeding
    echo ""
    echo "Press Enter to continue to the next directory..."
    read -r

    # Move back to the original directory
    cd ..
  fi
done

echo "All tests completed."
