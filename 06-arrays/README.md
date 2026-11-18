# Arrays

Arrays give you fast access by index, so most array problems come down to how you walk through them. Three walking styles cover everything in this folder.

## Concepts

**In place** means the answer is written into the original array, with no second array. It keeps space at O(1).

**Read index / write index.** One index scans every element. The other marks where the next kept value goes. The write index never moves ahead of the read index, so it is safe to overwrite.

**Running value.** Carry one or two variables through a single loop instead of comparing every pair. This is how you turn an O(n²) idea into O(n).

## Problems

| File | Idea in one line | Time / Space |
|---|---|---|
| `RemoveElement.java` | Copy only the values you keep | O(n) / O(1) |
| `RemoveDuplicatesSorted.java` | Duplicates are adjacent, so compare with the last value written | O(n) / O(1) |
| `FindMaxMin.java` | Start both trackers at the first element | O(n) / O(1) |
| `MaxProfit.java` | Track the cheapest price so far | O(n) / O(1) |
| `MaximumSubarray.java` | Kadane: start fresh or extend | O(n) / O(1) |
| `RotateArray.java` | Three reversals | O(n) / O(1) |

## Worked example: Kadane on `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`

At each element, `currentSum = max(element, currentSum + element)`.

| Element | currentSum | maxSum |
|---|---|---|
| -2 | -2 | -2 |
| 1 | 1 | 1 |
| -3 | -2 | 1 |
| 4 | 4 | 4 |
| -1 | 3 | 4 |
| 2 | 5 | 5 |
| 1 | 6 | 6 |
| -5 | 1 | 6 |
| 4 | 5 | 6 |

The answer is 6, from `4, -1, 2, 1`. Initialize with `nums[0]`, not 0, or an all-negative array returns the wrong answer.

## Worked example: rotate `[1,2,3,4,5,6,7]` right by 3

1. Reverse everything: `[7,6,5,4,3,2,1]`
2. Reverse the first 3: `[5,6,7,4,3,2,1]`
3. Reverse the rest: `[5,6,7,1,2,3,4]`

Use `k %= n` first, so a `k` larger than the array length still works.

## Takeaways

- Return the new length, not the array, for the remove problems. Only the first `k` elements matter.
- Initialize from the first element rather than from 0 or a guessed extreme.
- If you can solve it with one pass and a couple of variables, do that before reaching for extra memory.
