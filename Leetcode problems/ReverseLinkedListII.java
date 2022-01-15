/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int currentPosition = 1;
        ListNode currentNode = head, start = head;
        
        // Capturing m - 1 node and saving it into start.
        while (currentPosition < m) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }
        
        ListNode newList = null, tail = currentNode;
        while (currentPosition <= n) {
            ListNode next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPosition++;
        }
        
        start.next = newList;
        tail.next = currentNode;
        if (m == 1) return newList;
        else return head;
    }
}

