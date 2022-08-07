package com.javaDwarf.binaryTrees.leetcode.dfs;

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
	
	/************************ Preorder solution by maintaining parent pointer***************/
	class Solution {
	    public Node connect(Node root) {
	        preorder(root, null);
	        return root;
	    }
	    
	    public void preorder(Node root, Node parent){
	        
	        if(root == null) return;
	        
	        Node temp = parent;
	        while(temp != null){
	                 
	            if(temp.left != parent.left && temp.left != null){
	                root.next = temp.left;
	                break;
	            }
	            else if(root != temp.right && temp.right != null){
	                root.next = temp.right;
	                break;
	            }
	            temp = temp.next;
	        }
	        
	        preorder(root.left, root);
	        preorder(root.right, root);
	    }
	}

}
