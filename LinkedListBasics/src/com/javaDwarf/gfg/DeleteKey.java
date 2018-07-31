package com.javaDwarf.gfg;

import java.util.Scanner;

public class DeleteKey {

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
			int x = s.nextInt();
			head = deleteAllOccurances(head,x);
			
			while(head!=null) {
				System.out.print(head.value+" ");
				head = head.next;
			}
		}
		s.close();
	}
	public static Node deleteAllOccurances(Node head, int x){

		if(head == null) return null;
		
		Node prev = null;;
		Node curr = head;
		Node val = null;
		boolean flag = true;
		
		while(curr!=null) {
			if(curr.value==x) {
				if(prev==null) {
					curr = curr.next;
				}
				else{
					prev.next = curr.next;
					curr = curr.next;
				}
				continue;
			}
			else {
				if(flag) {
					flag = false;
					val = curr;
				}
			}
			prev = curr;
			curr = curr.next;
		}
        return prev==null?null:val;
    }
}
