package com.javaDwarf.leetcode;

public class Solution {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		
		l1.next = l2;
		l2.next =l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		
		l4.next = l5;
		l5.next =l6;
		
		new Solution().addTwoNumbers(l1, l4);
		System.out.println();

	}



	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		
		ListNode node = new ListNode(0);
		
		ListNode  temp3 = node;
		
		while(l1 != null || l2 != null){ 
			if( l1 != null && l2 != null && carry + l1.val + l2.val <= 9 ){
				node.val = carry + l1.val + l2.val;
				carry = 0;
				l1 = l1.next;
				l2 = l2.next;
			}
			else if(carry + l1.val + l2.val > 9 && l1 != null && l2 != null){
				node.val = (carry + l1.val + l2.val) % 10;
				carry = 1;
				l1 = l1.next;
				l2 = l2.next;
			}
			else if(l1 != null && carry + l1.val <= 9){
				node.val = carry + l1.val;
				carry = 0;
				l1 = l1.next;
			}
			else if(l1 != null && carry + l1.val > 9){
				node.val = (carry + l1.val) % 10;
				carry = 1;
				l1 = l1.next;
			}

			else if(l2 != null && carry + l2.val <= 9){
				node.val = carry + l2.val;
				carry = 0;
				l2 = l2.next;
			}
			else if(l2 != null && carry + l2.val > 9){
				node.val = (carry + l2.val) % 10;
				carry = 1;
				l2 = l2.next;
			}
			if(l1 != null || l2 != null){

				node.next = new ListNode(0);
				node = node.next;
			}
		}
		
		if(carry != 0) {
			node.next = new ListNode(carry);
		}
		return temp3;
	}


}
