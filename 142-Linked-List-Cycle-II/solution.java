/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        
        int slowSteps = 0;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            slowSteps++;
            if(slow==fast)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        
        ListNode front = head;
        while(front!=slow){
            front = front.next;
            slow = slow.next;
        }
        return front;
        
        
    }
}