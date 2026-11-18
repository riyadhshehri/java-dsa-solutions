/**
 * Array: Remove Element
 *
 * Problem: Remove every occurrence of val from nums in place. Return the new length k;
 *          the first k elements must be the kept values (their order may be anything).
 * Pattern: Read index / write index (two pointers).
 * Time: O(n) | Space: O(1)
 *
 * Insight: The read index scans every element. The write index marks where the next kept
 *          value goes. Copy only elements that differ from val.
 */
public class RemoveElement {

    static int removeElement(int[] nums, int val) {
        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        int k = removeElement(a, 3);
        check(k == 2 && a[0] == 2 && a[1] == 2, "basic");

        int[] b = {1, 2, 3};
        check(removeElement(b, 9) == 3, "value not present");

        int[] c = {4, 4, 4};
        check(removeElement(c, 4) == 0, "everything removed");

        System.out.println("RemoveElement: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
