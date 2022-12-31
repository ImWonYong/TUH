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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;

        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) break;

            if (curNode.val == nextNode.val) {
                curNode.next = nextNode.next;
            } else{
                curNode = curNode.next;
            }


        }

        return head;
    }
}