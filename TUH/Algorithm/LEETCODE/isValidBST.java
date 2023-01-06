/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root);
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        while (left != null) {
            if (root.val <= left.val) {
                return false;
            }
            left = left.right;
        }

        TreeNode right = root.right;
        while (right != null) {
            if (root.val >= right.val) {
                return false;
            }
            right = right.left;
        }

        if (root.right != null) {

        }

        return isValidBSTRecursive(root.left) && isValidBSTRecursive(root.right);
    }
}
