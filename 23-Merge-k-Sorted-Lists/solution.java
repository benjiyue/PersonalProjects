/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
	    if(lists.length==0)
	        return null;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			public int compare(ListNode a, ListNode b){
				return a.val-b.val;
			}
		});
		
		for(ListNode i:lists){
		    if(i!=null)
			    minHeap.offer(i);
		}
		
		ListNode head = new ListNode(-1);
		ListNode prev = head;
		while(!minHeap.isEmpty()){
			ListNode next = minHeap.poll();
			prev.next = next;
			prev = next;
			if(next.next!=null)
				minHeap.offer(next.next);
		}
		return head.next;
	}
}