package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

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
	
	
	//Easier soln: using extra queue, see the solution below
	
		public Node connect1(Node root) {
	        if(root== null) return root;

			Queue<Node> q = new LinkedList<>();
	       q.add(root);
	       
	       while(!q.isEmpty()){
	           int size = q.size();
	           Node dummy = new Node(0);
	           for(int i=0; i<size; i++){
	               Node curr = q.poll();
	               dummy.next = curr;
	               dummy = curr;
	               if(curr.left != null){
	                   q.add(curr.left);
	               }
	               if(curr.right != null){
	                   q.add(curr.right);
	               }
	           }
	       }
			return root;
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
