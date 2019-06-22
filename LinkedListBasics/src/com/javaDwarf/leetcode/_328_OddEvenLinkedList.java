package com.javaDwarf.leetcode;

public class _328_OddEvenLinkedList {

	public static void main(String[] args) {

	}
	// One pass solution will require evenhead and eventail pointer, remove even index nodes and start adding 
	// it at even head and even tail and at end add enhead to odd tail
	public ListNode oddEvenList(ListNode head) {
		
		if(head == null || head.next==null || head.next.next==null) return head;
		
		ListNode l1Head = new ListNode(0);
		ListNode l1Tail = l1Head;

		ListNode l2Head = new ListNode(0);
		ListNode l2Tail = l2Head;
		
		boolean flag = true;

		while(head != null) {
			if(flag) {
				l1Tail.next = head;
				l1Tail = l1Tail.next;
				head = head.next;
				l1Tail.next =null;
				flag = false;

			}
			else {
				l2Tail.next = head;
				l2Tail = l2Tail.next;
				head = head.next;
				l2Tail.next =null;
				flag = true;
			}
		}

		l1Tail.next = l2Head.next;

		return l1Head.next;
		
	}
	
	
	// below solution is two pass solution where we calculate size first and add even nodes at tail of list
	public ListNode oddEvenList1(ListNode head) {

		if(head == null || head.next==null || head.next.next==null) return head;

		ListNode tail = head;
		int size = 1;
		while(tail.next!=null) {
			tail = tail.next;
			size++;
		}

		int k = 0;
		ListNode curr = head;
		while(k < size/2) {
			ListNode nextNode = curr.next;
			curr.next = curr.next.next;
			nextNode.next = null;
			tail.next = nextNode;
			tail = nextNode;
			curr =curr.next;
			k++;
		}
		return head;
	}

}
