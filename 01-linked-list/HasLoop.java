/**
 * Linked List: Has Loop
 *
 * Problem: Detect whether a singly linked list contains a cycle.
 * Pattern: Fast & slow pointers (Floyd's cycle detection).
 * Time: O(n) | Space: O(1)
 *
 * Insight: If there is a cycle, fast eventually laps slow and they meet.
 *          If there is no cycle, fast reaches null first.
 */
public class HasLoop {

    static boolean hasLoop(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        check(!hasLoop(null), "empty list");
        check(!hasLoop(ListNode.of(1, 2, 3, 4)), "no cycle");

        ListNode head = ListNode.of(1, 2, 3, 4);
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = head.next; // 4 -> 2 creates a cycle
        check(hasLoop(head), "cycle");

        System.out.println("HasLoop: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
