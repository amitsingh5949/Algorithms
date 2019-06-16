package com.javaDwarf.leetcode;

public class _430_FlattenMultilevelDoublyLinkedList {

	public Node flatten(Node head) {
		
		return head;

	}
	
	public void flatten(Node parent, Node child) {
		if(parent == null && child == null) {
			return;
		}
		
		while(parent != null ) {
			
			if(parent.child!=null) {
				flatten(parent, parent.child);
			}
		}
	}

}
