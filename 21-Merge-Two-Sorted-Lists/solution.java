/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        we use a dummy node to start the connection between the two lists. then use two pointers which start from the beginning of both arrays. we iterate starting at the dummy node and we connect the next to the lower of the two pointers and then move up the pointer that we used and the iterator pointer

        
        
        */
        
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                iter.next = l1;
                l1 = l1.next;
            }else{
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        
        if(l1!=null)
            iter.next = l1;
        if(l2!=null)
            iter.next = l2;
        
        return dummy.next;
        
    }
}