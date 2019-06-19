package com.javaDwarf.leetcode;

public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList {

	public static void main(String[] args) {
		
		Node n1 = new Node();
		n1.val = 4;
		Node n2 = new Node();
		n2.val = 2;
		Node n3 = new Node();
		n3.val = 5;
		Node n4 = new Node();
		n4.val = 1;
		Node n5 = new Node();
		n5.val = 3;
		
		n1.left = n2;
		n1.right =n3;
		
		n2.left = n4;
		n2.right =n5;
		
		new _426_ConvertBinarySearchTreetoSortedDoublyLinkedList().treeToDoublyList(n1);
		System.out.println();

	}


	 Node prev = null;
	 Node head = null;

	public  Node treeToDoublyList(Node root) {
		
		if(root == null) return null;
		
		dfs(root);
		head.left =prev;
		prev.right =head;

		return head;
	}

	public  void dfs(Node root) {
		if(root == null) return;
		
		dfs(root.left);
		
		if(prev == null) {
			this.head = root;
			this.prev = root;
			
		}else {
			this.prev.right = root;
			root.left = this.prev;
			this.prev = root;
		}
		dfs(root.right);
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}
		
		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}

}
