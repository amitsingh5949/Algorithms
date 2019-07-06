package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _270_ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(1);
		l1.left = l2;

		new _270_ClosestBinarySearchTreeValue().closestValue(l1, Integer.MAX_VALUE);
	}

	int lower = -1;
	int upper = -1;

	public int closestValue(TreeNode root, double target) {

		if(root.left == null && root.right == null) return root.val;

		this.lower = -1;
		this.upper = -1;

		inorderDfs(root, target);

		if(upper == -1) {
			return	this.lower;
		}
		else if(lower == -1) {
			return	this.upper;
		}
		else {
			return (target - lower) < (upper - target) ? lower : upper;
		}

	}

	public void inorderDfs(TreeNode root, double target) {

		if(root == null) return;

		inorderDfs(root.left, target);
		if(root.val <= target) {
			this.lower = root.val;
		}
		else if(upper == -1 && root.val > target) {
			this.upper = root.val;
			return;
		}
		inorderDfs(root.right, target);

	}

}
