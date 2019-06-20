package com.javaDwarf.leetcode;

public class _369_PlusOneLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(9);

		n1.next =n2;
		n2.next =n3;

		new _369_PlusOneLinkedList().plusOne(n1);
		System.out.println(n1);
	}

	public ListNode plusOne(ListNode head) {

		if(head ==  null) return head;

		ListNode rev = reverse(head);

		ListNode curr = rev;

		int carry = 1;

		while(true) {

			int currVal = curr.val +carry;

			int remainder = currVal % 10;
			carry = currVal / 10;


			if(carry != 0) {
				curr.val = remainder;
			}
			else {
				curr.val = remainder;
				break;
			}
			if(curr.next!=null) {
				curr = curr.next;	
			}
			else
			{
				if(carry != 0) {
					curr.next = new ListNode(carry);
					curr = curr.next;
				}
				break;	
			}
		}
		
		return reverse(rev);

	}

	private ListNode reverse(ListNode head) {

		if(head == null || head.next == null) return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;

		while(curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}

}
