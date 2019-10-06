package amazon;



public class _138_CopyListwithRandomPointer {
	
	/*
	 Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, 
	 create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N after the Nth node
	 
	 Now copy the random link in this fashion
	 original->next->random= original->random->next;  TRAVERSE TWO NODES
	 This works because original->next is nothing but copy of original and Original->random->next 
	 is nothing but copy of random.

	Now restore the original and copy linked lists in this fashion in a single loop.
	original->next = original->next->next;
	     copy->next = copy->next->next;
	     
	Ensure that original->next is NULL and return the cloned list*/

	public AllNode deepCopy(AllNode head) {

		if(head == null) return null;

		AllNode copyLL = null;
		AllNode headTemp = head;

		while(headTemp != null) {
			AllNode curr = new AllNode(headTemp.value	);
			AllNode next = headTemp.next;
			headTemp.next = curr;
			curr.next=next;
			headTemp = next;
		}

		headTemp = head;
		copyLL = head.next;

		while(headTemp != null) {
            if(headTemp.arbitrary!=null)
			headTemp.next.arbitrary = headTemp.arbitrary.next;
            
			headTemp = headTemp.next.next;
		}

		headTemp = head;

		while(headTemp != null) {
			AllNode copy = headTemp.next;
			headTemp.next = headTemp.next.next;
			if(copy.next != null)
				copy.next = copy.next.next;
			headTemp = headTemp.next;
		}
		return copyLL;
	}
}

class AllNode {
	      public int value;
	      AllNode next;
	      AllNode arbitrary;
	      AllNode(int x) { this.value = x; }
	  }