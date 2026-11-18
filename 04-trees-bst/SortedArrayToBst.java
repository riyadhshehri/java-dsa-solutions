/**
 * BST: Convert a Sorted Array to a Height-Balanced BST
 *
 * Problem: Build a binary search tree from a sorted array so the left and right
 *          subtrees of every node differ in height by at most 1.
 * Pattern: Divide and conquer (pick the middle as the root).
 * Time: O(n) | Space: O(log n) recursion depth
 *
 * Insight: The middle element makes half of the values smaller and half larger,
 *          so it is the root. Repeat on the left half and the right half.
 *          Inserting a sorted array one by one would build a linked list, not a balanced tree.
 */
public class SortedArrayToBst {

    static TreeNode sortedArrayToBst(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }

    static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    static boolean balanced(TreeNode n) {
        if (n == null) return true;
        return Math.abs(height(n.left) - height(n.right)) <= 1 && balanced(n.left) && balanced(n.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9, 11, 14};
        TreeNode root = sortedArrayToBst(nums);

        check(TreeNode.inOrder(root).equals("-10 -3 0 5 9 11 14"), "in-order matches the input");
        check(balanced(root), "height balanced");
        check(root.value == 5, "root is the middle");
        check(sortedArrayToBst(new int[] {}) == null, "empty");

        System.out.println("SortedArrayToBst: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
