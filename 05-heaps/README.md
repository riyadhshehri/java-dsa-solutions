# Heaps

A **heap** keeps its largest value (max heap) or smallest value (min heap) at the top. Reading the top is O(1). Adding or removing is O(log n). Java's `PriorityQueue` is a min heap by default; pass `Collections.reverseOrder()` for a max heap.

## Concepts

**Top-k with a bounded heap.** To find the k-th smallest value, keep only the k smallest values seen so far in a max heap. When it grows past k, remove the top. After one pass, the top is the answer. It costs O(n log k) instead of sorting everything.

**Running maximum.** A max heap answers "what is the largest value so far?" after every insert. A plain variable does the same job if you never remove anything. The heap pays off when you also need the next largest.

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `KthSmallestElement.java` | Max heap capped at size k | O(n log k) / O(k) |
| `MaxElementInStream.java` | Peek the max heap after each insert | O(n log n) / O(n) |

## Takeaways

- Use the opposite kind of heap from what you want to find: a max heap to keep the k smallest.
- `peek()` reads the top without removing it. `poll()` removes it.
