#!/bin/bash
# This script is a wrapper that calls the centralized submit-to-chatbot.sh script.
"$(dirname "$0")/../../bin/submit-to-chatbot.sh" "$@"
