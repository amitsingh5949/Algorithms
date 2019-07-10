package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _1038_BinarySearchTreetoGreaterSumTree {

	int sum = 0;
	public TreeNode bstToGst(TreeNode root) {
		if( root == null) return root;
		this.sum = 0;
		bstToGstRightdfs(root);
		return root;
	}
	public void bstToGstRightdfs(TreeNode root) {
		if( root == null) return;
		bstToGstRightdfs(root.right);
		this.sum += root.val;
		root.val = this.sum;
		bstToGstRightdfs(root.left);
	}
}
