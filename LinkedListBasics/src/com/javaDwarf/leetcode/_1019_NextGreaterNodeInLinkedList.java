package com.javaDwarf.leetcode;

import java.util.Stack;

public class _1019_NextGreaterNodeInLinkedList {

	public static void main(String[] args) {

	}

	////*********** below logic is to find  immediate first next max element on right
	public int[] nextLargerNodes(ListNode head) {

		if(head == null) return new int[0];

		int size  = 1;
		
		ListNode n = head;
		while(n!= null) {
			n = n.next;
			size++;
		}
		
		int[] result = new int[size];

		Stack<Element> s = new Stack<>();

		int i = 0;

		while(head != null) {
			if(s.isEmpty() ) {
				s.add(new Element(i, head.val));
			}
			else {
				while(!s.isEmpty() &&s.peek().val < head.val) {
					Element temp = s.pop();
					result[temp.index] = head.val;
				}
				s.add(new Element(i,head.val));
			}

			head = head.next;
			i++;
		}
		
		while(!s.isEmpty()) {
			Element temp = s.pop();
			result[temp.index] = 0;
		}
		
		return result;
	}
	
	class Element{
		public int index = -1, val = -1;

		public Element(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}
	}



	//*********** below logic is to find max element among all elements on the right not the immediate next

	public static int[] nextLargerNodes1(ListNode head) {

		if(head == null) return new int[0];

		int[] result = null;

		Stack<Integer> s = new Stack<>();

		nextLargerNodes1(head, s);

		result = new int[s.size()];

		int i = 0;
		while(!s.isEmpty()) {
			result[i++] = s.pop();
			System.out.println(result[i-1]);
		}

		return result;

	}

	public static int nextLargerNodes1(ListNode head, Stack<Integer> s) {

		if(head.next == null) {
			s.add(0);
			return head.val;
		}

		int val = nextLargerNodes1(head.next, s);
		if(val > head.val) {
			s.add(val);
		}
		else {
			s.add(0);
			val = head.val;
		}
		return val;

	}

}
