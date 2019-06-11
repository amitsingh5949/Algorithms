package com.javaDwarf.leetcode;

public class _86_PartitionList {

	public static void main(String[] args) {

	}

	public ListNode partition(ListNode head, int x) {
		
		if(head == null || head.next == null) return head;
		
		ListNode frontHead = null;
		ListNode frontTail = null;
		
		ListNode rearHead = null;
		ListNode rearTail = null;
		
		if(head.val < x) {
			frontHead = head;
			frontTail = head;
		}
		else {
			rearHead = head;
			rearTail = head;
		}
		
		ListNode temp = head;
		
		while(temp!=null) {
			
			if(temp.next != null) {
				if(temp.next.val < x) {
					if(frontHead == null) {
						frontHead = temp.next;
						temp.next = null;
					}
				}
			}
			temp = temp.next;
		}
		
		
		
		
		return head;

	}

}
