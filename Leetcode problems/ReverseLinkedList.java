/**
 * https://leetcode.com/problems/reverse-linked-list/
 */

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
        ListNode previous = null, current = head;
        
        while (current != null) {
            ListNode nextValue = current.next;
            current.next = previous;
            previous = current;
            current = nextValue;
        }
        
        return previous;
    }
}

