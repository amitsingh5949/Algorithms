package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _897_IncreasingOrderSearchTree {

	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(379);
		TreeNode l2 = new TreeNode(826);

		l1.left = l2;

		TreeNode ll = new _897_IncreasingOrderSearchTree().increasingBST(l1);
		System.out.println(ll);

	}

	TreeNode head = new TreeNode(0);
	TreeNode prev = head;

	public TreeNode increasingBST(TreeNode root) {
		if(root == null) return null;
		this.head = new TreeNode(0);
		this.prev = head;
		inOrderDFS(root);
		return this.head.right;
	}

	public void inOrderDFS(TreeNode root) {
		if(root == null) return;
		inOrderDFS(root.left);
		this.prev.right = root;
		this.prev.left = null;
		this.prev = root;
		root.left = null;
		inOrderDFS(root.right);
	}

}
