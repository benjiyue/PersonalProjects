/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        /*we need a fast and slow pointer and find the noed just before the kth from end ie k+1 from end
        
        then disconnect k and k+1, then go to the end of the list and connect it with the head of the orig ll
        */
        if(head==null||head.next==null)
            return head;
        int count = 0;
        ListNode iter = head;
        while(iter!=null){
            iter = iter.next;
            count++;
        }
        k%=count;
        if(k==0)
            return head;
            
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<=k;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        ListNode newHead = slow.next;
        slow.next = null;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
        return newHead;
        
            
    }
}