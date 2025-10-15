#!/bin/bash
echo "Compiling all Java files under ./src, ./test and their subdirectories..."
find ./src ./test -name "*.java" > sources.txt
javac -d . @sources.txt
if [ $? -eq 0 ]; then
  echo "Compilation complete."
else
  echo "Compilation failed. Please check for errors."
  exit 1
fi
