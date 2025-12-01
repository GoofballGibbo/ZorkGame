#!/bin/bash

# Path where the accidental folder lives
BAD_DIR="src/main/java/Main/java"

# Path where everything should go
GOOD_DIR="src/main/java"

# Check folder exists
if [ ! -d "$BAD_DIR" ]; then
    echo "No broken folder found at $BAD_DIR"
    exit 1
fi

echo "Fixing folder structure..."
echo "Moving packages out of:  $BAD_DIR"
echo "Into correct location:   $GOOD_DIR"
echo

# Move each subfolder inside the broken directory up one level
for folder in "$BAD_DIR"/*; do
    if [ -d "$folder" ]; then
        base=$(basename "$folder")
        echo "→ Moving $base ..."
        mv "$folder" "$GOOD_DIR/$base"
    fi
done

# Remove the now-empty folder tree
echo
echo "Removing broken directories..."
rmdir "$BAD_DIR"
rmdir "src/main/java/Main" 2>/dev/null || true

echo
echo "Folder repair complete!"
echo "Your new structure is:"
echo
tree src/main/java || ls -R src/main/java
