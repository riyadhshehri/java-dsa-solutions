# Trees and Binary Search Trees

A binary tree node has up to two children. In a **binary search tree (BST)**, everything in the left subtree is smaller than the node and everything in the right subtree is larger.

## Concepts

**Recursion on trees.** Solve the problem for the left subtree and the right subtree, then combine. A `null` node is the base case.

**In-order traversal.** Left, node, right. On a BST this visits values in ascending order, which is why "k-th smallest" is a walk that stops early.

**Balanced tree.** The two subtrees of every node differ in height by at most 1. Building from the middle of a sorted array gives one. Inserting sorted values one by one gives a chain.

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `InvertBinaryTree.java` | Invert both children, then swap | O(n) / O(h) |
| `SortedArrayToBst.java` | The middle element is the root | O(n) / O(log n) |
| `KthSmallestInBst.java` | Iterative in-order with a stack, stop at k | O(h + k) / O(h) |

`TreeNode.java` is the node class shared by all three, with small helpers used in the tests.

## Takeaways

- `h` is the tree height: about log n when balanced, up to n when it is a chain.
- An in-order walk of a BST gives sorted order. Use it whenever the question is about order.
- Compute `mid = left + (right - left) / 2` to avoid integer overflow on very large ranges.
