package com.javaDwarf.leetcode;

public class _203_RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode removeElements(ListNode head, int val) {

		if(head == null) return null;

		while(head!=null && head.val==val) {
			head = head.next;
		}
		ListNode temp = head;

		while(temp!=null && temp.next !=null){
			if(temp.next.val == val) {
				temp.next = temp.next.next;
			}
			else{
				temp=temp.next;
			}
		}
		return head; 
	}

}