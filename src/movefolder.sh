#!/bin/zsh

# Go to src/Main
cd src/Main || { echo "Directory src/Main not found"; exit 1; }

# Check if java folder exists
if [ ! -d "java" ]; then
    echo "No java folder found in src/Main. Nothing to move."
    exit 0
fi

# Move all folders from java/ to current directory (src/Main)
for folder in java/*; do
    if [ -d "$folder" ]; then
        echo "Moving $folder to src/Main/"
        mv "$folder" .
    fi
done

# Remove the now-empty java folder
rmdir java
echo "java folder removed."

echo "All folders from java/ have been moved to src/Main/"
