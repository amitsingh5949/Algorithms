package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.dfs._117_PopulatingNextRightPointersinEachNodeII.Node;

public class _116_PopulatingNextRightPointersinEachNode {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}
		
		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right,Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		
		if(root== null) return root;

		Node parentLevelNode = root;
		Node nextChildLevelStartNode = new Node(0);

		while(parentLevelNode!= null) {

			Node needle = nextChildLevelStartNode;

			while(parentLevelNode != null) {

				if(parentLevelNode.left!= null) {
					needle.next = parentLevelNode.left;
					needle = needle.next;
				}

				if(parentLevelNode.right!= null) {
					needle.next = parentLevelNode.right;
					needle = needle.next;
				}
				parentLevelNode = parentLevelNode.next;
			}

			parentLevelNode= nextChildLevelStartNode.next;
			nextChildLevelStartNode.next= null;
		}
		return root;
	}

}
