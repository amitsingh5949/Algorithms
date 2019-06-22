package com.javaDwarf.leetcode;

public class _86_PartitionList {

	public static void main(String[] args) {

	}

	public ListNode partition(ListNode head, int x) {

		if(head == null || head.next == null) return head;

		ListNode l1Head = new ListNode(0);
		ListNode l1Tail = l1Head;

		ListNode l2Head = new ListNode(0);
		ListNode l2Tail = l2Head;

		while(head != null) {
			if(head.val < x) {
				l1Tail.next = head;
				l1Tail = l1Tail.next;
				head = head.next;
				l1Tail.next =null;

			}
			else if(head.val >= x) {
				l2Tail.next = head;
				l2Tail = l2Tail.next;
				head = head.next;
				l2Tail.next =null;
			}
		}

		l1Tail.next = l2Head.next;

		return l1Head.next;

	}

}
