/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int diff = n-m;
        while(diff>0){
            fast = fast.next;
            diff--;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(m>1){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            m--;
        }
        
        ListNode next = fast.next;
        reverse(slow, fast);
        slow.next = null;
        pre.next = fast;
        slow.next = next;
        return dummy.next;
    }
    
    public void reverse(ListNode begin, ListNode end){
        ListNode to = begin;
        ListNode from = begin.next;
        while(to!=end){
            ListNode next = from.next;
            from.next = to;
            to = from;
            from = next;
        }
    }
    
}