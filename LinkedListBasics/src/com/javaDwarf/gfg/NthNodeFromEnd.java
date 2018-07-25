package com.javaDwarf.gfg;

import java.util.Scanner;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i = 0; i<testCases; i++) {
			int size = s.nextInt();
			int k = s.nextInt();
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
			System.out.println(getNthFromLast(head, k));
		}
		s.close();
	}

	private static int getNthFromLast(Node head, int k) {
		Node temp1 = head;
		Node temp2 = head;
		while(k>0) {
			if(temp1==null)
				return -1;
			temp1 = temp1.next;
			k--;
		}
		while(temp1!=null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp2.value;
	}
}
