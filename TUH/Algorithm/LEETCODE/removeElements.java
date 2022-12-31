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
    public ListNode removeElements(ListNode head, int val) {

        ListNode newNode = null;
        ListNode tempNode = null;
        while (head != null) {
            if (head.val != val) {
                if (newNode == null) {
                    newNode = head;
                    tempNode = newNode;
                } else {
                    tempNode.next = head;
                    tempNode = tempNode.next;
                }
            } else {
                if (tempNode != null) {
                    tempNode.next = null;
                }
            }

            head = head.next;
        }

        return newNode;
    }
}