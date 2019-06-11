package com.javaDwarf.leetcode;

public class _24_SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next =n2;
		n2.next =n3;
		n3.next =n4;
		n4.next =n5;

		n1 = swapPairs(n1);
		System.out.println(n1);

	}
	public static ListNode swapPairs(ListNode head) {

		if(head == null || head.next == null) return head;

		ListNode curr = head;
		head = head.next;
		ListNode prev = null;

		while(curr!=null) {

			ListNode nextCurr = curr.next;

			if(nextCurr != null) {
				if(prev!=null) {
					prev.next = nextCurr;
				}
				curr.next = nextCurr.next;
				nextCurr.next = curr;
			}
			prev = curr;
			curr = curr.next;
		}

		return head;

	}

}
