package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _116_PopulatingNextRightPointersinEachNode {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val,Node _left,Node _right,Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		
		if(root== null) return root;  
		
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(q.size() > 1) { 

			Node curr = q.poll(); 
			
			if(curr.left!= null) {
				q.add(curr.left);
			}
			if(curr.right!=null) {
				q.add(curr.right);
			}
			
			if(q.peek() == null) {
				q.add(q.poll());
			}
			else {
				curr.next = q.peek();
			}
		}
		
		return root;

	}

}
