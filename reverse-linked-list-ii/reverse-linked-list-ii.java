/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode left;
    boolean stop;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.left = head;
        this.stop = false;
        this.recurse(head, left, right);
        return head;
    }
    
    public void recurse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        
        right = right.next;
        
        if (m > 1) {
            this.left = this.left.next;
        }
        
        this.recurse(right, m - 1, n - 1);
        
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }
        
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            
            this.left = this.left.next;
        }
    }
}