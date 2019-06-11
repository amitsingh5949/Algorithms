package com.javaDwarf.leetcode;

public class _83_RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {

		if(head== null || head.next ==null) return head;

		while(head!= null && head.next!= null &&head.val==head.next.val) {
			head = head.next;
		}

		ListNode temp = head.next;

		while(temp != null && temp.next != null ) {

			if(temp.val == temp.next.val) {
				temp.next = temp.next.next;
			}
			else {
				temp = temp.next;
			}
		}
		return head;
	}

}
