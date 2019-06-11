package com.javaDwarf.leetcode;

public class _142_LinkedListCycle2 {
	
	
	
	 private ListNode getIntersect(ListNode head) {
	        ListNode tortoise = head;
	        ListNode hare = head;

	        // A fast pointer will either loop around a cycle and meet the slow
	        // pointer or reach the `null` at the end of a non-cyclic list.
	        while (hare != null && hare.next != null) {
	            tortoise = tortoise.next;
	            hare = hare.next.next;
	            if (tortoise == hare) {
	                return tortoise;
	            }
	        }

	        return null;
	}

	    public ListNode detectCycle(ListNode head) {
	        if (head == null) {
	            return null;
	        }

	        // If there is a cycle, the fast/slow pointers will intersect at some
	        // node. Otherwise, there is no cycle, so we cannot find an entrance to
	        // a cycle.
	        ListNode intersect = getIntersect(head);
	        if (intersect == null) {
	            return null;
	        }

	        // To find the entrance to the cycle, we have two pointers traverse at
	        // the same speed -- one from the front of the list, and the other from
	        // the point of intersection.
	        ListNode ptr1 = head;
	        ListNode ptr2 = intersect;
	        while (ptr1 != ptr2) {
	            ptr1 = ptr1.next;
	            ptr2 = ptr2.next;
	        }

	        return ptr1;
	    }

	    // My Soln fast and slow should both start from head
	public ListNode detectCycle1(ListNode head) {
		if(head == null) return null;
		ListNode temp1 = head;
		ListNode temp2 = isLoopPresent(head);

		if(temp2!=null) {
			if(temp2.next.val==temp1.val) return temp1;
			temp2=temp2.next;
			while(true) {
				if(temp1.next.val==temp2.next.val) {
					return temp2.next;
				}
				temp1= temp1.next;
				temp2= temp2.next;
			}
		}
		return null;
	}

	private static ListNode isLoopPresent(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != null && fast!=null && fast.next!=null) {
			if(slow.val==fast.val) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}
}
