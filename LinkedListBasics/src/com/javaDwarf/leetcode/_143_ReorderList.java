package com.javaDwarf.leetcode;

public class _143_ReorderList {

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

		reorderList(n1);
		System.out.println(n1);

	}

	// find the middle node: O(n)
	// cut from the middle and reverse the second half: O(n)
	// merge two lists taking one node from each list at a time: O(n)

	public static void reorderList(ListNode head) {
		
		if(head == null || head.next ==null) return;
		
		ListNode mid = middleNode(head);
		
		ListNode midNext = mid.next;
		mid.next= null;
		
		ListNode midNextRev = reverseList(midNext);
		
		ListNode l1 = head;
		while(l1!=null && midNextRev!=null) {
			ListNode temp = midNextRev.next;
			midNextRev.next = null;
			midNextRev.next = l1.next;
			l1.next = midNextRev;
			midNextRev = temp;
			l1 = l1.next.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		if(head == null) return null;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null) {
			slow = slow.next;
			if(fast.next==null) {
				fast = null;
				continue;
			}
			fast = fast.next.next;
		}
		return slow;
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
	
	/*******Long but cleaner code below******/
	public void reorderList1(ListNode head) {
        if(head == null) return;
        ListNode lastHalfNode = getLastHalfNode(head);
        ListNode list2 = lastHalfNode.next;
        lastHalfNode.next = null;
        list2 = reverse(list2);
        head = merge(head,list2); 
    }
    
    public ListNode getLastHalfNode(ListNode head){
        ListNode slow=head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(list1 != null && list2 != null){
            
            ListNode next1 = list1.next;
            list1.next = null;
            curr.next = list1;
            curr = curr.next;
            list1 = next1;
                
            ListNode next2 = list2.next;
            list2.next = null;
            curr.next = list2;
            curr = curr.next;
            list2 = next2;    

        }

        if(list1 == null) curr.next = list2;
        else if(list2 == null) curr.next = list1;
        
        
        return dummy.next;
    } 
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;    
    }

}
