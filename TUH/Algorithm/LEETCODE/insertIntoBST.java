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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null) {
            findInsertPosition(root, val, new TreeNode(val));
            return root;
        } else {
            return new TreeNode(val);
        }
    }

    public void findInsertPosition(TreeNode root, int val, TreeNode newNode) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = newNode;
                return;
            }
            findInsertPosition(root.left, val, newNode);
        } else {
            if (root.right == null) {
                root.right = newNode;
                return;
            }
            findInsertPosition(root.right, val, newNode);
        }
    }
}
