package com.javaDwarf.gfg;

import java.util.Scanner;

public class SegregateEvenOdd {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i = 0; i<testCases; i++) {
			int size = s.nextInt();
			Node head = null;
			Node current = null;
			for(int j=0; j<size; j++) {
				Node temp = new Node(s.nextInt());
				if(j==0) {
					head = temp;
					current = temp;
					continue;
				}
				current.next=temp;
				current=temp;
			}
			current = segregate(head);
			while(current != null) {
				System.out.print(current.value+" ");
				current = current.next;
			}
		}
		s.close();
	}

	private static Node segregate(Node head) {

		if(head==null || head.next==null) return head;

		Node last = head;
		Node initialLast = head;
		Node current = head;
		Node firstEvenNode = null;
		Node prev = null;

		while(last.next!=null) {
			last = last.next;
		}
		initialLast = last; 

		while(current!=initialLast) {

			if(current.value%2==0) {
				if(firstEvenNode==null) {
					firstEvenNode=current;
				}
				prev = current;
				current = current.next;
			}
			else {
				Node temp = current.next;
				last.next = current;
				last = current;
				last.next = null;
				current = temp;
				if(prev!=null)
					prev.next=temp;
			}

		}

		if(current.value%2==0) {
			if(firstEvenNode==null) {
				firstEvenNode=current;
			}
			prev = current;
			current = current.next;
		}
		else {
			Node temp = current.next;
			last.next = current;
			last = current;
			last.next = null;
			if(prev!=null && temp == null) {
				prev.next=current;
			}else if(prev!=null && temp != null) {
				prev.next=temp;
			}
			current = temp;
		}

		return firstEvenNode==null?current:firstEvenNode;
	}

}
