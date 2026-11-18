import java.util.Stack;

/**
 * BST: Kth Smallest Node
 *
 * Problem: Return the k-th smallest value in a binary search tree (k is 1-based).
 *          Return null if the tree has fewer than k nodes.
 * Pattern: Iterative in-order traversal with a stack, stop early.
 * Time: O(h + k) | Space: O(h), where h is the tree height
 *
 * Insight: An in-order walk of a BST visits values in ascending order, so the
 *          k-th node visited is the answer. Stopping at k avoids walking the rest.
 */
public class KthSmallestInBst {

    static Integer kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {      // go as far left as possible
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();         // next smallest value
            k--;
            if (k == 0) {
                return current.value;
            }

            current = current.right;       // then explore its right subtree
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        for (int v : new int[] {5, 3, 8, 2, 4, 7, 9}) root = TreeNode.insert(root, v);

        check(kthSmallest(root, 1) == 2, "k = 1");
        check(kthSmallest(root, 4) == 5, "k = 4");
        check(kthSmallest(root, 7) == 9, "k = n");
        check(kthSmallest(root, 8) == null, "k > n");
        check(kthSmallest(null, 1) == null, "empty tree");

        System.out.println("KthSmallestInBst: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
