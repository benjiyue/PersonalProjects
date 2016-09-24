/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //the idea is to look at each node in the lists and add them togther and carrying any over values, also taking care to make the value 0 for any null values
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        int carry = 0;
        /*
              i
        0->6->4->4
        4+0=4
        carry = 0;
              a
        9->1->4
            b
        7->2
        */
        while(l1!=null||l2!=null){
            int aVal;
            int bVal;
            
            if(l1!=null){
                aVal = l1.val;
                l1 = l1.next;
            }else
                aVal = 0;
                
            if(l2!=null){
                bVal = l2.val;
                l2 = l2.next;
            }else
                bVal = 0;
            int total = aVal+bVal+carry;
            carry = total/10;
            total%=10;
            ListNode cur = new ListNode(total);
            iter.next = cur;
            iter = iter.next;
        }
        if(carry==1)
            iter.next = new ListNode(1);
        
        return dummy.next;
    }
}