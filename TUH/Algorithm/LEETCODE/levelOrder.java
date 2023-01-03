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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        levelOrderRecursive(result, queue);
        return result;
    }

    public void levelOrderRecursive(List<List<Integer>> result, Queue<TreeNode> queue) {
        if (queue.size() == 0) return;

        List<Integer> levelVal = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelVal.add(node.val);
            if (node.left != null) {
                levelQueue.offer(node.left);
            }
            if (node.right != null) {
                levelQueue.offer(node.right);
            }
        }
        result.add(levelVal);
        levelOrderRecursive(result, levelQueue);
    }
}
