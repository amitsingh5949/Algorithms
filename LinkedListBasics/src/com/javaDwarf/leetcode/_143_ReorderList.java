package com.javaDwarf.leetcode;

public class _143_ReorderList {

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

		reorderList(n1);
		System.out.println(n1);

	}

	// find the middle node: O(n)
	// cut from the middle and reverse the second half: O(n)
	// merge two lists taking one node from each list at a time: O(n)

	public static void reorderList(ListNode head) {
		
		if(head == null || head.next ==null) return;
		
		ListNode mid = middleNode(head);
		
		ListNode midNext = mid.next;
		mid.next= null;
		
		ListNode midNextRev = reverseList(midNext);
		
		ListNode l1 = head;
		while(l1!=null && midNextRev!=null) {
			ListNode temp = midNextRev.next;
			midNextRev.next = null;
			midNextRev.next = l1.next;
			l1.next = midNextRev;
			midNextRev = temp;
			l1 = l1.next.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		if(head == null) return null;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null) {
			slow = slow.next;
			if(fast.next==null) {
				fast = null;
				continue;
			}
			fast = fast.next.next;
		}
		return slow;
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
