import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Heap: Kth Smallest Element in an Array
 *
 * Problem: Return the k-th smallest value of an unsorted array (k is 1-based).
 * Pattern: Max heap bounded to size k.
 * Time: O(n log k) | Space: O(k)
 *
 * Insight: Keep the k smallest values seen so far in a max heap. When the heap grows past k,
 *          remove its largest value. After one pass, the top of the heap is the k-th smallest.
 *          Sorting works too (O(n log n)); the heap wins when k is much smaller than n.
 */
public class KthSmallestElement {

    static Integer kthSmallest(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return null;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // drop the largest
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};

        check(kthSmallest(nums, 1) == 3, "k = 1");
        check(kthSmallest(nums, 3) == 7, "k = 3");
        check(kthSmallest(nums, 6) == 20, "k = n");
        check(kthSmallest(nums, 7) == null, "k > n");
        check(kthSmallest(new int[] {2, 2, 2}, 2) == 2, "duplicates");

        System.out.println("KthSmallestElement: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
