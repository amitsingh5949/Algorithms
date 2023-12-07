package com.javaDwarf.leetcode;


public class _21_MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		
		if(head1 == null) return head2;
		
		ListNode head = head1;
		while(head2 != null) {
			ListNode temp = head2.next;
			if(head1.val < head2.val) {
				ListNode prev = null;
				while(head1!=null && head1.val < head2.val) {
					prev = head1;	
					head1 = head1.next;
				}
				if(head1!=null) {
					prev.next = head2;
					head2.next = head1;
				}
				else {
					prev.next = head2;
					head2.next = null;
				}
			}
			else{
				head2.next = head1;
				head = head2;
			}
			head2 = temp;
			head1 = head;
		}
		return head;
	}
	
	
	// below same as above , different way of writing
	 public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
	        
	        if(list1 == null && list2 == null) return null;
	        if(list1 == null ) return list2;
	        if(list2 == null) return list1;
	        
	        ListNode temp = new ListNode(-1);
	        ListNode curr = temp;
	        
	        while(list1 != null && list2 != null){
	           if(list1.val <= list2.val){
	               ListNode next = list1.next;
	               list1.next = null;
	               curr.next = list1;
	               curr = curr.next;
	               list1 = next;
	           }
	           else{
	               ListNode next = list2.next;
	               list2.next = null;
	               curr.next = list2;
	               curr = curr.next;
	               list2 = next;
	           }
	        }
	        if(list1 == null ) curr.next = list2; 
	        else if(list2 == null ) curr.next = list1;
	        return temp.next;
	        
	    }

}
