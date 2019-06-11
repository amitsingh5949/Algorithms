package com.javaDwarf.leetcode;


public class _21_MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		
		if(head1 == null) return head2;
		
		ListNode head = head1;
		while(head2 != null) {
			ListNode temp = head2.next;
			if(head1.val < head2.val) {
				ListNode prev = null;
				while(head1!=null && head1.val < head2.val) {
					prev = head1;	
					head1 = head1.next;
				}
				if(head1!=null) {
					prev.next = head2;
					head2.next = head1;
				}
				else {
					prev.next = head2;
					head2.next = null;
				}
			}
			else{
				head2.next = head1;
				head = head2;
			}
			head2 = temp;
			head1 = head;
		}
		return head;
	}

}
