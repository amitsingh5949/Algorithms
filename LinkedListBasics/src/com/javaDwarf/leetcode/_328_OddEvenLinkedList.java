package com.javaDwarf.leetcode;

public class _328_OddEvenLinkedList {

	public static void main(String[] args) {

	}
	// One pass solution will require evenhead and eventail pointer, remove even index nodes and start adding 
	// it at even head and even tail and at end add enhead to odd tail
	
	// below solution is two pass solution where we calculate size first and add even nodes at tail of list
	public ListNode oddEvenList(ListNode head) {

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
