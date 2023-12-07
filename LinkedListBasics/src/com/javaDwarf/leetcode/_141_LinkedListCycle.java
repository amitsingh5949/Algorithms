package com.javaDwarf.leetcode;

public class _141_LinkedListCycle {

	public static void main(String[] args) {}

	public boolean hasCycle(ListNode head) {

		if(head == null) return false;

		ListNode slow=head, fast=head.next;

		while(slow != fast){
			slow = slow.next;
			if(fast != null && fast.next != null)
				fast = fast.next.next;
			else return false;
		}
		return true;
	}

}
