package com.javaDwarf.leetcode;

public class _445_AddTwoNumbers2 {
	
	
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;
        
        if(getSize(l1) > getSize(l2)) return addTwoNumbers(l2, l1);
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        int carry = 0;
        
        while(temp1 != null){
            int temp = temp1.val + temp2.val + carry;// add small + big list
            int rem = temp % 10;
            carry = temp /10;
            
            temp2.val = rem;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
            
        }
        
        while(temp2 != null){
            int temp = temp2.val + carry;// add remaining big list
            int rem = temp % 10;
            carry = temp /10;
            
            temp2.val = rem;
            
            temp2 = temp2.next;          
        }
        
        if(carry == 1){
            temp2 = l2;
            while(temp2 != null && temp2.next != null) temp2 = temp2.next;// add carry to last element of final list
            temp2.next = new ListNode(1);
        }
        
        return l2;
    }
    
    public int getSize(ListNode l){
        int size = 0;
        while(l != null){
            size++;
            l = l.next;
        }
        return size;
    }
	
    //Method 2

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

		ListNode result = null;
		ListNode head = null;
		int carry = 0;
		ListNode l1Rev = reverseList(l1);
		ListNode l2Rev = reverseList(l2);


		while(l1Rev!=null || l2Rev!=null) {
			if(l1Rev==null && l2Rev!=null) {
				int x = carry + l2Rev.val ;
				l2Rev.val = x % 10;
				carry = x/10;
				ListNode temp = l2Rev;
				l2Rev = l2Rev.next;
				temp.next = null;

				if(result == null) {
					head = temp;
					result = temp;
				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
			else if(l2Rev==null && l1Rev!=null) {
				int x = carry + l1Rev.val ;
				l1Rev.val = x % 10;
				carry = x/10;
				ListNode temp = l1Rev;
				l1Rev = l1Rev.next;
				temp.next = null;

				if(result == null) {
					head = temp;
					result = temp;

				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
			else {
				int x = carry + l1Rev.val + l2Rev.val;
				l1Rev.val = x % 10;
				carry = x/10;

				ListNode temp = l1Rev;
				l1Rev = l1Rev.next;
				temp.next = null;
				l2Rev = l2Rev.next;

				if(result == null) {
					head = temp;
					result = temp;
				}
				else {
					result.next = temp;
					result = result.next;
				}
			}
		}

		if(carry != 0) {
			result.next = new ListNode(carry);
		}
		head = reverseList(head);

		return head;


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
}
