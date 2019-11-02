package com.javaDwarf.gfg;

import java.util.Scanner;

public class FirstNonRepeatingCharacterStream {

	public static boolean[] visited = null;
	
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i = 0; i<testCases; i++) {
			visited = new boolean[26];
			int size = s.nextInt();

			Node head = null;
			Node current = null;

			for(int j=0; j<size; j++) {

				char ch  = s.next().charAt(0);
				Node temp = null;
				if(!visited[ch-'a']) {
					visited[ch-'a'] = true;
					temp = new Node(ch-'a');
				}
				else {
					if(head != null) {
						if((char)(head.value+(int)'a')==ch) {
							head = head.next;
						}
						else {
							current = deleteNode(head, ch);
						}
					}
				}
				if(head == null) {
					head = temp;
					current = temp;
				}
				else if(head != null && temp != null){
					current.next=temp;
					current=temp;
				}
				if(head!=null) {
					System.out.print(((char)(head.value + (int)'a'))+ " ");
				}
				else {
					System.out.print(-1+ " ");
				}
			}
		}
		
		
		s.close();
	}

	private static Node deleteNode(Node head, char ch) {
		Node temp = head;
		Node prev = temp;
		Node current=temp.next;

		while(current!=null) {
			char c1 = (char)(current.value+(int)'a');
			if(c1==ch) {
				prev.next = current.next;
			}
			prev = current;
			current = current.next;
		}
		return prev;
	}
}