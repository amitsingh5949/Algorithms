package com.javaDwarf.gfg;

import java.util.Scanner;

public class ReverseListinKGroups {

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
			current = reverse(head,k);
			while(current!=null) {
				System.out.print(current.value+" ");
				current = current.next;
			}
		}
		s.close();
	}

	public static Node reverse(Node node, int k){
        Node curr = node, prev = null, next = null;
        int count = 0;
        while(curr != null && count < k)
        {
            next = curr.next;
		    curr.next = prev;
		    prev = curr;
		    curr = next;
		    count++;
        }
        if (next != null)
	      node.next = reverse(next, k); 
	      return prev;
    }

}
