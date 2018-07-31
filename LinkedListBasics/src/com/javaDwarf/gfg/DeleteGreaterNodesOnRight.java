package com.javaDwarf.gfg;

import java.util.Scanner;

public class DeleteGreaterNodesOnRight {

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
			compute(head);
		}
		s.close();
	}
	
	public static void compute(Node head){
		if(head==null) return;
		rec(null,head);
		if(head.next!=null && head.value<head.next.value) {
			head = head.next;
		}
		while(head!=null) {
			System.out.print(head.value+" ");
			head = head.next;
		}
	}

	public static void rec(Node prev, Node curr){
		if(curr==null) return;
		rec(curr, curr.next);
		if(prev!=null && curr.next!=null && curr.value<curr.next.value) {
			prev.next = curr.next;
		}
	}
}
