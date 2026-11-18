/** Minimal singly linked list node shared by the problems in this folder. */
public class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    /** Builds a list from the given values. Returns null for an empty input. */
    static ListNode of(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode n = head; n != null; n = n.next) {
            sb.append(n.value);
            if (n.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
