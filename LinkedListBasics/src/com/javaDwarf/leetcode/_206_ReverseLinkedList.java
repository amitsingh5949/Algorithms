package com.javaDwarf.leetcode;

public class _206_ReverseLinkedList {

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

		ListNode temp = reverseList11(n1);
		System.out.println(temp);


	}
	public static ListNode reverseList(ListNode a) {
		if(a==null) return null;

		ListNode prev = null;
		ListNode current = a;
		ListNode next = a.next;

		while(current != null){
			current.next = prev;
			prev = current;
			current = next;
			if(next!=null)
				next = next.next;
		}
		return prev; 
	}
	//recursion logic
	public static ListNode reverseList11(ListNode head) {
        return reverseList11(null, head);
    }
    
    public static ListNode reverseList11(ListNode prev, ListNode curr) {
        if(curr == null) return prev;
        ListNode head =  reverseList11( curr, curr.next);
        curr.next = prev;
        return head;
    }
	
	//iterative : cleaner code than above, no need of next and curr variables
	public ListNode reverseList23(ListNode head) {
	    ListNode prev = null;
	    while(head != null){
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
	
	//tail recursion , same logic as above
	class Solution {
	    public ListNode reverseList(ListNode head) {
	        return helper(null, head);
	    }
	    
	    public ListNode helper(ListNode prev, ListNode head){
	        if(head == null) return prev;
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	        return helper(prev, head);
	    }
	}

}
