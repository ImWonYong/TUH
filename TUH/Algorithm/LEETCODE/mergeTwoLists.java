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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNodt result = null;
        if (list1.val >= list2.val) {
            result = list2;
        } else {
            result = list1;
        }

        while(list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                ListNode temp = list2.next;
                result
            } else {

            }
        }
    }
}