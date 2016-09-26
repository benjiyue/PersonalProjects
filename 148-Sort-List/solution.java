/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        /*
        we do a modified version of mergesort we keep dividing the array based on the passed in low and high pointer using the slow and fast pointer approach. and then we segment again based on the begin, mid, and end points
        then each of the recursive calls returns the start node after merging. we merge by using a dummy node and connecting out iterating node to the min of the two pointers between the two returned recursive results
        */
        
        if(head==null||head.next==null)
            return head;
        ListNode iter = head;
        while(iter.next!=null)
            iter = iter.next;
        
        return mergeSort(head, iter);
    }
    
    
    public ListNode mergeSort(ListNode begin, ListNode end){
        if(begin==null||begin==end)
            return begin;
        ListNode slow = begin;
        ListNode fast = begin;
        while(fast!=end&&fast.next!=null&&fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        end.next = null;
        ListNode first = mergeSort(begin, slow);
        ListNode second = mergeSort(next, end);
        
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while(first!=null&&second!=null){
            if(first.val<second.val){
                iter.next = first;
                first = first.next;
            }else{
                iter.next = second;
                second = second.next;
            }
            iter = iter.next;
        }
        if(second!=null)
            iter.next = second;
        if(first!=null)
            iter.next = first;
        return dummy.next;
        
    }
}