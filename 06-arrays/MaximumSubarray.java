/**
 * Array: Maximum Subarray (Kadane's algorithm)
 *
 * Problem: Return the largest sum of any contiguous, non-empty subarray.
 * Pattern: Dynamic programming in one pass (Kadane).
 * Time: O(n) | Space: O(1)
 *
 * Insight: At each element, either start a new subarray here or extend the previous one.
 *          currentSum = max(nums[i], currentSum + nums[i]).
 *          A negative running sum can only hurt, so it is dropped.
 * Pitfall: Initialize with nums[0], not 0, or an all-negative array returns the wrong answer.
 */
public class MaximumSubarray {

    static int maxSubarray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        check(maxSubarray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6, "classic (4, -1, 2, 1)");
        check(maxSubarray(new int[] {-3, -1, -2}) == -1, "all negative");
        check(maxSubarray(new int[] {5}) == 5, "single");
        check(maxSubarray(new int[] {1, 2, 3}) == 6, "all positive");

        System.out.println("MaximumSubarray: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
