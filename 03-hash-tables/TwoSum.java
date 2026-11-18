import java.util.HashMap;
import java.util.Map;

/**
 * Hash Table: Two Sum
 *
 * Problem: Return the indices of the two numbers in nums that add up to target.
 *          Exactly one solution exists; do not use the same element twice.
 * Pattern: Hash map of "value -> index" (complement lookup).
 * Time: O(n) | Space: O(n)
 *
 * Insight: For each number, the partner you need is target - number.
 *          Look it up before inserting the current number, so an element cannot pair with itself.
 *          Brute force checks every pair in O(n^2).
 */
public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        check(java.util.Arrays.equals(twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}), "basic");
        check(java.util.Arrays.equals(twoSum(new int[] {3, 2, 4}, 6), new int[] {1, 2}), "does not reuse an element");
        check(java.util.Arrays.equals(twoSum(new int[] {3, 3}, 6), new int[] {0, 1}), "duplicates");
        check(twoSum(new int[] {1, 2}, 10).length == 0, "no answer");
        System.out.println("TwoSum: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
