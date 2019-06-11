package com.javaDwarf.leetcode;

public class _92_ReverseLinkedList2 {

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

		reverseBetween(n1,1,1);
		System.out.println(n1);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		if(head == null || head.next==null) return head;

		ListNode l1tail = null;
		int count = 1;
		for(count = 1 ; count<m-1; count++) {
			if(l1tail== null) {
				l1tail  =head;
			}
			l1tail = l1tail.next;
		}

		ListNode l2head = null;
		if(l1tail!= null) {
			l2head = l1tail.next;
			l1tail.next = null;
		}else {
			l2head = head;
		}

		ListNode prev = null;
		ListNode curr = l2head;
		ListNode next = curr.next;

		while(next != null && count < n) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
			count++;
		}
		if(l1tail!=null) {
			if(prev!=null) {
				l1tail.next = prev;
				l2head.next = curr;
			}
			else {
				l1tail.next = l2head;
			}
		}
		return head;
	}

}
