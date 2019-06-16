package com.javaDwarf.leetcode;

public class _725_SplitLinkedListinParts {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next =n2;
		n2.next =n3;
		n3.next =n4;
		n4.next =n5;

		splitListToParts(n1,2);
		System.out.println(n1);

	}

	public static ListNode[] splitListToParts(ListNode root, int k) {

		ListNode[] arr = new ListNode[k];
		
		if(root == null) return arr;

		ListNode temp = root;
		int count = 0;

		int size = 0;
		while(temp != null) {
			temp = temp.next;
			size++;
		}

		int remainder = size%k;

		int quotient = size/k;

		ListNode prev = null; 
		temp = root;

		while( temp != null) {
			
			arr[count++]  = temp;
			
			for(int i=0; i<quotient; i++) {
				prev = temp;
				temp = temp.next;
			}
			
			if(remainder>0) {
				prev = temp;
				temp = temp.next;
				remainder--;
			}
			
			prev.next = null;
		}

		return arr;

	}

}
