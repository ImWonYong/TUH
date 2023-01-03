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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) return max;
        int left = max;
        int right = max;
        if (root.left != null) {
            left = dfs(root.left, max + 1);
        }
        if (root.right != null) {
            right = dfs(root.right, max + 1);
        }
        
        return Math.max(left, right);
    }
}
