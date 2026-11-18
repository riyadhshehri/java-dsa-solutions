import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Heap: Maximum Element in a Stream
 *
 * Problem: Values arrive one at a time. After each value, report the largest value seen so far.
 * Pattern: Max heap (PriorityQueue with reverse order).
 * Time: O(n log n) | Space: O(n)
 *
 * Insight: A max heap keeps the largest value on top, so peek() is O(1) and each insert is O(log n).
 *          If you only need the maximum and never remove anything, a single "max" variable is
 *          O(1) per value; the heap becomes necessary once you also need the next largest.
 */
public class MaxElementInStream {

    static List<Integer> maxAfterEach(int[] stream) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();

        for (int value : stream) {
            maxHeap.add(value);
            result.add(maxHeap.peek());
        }
        return result;
    }

    public static void main(String[] args) {
        check(maxAfterEach(new int[] {1, 3, 2, 5, 4}).equals(List.of(1, 3, 3, 5, 5)), "mixed");
        check(maxAfterEach(new int[] {5, 4, 3}).equals(List.of(5, 5, 5)), "descending");
        check(maxAfterEach(new int[] {}).isEmpty(), "empty");

        System.out.println("MaxElementInStream: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
