#!/bin/bash
echo "Running JUnit tests..."
java -jar /opt/junit/junit-platform-console-standalone.jar --class-path . --scan-class-path > test-results.txt
echo "Tests completed. Results saved to test-results.txt."
