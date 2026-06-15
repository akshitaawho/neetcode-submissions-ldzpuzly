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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  // previous node, starts as null
        ListNode curr = head;  // start at the head

        while (curr != null) {
            ListNode next = curr.next;  // save next node before we lose it
            curr.next = prev;           // flip the pointer backwards
            prev = curr;                // move prev forward
            curr = next;                // move curr forward
        }

        return prev; 
    }
}
