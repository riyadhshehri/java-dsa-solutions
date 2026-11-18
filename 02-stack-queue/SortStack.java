import java.util.Stack;

/**
 * Stack: Sort a Stack
 *
 * Problem: Sort a stack so the smallest value is on top. Use only one extra stack.
 * Pattern: Auxiliary stack (insertion sort).
 * Time: O(n^2) | Space: O(n)
 *
 * Insight: Keep the helper stack sorted with the smallest at the bottom. For each value
 *          taken from the input, move every larger value from the helper back onto the
 *          input, push the value, and those larger values get processed again later.
 */
public class SortStack {

    static void sortStack(Stack<Integer> input) {
        Stack<Integer> sorted = new Stack<>();

        while (!input.isEmpty()) {
            int temp = input.pop();

            while (!sorted.isEmpty() && sorted.peek() > temp) {
                input.push(sorted.pop());
            }
            sorted.push(temp);
        }

        // the helper has the largest on top; moving back reverses it, so the smallest ends on top
        while (!sorted.isEmpty()) {
            input.push(sorted.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int v : new int[] {4, 1, 3, 2, 5, 2}) s.push(v);

        sortStack(s);

        StringBuilder out = new StringBuilder();
        while (!s.isEmpty()) out.append(s.pop()).append(' ');
        check(out.toString().trim().equals("1 2 2 3 4 5"), "pops in ascending order");

        Stack<Integer> empty = new Stack<>();
        sortStack(empty);
        check(empty.isEmpty(), "empty stack");

        System.out.println("SortStack: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
