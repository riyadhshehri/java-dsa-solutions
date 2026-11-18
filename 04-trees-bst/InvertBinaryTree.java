/**
 * Binary Tree: Invert Binary Tree
 *
 * Problem: Mirror a binary tree: swap the left and right child of every node.
 * Pattern: Recursion (post-order).
 * Time: O(n) | Space: O(h), where h is the tree height (recursion stack)
 *
 * Insight: Invert both subtrees first, then swap them. A null node is the base case.
 */
public class InvertBinaryTree {

    static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        for (int v : new int[] {4, 2, 7, 1, 3, 6, 9}) root = TreeNode.insert(root, v);

        check(TreeNode.inOrder(root).equals("1 2 3 4 6 7 9"), "BST before");
        invert(root);
        check(TreeNode.inOrder(root).equals("9 7 6 4 3 2 1"), "mirrored in-order is reversed");
        check(invert(null) == null, "null tree");

        System.out.println("InvertBinaryTree: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
