/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null||k==0)
			return head;

		int size = 0;
		ListNode iter = head;
		ListNode tail = null;
		while(iter!=null){
			size++;
			tail = iter;
			iter = iter.next;
		}
        if(k>size){
            return head;
        }
		if(k==size){
			reverse(head, tail);
			head.next = null;
			return tail;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode justBefore = dummy;
		ListNode first = head;
		while(true){
			ListNode lastOfGroup = getLastOfGrouping(justBefore, k);
			if(lastOfGroup==null)
				break;
			ListNode next = lastOfGroup.next;
			reverse(first, lastOfGroup);
			justBefore.next = lastOfGroup;
			first.next = next;
			justBefore = first;
			first = justBefore.next;
		}
		return dummy.next;

	}

	public void reverse(ListNode start, ListNode end){
		ListNode to = start;
		ListNode from = start.next;
		ListNode oob = end.next;
		while(from!=oob){
			ListNode next = from.next;
			from.next = to;
			to = from;
			from = next;
		}
	}

	public ListNode getLastOfGrouping(ListNode justBefore, int k){
		ListNode iter = justBefore;
		while(iter!=null&&k>0){
			k--;
			iter = iter.next;
		}
		return iter;
	}
}