/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        /*
        is to move the next node's value into the node to delete then delete/jump over the next node
        */
        if(node==null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}