package com.javaDwarf.binaryTrees.leetcode.dfs;

public class _117_PopulatingNextRightPointersinEachNodeII {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	
	// Logic: it's basically a level BFS without using additional queue, as the next link already serves the queue functionality.
    //        parentLevelNode moves to all nodes in tree in level order fashion
	//		  nextChildLevelStartNode creates the start dummy node, to populate the next pointers in the next level to  parent node
    //        needle keeps sewing together next level's children
	//       At the end of each level, we will move the parent to start node of next level parentLevelNode= nextChildLevelStartNode.next;
	//       and reset the nextChildLevelStartNode node by nextChildLevelStartNode.next= null;
	
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
