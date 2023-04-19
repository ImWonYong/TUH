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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        
        return dfs(root, -1, 0);
    }
    // dir이 -1이면 root에서 온 것 dir 0 왼쪽 1 오른쪽
    public int dfs(TreeNode node, int dir, int zig) {
        if (node == null) {
            return zig;
        }
        int max;
        if (dir == -1) {
            max = Math.max(dfs(node.left, 0, zig), dfs(node.right, 1, zig));
        }
        else if (dir == 0) {
            max = Math.max(dfs(node.left, 0, 0), dfs(node.right, 1, zig + 1));
        } else {
            max = Math.max(dfs(node.left, 0, zig + 1), dfs(node.right, 1, 0));
        }
        
        return max;
    }
}