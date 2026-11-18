/**
 * Linked List: Find Kth Node From End
 *
 * Problem: Return the k-th node from the end of a singly linked list (k is 1-based).
 *          k = 1 is the tail. k <= 0 or k > length returns null.
 *          No length field is available, and the list may be traversed only once.
 * Pattern: Two pointers with a fixed gap.
 * Time: O(n) | Space: O(1)
 *
 * Insight: Move fast k steps ahead first. Then move both pointers together.
 *          When fast falls off the list, slow sits on the k-th node from the end.
 */
public class FindKthFromEnd {

    static ListNode findKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // k is larger than the list
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.of(1, 2, 3, 4, 5);

        check(findKthFromEnd(list, 1).value == 5, "k = 1 is the tail");
        check(findKthFromEnd(list, 2).value == 4, "k = 2");
        check(findKthFromEnd(list, 5).value == 1, "k = length is the head");
        check(findKthFromEnd(list, 6) == null, "k > length");
        check(findKthFromEnd(list, 0) == null, "k = 0");
        check(findKthFromEnd(null, 1) == null, "empty list");

        System.out.println("FindKthFromEnd: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
