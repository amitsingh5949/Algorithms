package com.javaDwarf.leetcode;

public class _19_RemoveNthNodeFromEndofList {

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
		

	}
	public static ListNode removeNthFromEnd(ListNode head, int k) {

		ListNode temp1 = head;
		ListNode temp2 = head;
		while(k>0) {
			if(temp1==null)
				return null;
			temp1 = temp1.next;
			k--;
		}
		if(temp1==null){
			head = head.next;
			return head;
		}
		while(temp1.next!=null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp2.next!=null) {
			temp2.next  = temp2.next.next;
		}
		return temp2;

	}

}
