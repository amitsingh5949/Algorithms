package com.javaDwarf.leetcode;


public class _160_IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode temp = headA;
		int sizeA = 0;
		while(temp!=null){
			sizeA++;
			temp= temp.next;

		}

		ListNode temp1 = headB;
		int sizeB = 0;
		while(temp1!=null){
			sizeB++;
			temp1= temp1.next;

		}


		temp = headA;
		temp1 = headB;
		if(sizeA>sizeB){
			for(int i=0; i<(sizeA-sizeB);i++){
				temp= temp.next;
			}
		}
		else if (sizeA<sizeB){
			for(int i=0; i<(sizeB-sizeA);i++){
				temp1= temp1.next;
			}
		}

		while(temp!=temp1 && temp!=null && temp1!=null){
			temp= temp.next;
			temp1= temp1.next;
		}

		if(temp==null || temp1==null) return null;
		else
			return temp;
	}

}
