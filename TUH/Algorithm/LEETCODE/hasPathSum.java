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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return pathSum(root, targetSum, 0);
    }

    public boolean pathSum(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null &&targetSum == sum + root.val) {
            return true;
        }

        boolean leftSum = false; 
        boolean rightSum = false;
        if (root.left != null) {
            leftSum = pathSum(root.left, targetSum, sum + root.val);
        }

        if (root.right != null) {
            rightSum = pathSum(root.right, targetSum, sum + root.val);
        }
 

        if (leftSum || rightSum) {
            return true;
        }
        return false;
    }
}
