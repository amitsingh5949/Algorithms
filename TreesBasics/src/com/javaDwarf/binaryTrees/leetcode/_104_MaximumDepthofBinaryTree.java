package com.javaDwarf.binaryTrees.leetcode;

public class _104_MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}

	public int maxDepth(TreeNode root) {
		if(root== null ) return 0;
		return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
