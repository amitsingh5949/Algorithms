package com.javaDwarf.binaryTrees.leetcode;

public class _114_FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(5);

		l1.left = l2;
		l1.right = l5;

		l2.left = l3;
		l2.right = l4;

		l5.right = l6;

		new _114_FlattenBinaryTreetoLinkedList().flatten(l1);

	}

	public TreeNode head = null;
	public TreeNode prev = null;

	public void flatten(TreeNode root) {
		if(root == null) return;
		prev = null;
		head = null;
		flattenRec(root);
		prev.right = null;
		root = head;
		System.out.println(root);
	}

	public void flattenRec(TreeNode curr ) {

		if(curr == null) return;

		flattenRec(curr.left);
		flattenRec(curr.right);

		if(prev == null) {
			head = curr;
			prev = curr;
		}
		else {
			prev.left = curr;
			prev.right = null;
			prev = prev.left;

		}
	}

	// Easier to follow solution o(n) and o(n)
	TreeNode dummy;
	public void flatten1(TreeNode root) {
		dummy = new TreeNode(-1);
		helper(root);
	}

	public void helper(TreeNode root){

		if(root == null) return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		dummy.left = null;
		dummy.right = root;
		dummy = dummy.right;

		root.left = null;
		root.right = null;

		helper(left);
		helper(right);

	}
}
