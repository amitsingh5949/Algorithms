package com.javaDwarf.leetcode;

public class _237_DeleteNodeWithoutHead {

	public void deleteNode(ListNode node) {

		if(node==null || node.next == null) return;
		ListNode temp =node.next;
		node.val = temp.val;
		node.next = temp.next;
		temp.next =null;

	}

}
