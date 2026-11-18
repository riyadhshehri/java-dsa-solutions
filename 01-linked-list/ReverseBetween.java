/**
 * Linked List: Reverse Between
 *
 * Problem: Reverse the nodes of a singly linked list from startIndex to endIndex (0-based, inclusive).
 * Pattern: Dummy head + in-place pointer rewiring.
 * Time: O(n) | Space: O(1)
 *
 * Insight: A dummy node in front of head removes the special case where startIndex = 0.
 *          prev stops right before the reversed region. Then, endIndex - startIndex times,
 *          take the node after current and move it to the front of the region.
 */
public class ReverseBetween {

    static ListNode reverseBetween(ListNode head, int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev ends up on the node just before the reversed region
        ListNode prev = dummy;
        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        // first node of the region; it drifts toward the back as nodes move in front of it
        ListNode current = prev.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            ListNode nodeToMove = current.next;
            current.next = nodeToMove.next;   // detach nodeToMove
            nodeToMove.next = prev.next;      // put it at the front of the region
            prev.next = nodeToMove;           // prev now points at it
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = reverseBetween(ListNode.of(1, 2, 3, 4, 5), 2, 4);
        check(ListNode.toString(a).equals("[1, 2, 5, 4, 3]"), "middle to end");

        ListNode b = reverseBetween(ListNode.of(1, 2, 3, 4, 5), 0, 4);
        check(ListNode.toString(b).equals("[5, 4, 3, 2, 1]"), "whole list (startIndex = 0)");

        ListNode c = reverseBetween(ListNode.of(1, 2, 3), 1, 1);
        check(ListNode.toString(c).equals("[1, 2, 3]"), "single position");

        System.out.println("ReverseBetween: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
