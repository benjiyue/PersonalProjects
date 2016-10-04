/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /*
        have a dummy start node and an iterator pointing to the last thing that we saw. Then we also have an iterator that just goes therough the list. And we simply ask at each iteration if the val is not the input val. if so add it to the prev node, mode up the prevous node, move up the iterator. Then continue till the end
                   i
        0 2->2->2
            p
        -1->0->null
        
        */
        
        if(head==null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode iter = head;
        
        while(iter!=null){
            if(iter.val!=val){
                prev.next = iter;
                prev = prev.next;
            }
            iter = iter.next;
        }
        prev.next = null;
        return dummy.next;
    }
}