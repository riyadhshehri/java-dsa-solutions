import java.util.Stack;

/**
 * Queue: Implement a Queue Using Two Stacks
 *
 * Problem: Build a FIFO queue with enqueue, dequeue and peek using only stacks.
 * Pattern: Two stacks, reversing order twice.
 * Time: enqueue O(n), dequeue O(1), peek O(1) | Space: O(n)
 *
 * Insight: stack1 always holds the elements with the oldest on top.
 *          To enqueue, move everything to stack2, push the new value on stack1,
 *          then move everything back. This keeps dequeue trivial.
 * Trade-off: The alternative (lazy transfer on dequeue) makes enqueue O(1) and
 *            dequeue O(1) amortized. This version favors simple reads.
 */
public class QueueUsingStacks {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    Integer dequeue() {
        return stack1.isEmpty() ? null : stack1.pop();
    }

    Integer peek() {
        return stack1.isEmpty() ? null : stack1.peek();
    }

    boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        check(q.isEmpty() && q.dequeue() == null && q.peek() == null, "empty queue");

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        check(q.peek() == 1, "peek returns the oldest");
        check(q.dequeue() == 1, "FIFO 1");
        q.enqueue(4);
        check(q.dequeue() == 2, "FIFO 2");
        check(q.dequeue() == 3, "FIFO 3");
        check(q.dequeue() == 4, "FIFO 4");
        check(q.isEmpty(), "empty again");

        System.out.println("QueueUsingStacks: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
