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


	// below same as above , different way of writing
	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		
		while(list1 != null && list2 != null){
			if(list1.val <= list2.val){
				temp.next = list1;
				temp = temp.next;
				list1 = list1.next;
			}
			else{
				temp.next = list2;
				temp = temp.next;
				list2 = list2.next;
			}
		}

		if(list1 != null) temp.next = list1;
		else if(list2 != null) temp.next = list2;

		return dummy.next;
	}

}
