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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        preorderTraversalRecursive(root, result);

        return result;
    }

    public void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);

        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }
}
