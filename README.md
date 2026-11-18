# Java DSA Solutions

25 data structures and algorithms problems solved in plain Java, each in one file you can compile and run. Every file states the problem, the pattern, the time and space cost, and the one insight that makes the solution work.

I wrote these while working through a Java DSA course. They are small on purpose: you can read a file in two minutes and run it in ten seconds. Each folder also has its own README that explains the concepts behind its problems, so you can start from zero.

## Who this is for

Beginners who know basic Java (classes, arrays, loops) and want to see how the classic patterns look in real code. It is not a replacement for solving problems yourself.

## How to use it

1. Open a folder and read its `README.md` for the concepts.
2. Read a problem's header comment, then close the file and try it yourself.
3. Compare with the solution, run it, and change the test cases to break it.

## How to run

You need JDK 17 or newer (I tested with Java 21).

Run everything:

```bash
./run-all.sh
```

Or run a single problem:

```bash
cd 06-arrays
javac MaxProfit.java
java MaxProfit
```

Each file's `main` method contains its own test cases and prints `all checks passed`, or throws an `AssertionError` naming the failing case. There is no build tool and no test framework to install.

## Suggested study order

Start with arrays and two pointers, then move toward structures that need more pointer work.

1. [`06-arrays`](06-arrays): two pointers, Kadane's algorithm, reversal tricks
2. [`03-hash-tables`](03-hash-tables): trade memory for speed with maps and sets
3. [`02-stack-queue`](02-stack-queue): last in first out, first in first out, and how to build one from the other
4. [`01-linked-list`](01-linked-list): dummy nodes, fast and slow pointers, in-place rewiring
5. [`04-trees-bst`](04-trees-bst): recursion, in-order traversal
6. [`05-heaps`](05-heaps): priority queues and top-k problems

## Problems by pattern

| Pattern | Problems | Where |
|---|---|---|
| Two pointers (read/write index) | Remove Element, Remove Duplicates (sorted array) | `06-arrays` |
| Single pass with a running value | Max Profit, Maximum Subarray (Kadane), Find Max and Min | `06-arrays` |
| Reversal | Rotate Array | `06-arrays` |
| Hash map lookup | Two Sum, Group Anagrams | `03-hash-tables` |
| Hash set | Longest Consecutive Sequence | `03-hash-tables` |
| Stack | Balanced Parentheses, Sort a Stack | `02-stack-queue` |
| Two stacks | Queue Using Stacks | `02-stack-queue` |
| Fast and slow pointers | Find Middle Node, Has Loop, Find Kth From End | `01-linked-list` |
| Dummy head | Reverse Between, Partition List | `01-linked-list` |
| Runner technique | Remove Duplicates (linked list) | `01-linked-list` |
| Doubly linked list | Palindrome check, Reverse, Partition | `01-linked-list` |
| Recursion on trees | Invert Binary Tree, Sorted Array to BST | `04-trees-bst` |
| In-order traversal | Kth Smallest in a BST | `04-trees-bst` |
| Heap | Kth Smallest Element, Max Element in a Stream | `05-heaps` |

The doubly linked list file (`DoublyLinkedList.java`) holds three problems, which is why the count is 25 problems in 23 runnable files.

## How each file is laid out

```java
/**
 * Array: Best Time to Buy and Sell Stock
 *
 * Problem: ...one or two sentences...
 * Pattern: ...
 * Time: O(n) | Space: O(1)
 *
 * Insight: ...why it works...
 */
```

Then the solution, then a `main` with test cases. Where a common mistake exists, there is a `Pitfall:` line.

## Credit

The problem set follows the structure of Scott Barrett's *Data Structures & Algorithms: Java* course on Udemy, which I completed in November 2026. The code and write-ups here are my own. If you want the full explanations behind these patterns, take the course.

## License

MIT. See `LICENSE`.
