package com.javaDwarf.leetcode;

public class _25_ReverseNodesinKGroup {

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

		ListNode temp = reverseKGroup(n1,2);
		System.out.println(temp);
	}

	// Reversing the linkedlist is iterative solution but Reversing the linkedlist in group is iterative + recursive solution
	public static ListNode reverseKGroup(ListNode head, int k) {

		ListNode curr = head, prev = null, next = null;
		int count = 0;

		int c = k;
		while(curr!=null && c !=0) {
			curr = curr.next;
			c--;
		}
		if(c!=0) {
			return head;
		}

		curr = head;
		while(curr != null && count < k)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null)
			head.next = reverseKGroup(next, k); 
		return prev;

	}

}
