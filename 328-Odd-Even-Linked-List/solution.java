/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        /*
        count=2
           i
        1->2->3
           a
        dummyOdd->1
            b
        dummyEven->2
        */
        
        if(head==null||head.next==null)
            return head;
        
        ListNode dummyOdd = new ListNode(-1);
        ListNode oddPos = dummyOdd;
        ListNode dummyEven = new ListNode(-1);
        ListNode evenPos = dummyEven;
        
        int count = 1;
        while(head!=null){
            ListNode next = head.next;
            if(count%2==1){
                oddPos.next = head;
                oddPos = oddPos.next;
                oddPos.next = null;
            }else{
                evenPos.next = head;
                evenPos = evenPos.next;
                evenPos.next = null;
            }
            head = next;
            count++;
        }
        oddPos.next = dummyEven.next;
        return dummyOdd.next;
    }
}