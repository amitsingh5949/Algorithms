package com.javaDwarf.leetcode;



public class _138_CopyListwithRandomPointer {
	
	/*Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, 
	 create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N after the Nth node
	 
	 Now copy the random link in this fashion
	 original->next->random= original->random->next;  TRAVERSE TWO NODES
	 This works because original->next is nothing but copy of original and Original->random->next 
	 is nothing but copy of random.

	Now restore the original and copy linked lists in this fashion in a single loop.
	original->next = original->next->next;
	     copy->next = copy->next->next;
	     
	Ensure that original->next is NULL and return the cloned list*/

	public RandomListNode copyRandomList(RandomListNode head) {

		if(head == null) return null;

		RandomListNode copyLL = null;
		RandomListNode headTemp = head;

		while(headTemp != null) {
			RandomListNode curr = new RandomListNode(headTemp.label);
			RandomListNode next = headTemp.next;
			headTemp.next = curr;
			curr.next=next;
			headTemp = next;
		}

		headTemp = head;
		copyLL = head.next;

		while(headTemp != null) {
            if(headTemp.random!=null)
			headTemp.next.random = headTemp.random.next;
            
			headTemp = headTemp.next.next;
		}

		headTemp = head;

		while(headTemp != null) {
			RandomListNode copy = headTemp.next;
			headTemp.next = headTemp.next.next;
			if(copy.next != null)
				copy.next = copy.next.next;
			headTemp = headTemp.next;
		}
		return copyLL;
	}
}

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  }