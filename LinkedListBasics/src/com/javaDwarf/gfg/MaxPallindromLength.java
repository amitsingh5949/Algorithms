package com.javaDwarf.gfg;

import java.util.Scanner;

public class MaxPallindromLength {

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
			System.out.println(maxPalindrome(head));
		}
		s.close();
	}

	public static int maxPalindrome(Node head){
		int maxLen = 0;
		Node prev = null;
		Node curr = head;
		while(curr!=null) {
			Node next = curr.next;
			curr.next = prev;
			maxLen = Math.max(maxLen, 2*countNode(prev, next)+1);
			maxLen = Math.max(maxLen, 2*countNode(curr, next));
			prev = curr;
			curr=next;
		}
		return maxLen;
	}

	private static int countNode(Node a, Node b) {
		int count = 0;
		while(a!=null && b!=null) {
			if(a.value==b.value) {
				count++;
			}
			else{
				break;
			}
			a= a.next;
			b=b.next;
		}
		return count;
	}
}
