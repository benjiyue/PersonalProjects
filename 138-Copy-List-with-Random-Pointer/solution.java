/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
	    if(head==null)
	        return null;
		//idea is to first create a copy of each node and insert it immediately after, then iterate again and use look at the random pointer and assign the copy to the .next of the random node since that will be the copy, then extract the individual nodes.

		RandomListNode dummy = new RandomListNode(-1);
		dummy.next = head;

		RandomListNode iter = dummy;
		//create copies
		while(iter!=null){
			RandomListNode next = iter.next;
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
			iter = next;
		}

		//assign random pointers
		iter = dummy;
		while(iter!=null){
			RandomListNode random = iter.random;
			iter.next.random = random==null?null:random.next;
			iter = iter.next.next;
		}

		//now detach the copies
		RandomListNode orig = dummy;
		RandomListNode dummyCopy = dummy.next;
		iter = dummy.next;
		while(iter!=null){
		    orig.next = iter.next;
		    if(iter.next!=null)
			    iter.next = iter.next.next;
			iter = iter.next;
			orig = orig.next;
		}
		return dummyCopy.next;

	}
}