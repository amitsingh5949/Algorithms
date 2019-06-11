package com.javaDwarf.leetcode;

public class _445_AddTwoNumbers2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = null;
		ListNode head = null;
		int carry = 0;
		ListNode l1Rev = reverseList(l1);
		ListNode l2Rev = reverseList(l2);


		while(l1Rev!=null || l2Rev!=null) {
			if(l1Rev==null && l2Rev!=null) {
				int x = carry + l2Rev.val ;
				l2Rev.val = x % 10;
				carry = x/10;
				ListNode temp = l2Rev;
				l2Rev = l2Rev.next;
				temp.next = null;

				if(result == null) {
					head = temp;
					result = temp;
				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
			else if(l2Rev==null && l1Rev!=null) {
				int x = carry + l1Rev.val ;
				l1Rev.val = x % 10;
				carry = x/10;
				ListNode temp = l1Rev;
				l1Rev = l1Rev.next;
				temp.next = null;

				if(result == null) {
					head = temp;
					result = temp;

				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
			else {
				int x = carry + l1Rev.val + l2Rev.val;
				l1Rev.val = x % 10;
				carry = x/10;

				ListNode temp = l1Rev;
				l1Rev = l1Rev.next;
				temp.next = null;
				l2Rev = l2Rev.next;

				if(result == null) {
					head = temp;
					result = temp;
				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
		}

		if(carry != 0) {
			result.next = new ListNode(carry);
		}
		head = reverseList(head);

		return head;


	}

	public static ListNode reverseList(ListNode a) {
		if(a==null) return null;

		ListNode prev = null;
		ListNode current = a;
		ListNode next = a.next;

		while(current != null){
			current.next = prev;
			prev = current;
			current = next;
			if(next!=null)
				next = next.next;
		}
		return prev; 
	}
}
