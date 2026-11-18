/**
 * Linked List: Remove Duplicates
 *
 * Problem: Remove duplicate values from a singly linked list in place,
 *          keeping the first occurrence and the original order.
 *          No extra data structures.
 * Pattern: Runner technique (two pointers).
 * Time: O(n^2) | Space: O(1)
 *
 * Insight: For each node (current), a runner scans everything after it.
 *          When runner.next matches current, unlink it with runner.next = runner.next.next.
 *          Advance runner only when nothing was deleted, otherwise consecutive duplicates get skipped.
 *          A HashSet would make this O(n) time at the cost of O(n) space.
 */
public class RemoveDuplicates {

    static void removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode current = head;

        while (current != null) {
            ListNode runner = current;

            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next; // unlink the duplicate
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = ListNode.of(1, 2, 1, 3, 2, 2, 4);
        removeDuplicates(list);
        check(ListNode.toString(list).equals("[1, 2, 3, 4]"), "mixed duplicates");

        ListNode same = ListNode.of(5, 5, 5, 5);
        removeDuplicates(same);
        check(ListNode.toString(same).equals("[5]"), "all equal");

        System.out.println("RemoveDuplicates: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
