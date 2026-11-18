import java.util.Stack;

/**
 * Stack: Balanced Parentheses
 *
 * Problem: Given a string of only '(' and ')', decide whether every opening
 *          parenthesis has a matching closing one in the right order.
 * Pattern: Stack.
 * Time: O(n) | Space: O(n)
 *
 * Insight: Push on '(', pop on ')'. A ')' with an empty stack is unmatched.
 *          At the end the stack must be empty.
 * Note: For a single bracket type a counter is enough (O(1) space).
 *       The stack generalizes to '[]{}' as well.
 */
public class BalancedParentheses {

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        check(isBalanced(""), "empty");
        check(isBalanced("(()())"), "nested and sequential");
        check(!isBalanced("(()"), "missing close");
        check(!isBalanced("())"), "extra close");
        check(!isBalanced(")("), "wrong order");
        System.out.println("BalancedParentheses: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
