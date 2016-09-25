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
    public boolean hasCycle(ListNode head) {
        /*
        idea is slow and fast pointer, one moves 1 step and another moves 2 steps. if they ever intersct return true, else if the fast reaches the end/null then return false;
        */
        if(head==null||head.next==null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=null&&fast.next!=null){
            if(slow==fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}