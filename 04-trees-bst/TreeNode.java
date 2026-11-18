/** Minimal binary tree node shared by the problems in this folder. */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    /** Inserts into a binary search tree (duplicates go right). Returns the root. */
    static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.value) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }

    /** In-order values as a string, for example "1 2 3". */
    static String inOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        walk(root, sb);
        return sb.toString().trim();
    }

    private static void walk(TreeNode n, StringBuilder sb) {
        if (n == null) return;
        walk(n.left, sb);
        sb.append(n.value).append(' ');
        walk(n.right, sb);
    }
}
