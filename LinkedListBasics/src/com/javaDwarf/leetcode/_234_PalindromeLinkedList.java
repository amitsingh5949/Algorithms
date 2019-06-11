package com.javaDwarf.leetcode;

public class _234_PalindromeLinkedList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);

		n1.next =n2;

		System.out.println(isPalindrome(n1));

	}
	public static boolean isPalindrome(ListNode head) {

		boolean result = true;

		if(head == null || head.next ==null) return result;

		ListNode mid = middleNode(head);

		ListNode midNext = mid.next;
		mid.next= null;

		ListNode midNextRev = reverseList(midNext);

		while(midNextRev!=null&& head!=null) {
			if(head.val != midNextRev.val) {
				result = false;
				break;
			}
			midNextRev = midNextRev.next;
			head = head.next;
		}

		return result;
	}

	public static ListNode middleNode(ListNode head) {
		if(head == null) return null;

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast!=null) {
			if(fast.next==null) {
				fast = null;
				continue;
			}
			slow = slow.next;
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
