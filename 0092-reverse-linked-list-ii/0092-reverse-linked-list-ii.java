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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || (left == right)) {
            return head;
        }
        
        ListNode curr = head, prev = null, lPrev = null, l = null;
        int idx = 1;
        while(curr != null && idx <= right) {
            if (idx >= left) {
                if (idx == left) {
                    l = curr;
                }
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            } else {
                if (idx == left - 1) {
                    lPrev = curr;
                }
                curr = curr.next;
            }
            idx++;
        }
        
        l.next = curr;
        if (lPrev != null) {
            lPrev.next = prev;
        } else {
            head = prev;
        }
        
        return head;
    }
}