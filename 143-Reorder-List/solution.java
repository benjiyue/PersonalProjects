/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        /*
        we need to have access to the nodes in layers
        slow and fast pointer till tthe fast reaches the end then reverse the second half, then
        attach layer by layer the result as we go from outside  in
        */
        if(head==null||head.next==null)
            return;
            
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode endOfReverse = slow;
        //reverse from slow on
        ListNode end  = reverse(slow);
        endOfReverse.next = null;
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while(end!=endOfReverse){
            ListNode headNext = head.next;
            ListNode endNext = end.next;
            iter.next = head;
            iter = iter.next;
            iter.next = end;
            iter = iter.next;
            end = endNext;
            head = headNext;
        }
        if(head==end){
            iter.next = head;
        }else{
            iter.next = head;
            iter = iter.next;
            iter.next = end;
        }
    }
    
    public ListNode reverse(ListNode current){
        ListNode to = current;
        ListNode from = current.next;
        while(from!=null){
            ListNode next = from.next;
            from.next = to;
            to  = from;
            from = next;
        }
        return to;
    }
}