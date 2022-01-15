/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node current = head;
        
        while (current != null) {
            if (current.child != null) {
                Node child = current.child, oldNext = current.next;
                
                current.next = child;
                child.prev = current;
                current.child = null;
                current = child;
                
                if (oldNext != null) {
                    Node newCurrent = current;
                    while (newCurrent.next != null) newCurrent = newCurrent.next;
                    oldNext.prev = newCurrent;
                    newCurrent.next = oldNext;
                }
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
