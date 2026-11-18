/**
 * Array: Remove Duplicates from a Sorted Array
 *
 * Problem: Remove duplicates in place from a sorted array so each value appears once.
 *          Return the new length k; the first k elements hold the unique values in order.
 * Pattern: Read index / write index (two pointers).
 * Time: O(n) | Space: O(1)
 *
 * Insight: Because the array is sorted, duplicates sit next to each other. Compare each
 *          element with the last value written; copy it only when it is different.
 */
public class RemoveDuplicatesSorted {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int write = 1;

        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(a);
        check(k == 5, "length");
        for (int i = 0; i < 5; i++) check(a[i] == i, "value at " + i);

        check(removeDuplicates(new int[] {}) == 0, "empty");
        check(removeDuplicates(new int[] {7}) == 1, "single");

        System.out.println("RemoveDuplicatesSorted: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
