import java.util.Arrays;

/**
 * Array: Rotate Array
 *
 * Problem: Rotate nums to the right by k steps, in place.
 * Pattern: Three reversals.
 * Time: O(n) | Space: O(1)
 *
 * Insight: Rotating right by k moves the last k elements to the front.
 *          Reverse the whole array, then reverse the first k elements, then the rest.
 *          [1,2,3,4,5,6,7], k = 3 -> [7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
 * Pitfall: k can be larger than the length, so use k %= n first.
 */
public class RotateArray {

    static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        check(Arrays.equals(a, new int[] {5, 6, 7, 1, 2, 3, 4}), "k = 3");

        int[] b = {1, 2, 3};
        rotate(b, 4);
        check(Arrays.equals(b, new int[] {3, 1, 2}), "k larger than length");

        int[] c = {1, 2, 3};
        rotate(c, 0);
        check(Arrays.equals(c, new int[] {1, 2, 3}), "k = 0");

        System.out.println("RotateArray: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
