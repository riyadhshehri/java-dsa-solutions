# Hash Tables

A hash map stores key-value pairs and finds a key in O(1) on average. A hash set stores only keys. They trade memory for speed: you spend O(n) space to avoid a second loop.

## Concepts

**Complement lookup.** Instead of searching the array for the partner of each value, store what you have seen and ask the map in O(1).

**Canonical key.** Map different-looking inputs that mean the same thing to one key. Anagrams share the same sorted letters.

**Start of a run.** In a set, a value starts a consecutive run only if `value - 1` is absent. Counting only from run starts keeps the whole thing linear.

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `TwoSum.java` | Look up `target - n` before inserting `n` | O(n) / O(n) |
| `GroupAnagrams.java` | Sorted letters are the key | O(n · k log k) / O(n · k) |
| `LongestConsecutiveSequence.java` | Count only from the start of a run | O(n) / O(n) |

## Takeaways

- Check the map before inserting the current value, so an element cannot pair with itself.
- `computeIfAbsent` removes the "does this key exist yet" branch.
- A nested loop over an array is a hint to ask whether a map could answer the inner question.
