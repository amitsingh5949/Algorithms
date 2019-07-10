package com.javaDwarf.binaryTrees.leetcode;

public class _671_SecondMinimumNodeInaBinaryTree {

	public int findSecondMinimumValue(TreeNode root) {
		if(root.left == null && root.right == null) return -1;
		long i =  findGreaterThanRoot(root, root.val) ;
		return	(i != Long.MAX_VALUE) ? (int)i : -1;
	}
	
	public long findGreaterThanRoot(TreeNode root, int val){
		if(root == null) return Long.MAX_VALUE;
		if(root.val != val) return root.val;
		return Long.min(findGreaterThanRoot(root.left, val),
				findGreaterThanRoot(root.right, val));
	}

}
