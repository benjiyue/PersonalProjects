/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /*
        we will use/attach to the end of out previous node only the first element of a sequence of the same thing. we use a dummy node to start the list to be returned, then keep iterating while the cuurent value is the same as where we started
        */
        /*
                  i
         1->2->3->null
                      h
        [1->1->2->3->3]
        */
        if(head==null||head.next==null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        
        while(head!=null){
            int value = head.val;
            iter.next = head;
            iter = iter.next;
            while(head!=null&&head.val==value)
                head =  head.next;
        }
        iter.next = null;
        return dummy.next;
    }
}