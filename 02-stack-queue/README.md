# Stacks and Queues

A **stack** is last in, first out: the most recent item leaves first (a pile of plates). A **queue** is first in, first out: the oldest item leaves first (a line at a shop).

## Concepts

**Stack as memory of "what is still open".** Push when something opens, pop when it closes. Unmatched closers and leftovers are both visible at the end.

**Reversing with a second stack.** Moving everything from one stack to another reverses the order. Doing it twice restores it. That is how a queue can be built from two stacks.

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `BalancedParentheses.java` | Push `(`, pop on `)`, stack must end empty | O(n) / O(n) |
| `SortStack.java` | Keep a second stack sorted; move larger values back | O(n²) / O(n) |
| `QueueUsingStacks.java` | Reverse twice on enqueue so dequeue is simple | enqueue O(n), dequeue O(1) |

## Takeaways

- Check for an empty stack before `pop()` or `peek()`.
- In `QueueUsingStacks`, the cost moves to enqueue. A lazy-transfer version makes both operations O(1) amortized.
- `SortStack` leaves the smallest value on top. Change one comparison to flip the order.
