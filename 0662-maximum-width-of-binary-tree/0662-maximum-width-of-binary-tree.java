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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> head = queue.peek();
            int size = queue.size();
            Pair<TreeNode, Integer> pair = null;
            int idx = 0;
            for (int i = 0; i < size; i++) {
                pair = queue.remove();
                TreeNode node = pair.getKey();
                
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, 2 * pair.getValue()));
                }
                
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, 2 * pair.getValue() + 1));
                }
            }
            
            max = Math.max(max, pair.getValue() - head.getValue() + 1);
        }
        
        return max;
    }
}

/*
    Level 0일 때, 2^0 1개
    Level 1일 때, 2^1 2개
    Level 2일 때, 2^2 4개
    Level 3일 때, 2^3 8개 있음

*/