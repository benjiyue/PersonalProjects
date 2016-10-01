/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        /*
        idea is to get put the node into the proper position starting from the dummy node with value -inf. Then each time ask if the nubmer is less than the current this of if the current thing is null if so continue, else put it to the next of the current thing
        */
        if(head==null||head.next==null)
            return head;
            
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            //
            insert(dummy,cur);
            cur = next;
        }
        return dummy.next;
    }
    /*
    
    */
    public void insert(ListNode dummy, ListNode toInsert){
        ListNode prev = dummy;
        while(dummy!=null&&dummy.val<=toInsert.val){
            prev = dummy;
            dummy = dummy.next;
        }
        ListNode next = prev.next;
        prev.next = toInsert;
        toInsert.next = next;
    }
}