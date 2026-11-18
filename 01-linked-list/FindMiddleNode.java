/**
 * Linked List: Find Middle Node
 *
 * Problem: Return the middle node of a singly linked list without knowing its length.
 *          For an even length, return the second of the two middle nodes.
 * Pattern: Fast & slow pointers.
 * Time: O(n) | Space: O(1)
 *
 * Insight: fast moves two steps for every one step of slow.
 *          When fast reaches the end, slow is at the middle.
 */
public class FindMiddleNode {

    static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        check(findMiddle(null) == null, "empty list");
        check(findMiddle(ListNode.of(1)).value == 1, "one node");
        check(findMiddle(ListNode.of(1, 2, 3)).value == 2, "odd length");
        check(findMiddle(ListNode.of(1, 2, 3, 4)).value == 3, "even length returns the second middle");
        System.out.println("FindMiddleNode: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
