package com.javaDwarf.leetcode;

public class _82_RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);

		n1.next =n2;
		n2.next =n3;
		n3.next =n4;

		n4.next =n5;
		n5.next =n6;
		n6.next =n7;

		deleteDuplicates(n1);
		System.out.println(n1);


	}

	//DUMMY VARIABLE APPROACH
	public static ListNode deleteDuplicates(ListNode head) {
		
		if(head == null || head.next == null) return head;

		ListNode l1head = new ListNode(0);
		ListNode l1tail = l1head;

		ListNode l2head = head;
		ListNode l2tail = l2head;
		int c = 0;

		while(l2tail!=null) {
			c = 0;
			while(l2tail!=null && l2head.val == l2tail.val) {
				c++;
				l2tail = l2tail.next;
			}
			if(c == 1) {
				l1tail.next = l2head;
				l1tail  = l1tail.next ;
				l1tail.next  = null;
			}
			else {
				l2head = l2tail;
			}
		}
		return l1head.next; 
	}

}
