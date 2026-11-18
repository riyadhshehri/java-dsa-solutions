import java.util.HashSet;
import java.util.Set;

/**
 * Hash Set: Longest Consecutive Sequence
 *
 * Problem: Given an unsorted array, return the length of the longest run of
 *          consecutive integers (for example 100, 4, 200, 1, 3, 2 -> 4, from 1,2,3,4).
 * Pattern: Hash set + only start counting at the beginning of a run.
 * Time: O(n) | Space: O(n)
 *
 * Insight: Sorting would work in O(n log n). With a set, a number is the start of a run
 *          only if (number - 1) is absent. Count upward from each start. Every number is
 *          visited at most twice overall, so the total stays O(n).
 */
public class LongestConsecutiveSequence {

    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) { // start of a run
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        check(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}) == 4, "basic");
        check(longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) == 9, "with duplicates");
        check(longestConsecutive(new int[] {}) == 0, "empty");
        check(longestConsecutive(new int[] {5}) == 1, "single");
        System.out.println("LongestConsecutiveSequence: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
