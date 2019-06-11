package com.javaDwarf.leetcode;

public class _61_RotateList {

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
		n1 = rotateRight(n1, 5);
		System.out.println();
	}

	public static ListNode rotateRight(ListNode head, int k) {

		if(head == null || head.next == null) return head;
		int size =0;

		ListNode temp = head;
		while( temp!=null) {
			temp = temp.next;
			size++;
		}

		k = k % size;

		ListNode nthNode = getNthFromEnd(head, k);

		ListNode rear = nthNode.next;
		if(rear == null) return head;
		nthNode.next = null;

		temp = rear; 
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = head;

		return rear;

	}

	public static ListNode getNthFromEnd(ListNode head, int k) {

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
		return temp2;

	}


}
