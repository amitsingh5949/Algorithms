package com.javaDwarf.gfg;

import java.util.Scanner;

public class RemoveLoop {

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

			int k = s.nextInt();
			Node temp = head;
			for(int x=1 ; x<=k; x++) {
				if(x==k) {
					current.next=temp;
					break;
				}
				temp = temp.next;
			}

			head = removeLoop(head);
			while(head!=null) {
				System.out.print(head.value+" ");
				head = head.next;
			}
		}
		s.close();
	}

	private static Node removeLoop(Node head) {
		Node temp1 = head;
		Node temp2 = isLoopPresent(head);
		if(temp2!=null) {
			if(temp2.next.value==temp1.value) {
				temp2.next=null;
				return head;
			}
			temp2=temp2.next;
			while(true) {
				if(temp1.next.value==temp2.next.value) {
					temp2.next=null;
					break;
				}
				temp1= temp1.next;
				temp2= temp2.next;
			}
		}
		return head;
	}

	private static Node isLoopPresent(Node head) {
		Node slow = head;
		Node fast = head.next;
		while(slow != null && fast!=null && fast.next!=null) {
			if(slow.value==fast.value) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}

}
