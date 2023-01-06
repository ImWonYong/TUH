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
    List<TreeNode> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int i = 0;
        int j = list.size() - 1;

        while(i < j) {
            int sum = list.get(i).val + list.get(j).val;

            if (sum == k) return true;

            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}

