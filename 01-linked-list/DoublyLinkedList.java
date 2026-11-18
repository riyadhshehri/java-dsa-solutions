/**
 * Linked List: Doubly linked list problems (isPalindrome, reverse, partitionList)
 *
 * Time / Space per method:
 *   isPalindrome  O(n) / O(1)
 *   reverse       O(n) / O(1)
 *   partitionList O(n) / O(1)
 */
public class DoublyLinkedList {

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int length;

    void append(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        length++;
    }

    static DoublyLinkedList of(int... values) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int v : values) list.append(v);
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node n = head; n != null; n = n.next) {
            sb.append(n.value);
            if (n.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    // ------------------------------------------------------------------
    // Palindrome Checker
    // Problem: Is the list the same read forwards and backwards?
    // Insight: prev makes this O(1) space. Walk one pointer from head and one from tail,
    //          and compare length / 2 pairs. The middle node of an odd list needs no comparison.
    //          (A singly linked list needs the middle found with slow/fast and the second half reversed.)
    // ------------------------------------------------------------------
    boolean isPalindrome() {
        if (length <= 1) return true;

        Node forward = head;
        Node backward = tail;

        for (int i = 0; i < length / 2; i++) {
            if (forward.value != backward.value) return false;
            forward = forward.next;
            backward = backward.prev;
        }
        return true;
    }

    // ------------------------------------------------------------------
    // Reverse
    // Problem: Reverse the list in place.
    // Pitfall: After swapping next and prev on a node, "current.next" no longer points forward.
    //          The old next is now stored in current.prev, so that is where the walk continues.
    // ------------------------------------------------------------------
    void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // the old next, before the swap
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // ------------------------------------------------------------------
    // Partition List
    // Problem: Move every value < x before every value >= x, keeping relative order inside each group (stable).
    // Insight: Build two sub-lists behind two dummy heads, one for "< x" and one for ">= x",
    //          in a single pass, then join them. Dummy heads remove all "what if it is the first node" cases.
    // ------------------------------------------------------------------
    void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0); // values < x
        Node dummy2 = new Node(0); // values >= x
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = null;
            current.prev = null;

            if (current.value < x) {
                prev1.next = current;
                current.prev = prev1;
                prev1 = current;
            } else {
                prev2.next = current;
                current.prev = prev2;
                prev2 = current;
            }
            current = next;
        }

        if (dummy2.next != null) {
            prev1.next = dummy2.next;
            dummy2.next.prev = prev1;
            tail = prev2;
        } else {
            tail = prev1;
        }

        head = dummy1.next != null ? dummy1.next : dummy2.next;
        if (head != null) head.prev = null;
    }

    public static void main(String[] args) {
        check(of().isPalindrome(), "empty list is a palindrome");
        check(of(1, 2, 3, 2, 1).isPalindrome(), "odd palindrome");
        check(of(1, 2, 2, 1).isPalindrome(), "even palindrome");
        check(!of(1, 2, 3).isPalindrome(), "not a palindrome");

        DoublyLinkedList r = of(1, 2, 3, 4);
        r.reverse();
        check(r.toString().equals("[4, 3, 2, 1]"), "reverse");
        check(r.head.value == 4 && r.tail.value == 1, "reverse swaps head and tail");
        check(r.tail.prev.value == 2, "reverse keeps prev links valid");

        DoublyLinkedList p = of(3, 8, 5, 10, 2, 1);
        p.partitionList(5);
        check(p.toString().equals("[3, 2, 1, 8, 5, 10]"), "partition is stable");
        check(p.tail.value == 10 && p.head.prev == null, "partition fixes head and tail");

        System.out.println("DoublyLinkedList: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
