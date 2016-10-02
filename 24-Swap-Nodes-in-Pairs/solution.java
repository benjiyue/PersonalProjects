/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        /*
        we keep track of the last node we need to connect to the current reversed pair and we also get the next node so we can continue after.
         d
               p     
        -1->2->1
              t  f  n
        1<-2  3<-4
        
        */
        if(head==null||head.next==null)
            return head;
            
        ListNode dummy = new ListNode(-1);
        
        ListNode prev = dummy;
        ListNode from = head.next;
        ListNode to = head;
        while(from!=null){
            ListNode next = from.next;
            from.next = to;
            prev.next = from;
            to.next = next;
            
            prev = to;
            to = next;
            from = to!=null?to.next:null;
            
        }
        return dummy.next;
    }
}