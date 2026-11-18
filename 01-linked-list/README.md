# Linked Lists

A linked list stores values in nodes, each pointing to the next. There is no index, so you reach the middle by walking. Most problems here are solved by walking smartly with two pointers, or by rewiring `next` links in place.

## Concepts

**Fast and slow pointers.** `fast` moves two steps while `slow` moves one. When `fast` reaches the end, `slow` is at the middle. If the list has a cycle, `fast` catches `slow`.

**Gap between pointers.** Move one pointer `k` steps ahead, then move both. When the front pointer falls off the end, the back one is `k` from the end.

**Dummy head.** A throwaway node in front of the real head removes the special case where the first node changes.

**Runner.** For each node, a second pointer scans everything after it. It costs O(n²) time but needs no extra memory.

**Doubly linked list.** Each node also has `prev`, so you can walk backwards. When swapping `next` and `prev` while reversing, the old next ends up in `prev`, so that is where the walk continues.

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `FindMiddleNode.java` | fast and slow | O(n) / O(1) |
| `HasLoop.java` | fast catches slow if there is a cycle | O(n) / O(1) |
| `FindKthFromEnd.java` | fixed gap between two pointers | O(n) / O(1) |
| `RemoveDuplicates.java` | runner unlinks matches | O(n²) / O(1) |
| `ReverseBetween.java` | dummy head, move nodes to the front of the region | O(n) / O(1) |
| `DoublyLinkedList.java` | palindrome check, reverse, partition | O(n) / O(1) |

`ListNode.java` is the node class shared by the singly linked problems.

## Takeaways

- Draw the nodes and arrows on paper before you write the pointer assignments.
- The order of pointer assignments matters. Save the next node before you overwrite a link.
- Guard against `null` before dereferencing `fast.next`.
