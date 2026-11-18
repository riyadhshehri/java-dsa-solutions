#!/usr/bin/env bash
# Compiles and runs every solution. Each file's main() asserts its own test cases.
set -e
cd "$(dirname "$0")"
for dir in 0*/; do
  out=$(mktemp -d)
  javac -d "$out" "$dir"*.java
  for f in "$dir"*.java; do
    name=$(basename "$f" .java)
    if grep -q "public static void main" "$f"; then
      java -cp "$out" "$name"
    fi
  done
  rm -rf "$out"
done
