package com.javaDwarf.leetcode;

public class _876_MiddleoftheLinkedList {

	public ListNode middleNode(ListNode head) {
		if(head == null) return null;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null) {
			slow = slow.next;
			if(fast.next==null) {
				fast = null;
				continue;
			}
			fast = fast.next.next;
		}
		return slow;
	}

}
