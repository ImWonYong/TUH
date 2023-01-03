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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            int levelSize = queue.size();

            Integer[] arr = new Integer[levelSize];

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    arr[i] = null;
                } else {
                    arr[i] = node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if (!checkMirror(arr)) return false;
        } 

        return true;
    }

    public boolean checkMirror(Integer[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }

        return true;
    }
}
