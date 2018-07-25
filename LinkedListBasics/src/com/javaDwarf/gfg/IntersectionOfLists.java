package com.javaDwarf.gfg;

public class IntersectionOfLists {
	
	public Node getIntersectionNode(Node a, Node b) {
		
		Node temp = a;
		int sizeA = 0;
		while(temp!=null){
			sizeA++;
			temp= temp.next;
			
		}
		
		Node temp1 = b;
		int sizeB = 0;
		while(temp1!=null){
			sizeB++;
			temp1= temp1.next;
			
		}
		
		
		temp = a;
		temp1 = b;
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
