/**
 * Array: Find Max and Min
 *
 * Problem: Return the largest and smallest values of a non-empty array in one pass.
 * Pattern: Single pass with two trackers.
 * Time: O(n) | Space: O(1)
 *
 * Insight: Start both trackers at the first element, not at 0 or MAX_VALUE guesses,
 *          so negative numbers and single-element arrays behave correctly.
 */
public class FindMaxMin {

    /** Returns {max, min}. */
    static int[] findMaxMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        return new int[] {max, min};
    }

    public static void main(String[] args) {
        int[] r = findMaxMin(new int[] {4, -2, 9, 0, 7});
        check(r[0] == 9 && r[1] == -2, "mixed values");

        int[] one = findMaxMin(new int[] {5});
        check(one[0] == 5 && one[1] == 5, "single element");

        int[] neg = findMaxMin(new int[] {-5, -9, -1});
        check(neg[0] == -1 && neg[1] == -9, "all negative");

        System.out.println("FindMaxMin: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
