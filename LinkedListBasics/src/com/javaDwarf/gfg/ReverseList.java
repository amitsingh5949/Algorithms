package com.javaDwarf.gfg;

import java.util.Scanner;

public class ReverseList {

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
			current = reverseList(head);
			while(current!=null) {
				System.out.print(current.value+" ");
				current = current.next;
			}
		}
		s.close();
	}

	public static  Node reverseList(Node a){
		if(a==null) return null;

		Node prev = null;
		Node current = a;
		Node next = a.next;

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
