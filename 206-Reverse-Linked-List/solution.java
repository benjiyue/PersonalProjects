/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        /*
        Idea is to basically make each next node point to the previous but we must save the next position so we can continue
        */
        
        ListNode to = null;
        ListNode from = head;
        while(from!=null){
            ListNode next = from.next;
            from.next = to;
            to = from;
            from = next;
        }
        return to;
    }
}