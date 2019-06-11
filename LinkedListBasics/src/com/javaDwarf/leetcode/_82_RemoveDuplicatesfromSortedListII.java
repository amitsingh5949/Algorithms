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

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;

		int val = head.val;
		int count = 1;
		while(true) {

			if(head!=null && head.next != null && head.next.val == val) {
				head = head.next;
				count++;
			}
			else {
				if(count == 1) {
					break;
				}
				if(head.next!=null) {
					val = head.next.val;
				}
				head = head.next;
				count =1;
			}
		}

		if(head == null || head.next==null) {
			return head;
		}
		
		ListNode tail = head;
		ListNode curr = head.next;
		head.next = null;

		val = curr.val;
		count = 1;

		while(curr != null) {
			if(curr.next != null && curr.next.val == val) {
				curr = curr.next;
				count++;
			}
			else {
				if(count == 1) {
					tail.next = curr;
					tail = tail.next;
					curr = curr.next;
					tail.next = null;
					continue;
				}
				if(curr.next!= null) {
					val = curr.next.val;
				}
				curr = curr.next;
				count =1;
			}
		}
		return head; 
	}

	public static ListNode deleteDuplicates1(ListNode head) {
		if(head== null || head.next ==null) return head;

		int count = 1;
		ListNode temp = head;

		ListNode a = null;

		ListNode result = null;

		while(temp != null) {
			count = 1;
			while(temp!= null && temp.next!= null &&temp.val==temp.next.val) {
				ListNode x = temp.next;
				temp.next = null;
				temp = x;
				count++;
			}

			if(count ==1) {
				if(result == null) {
					a = temp;
					a.next = null;
					result = temp;
					result.next =null;
				}
				else {
					result.next = temp;
					result = result.next;
				}
			}

			temp = temp.next;
		}

		return a; 
	}

}
