package com.javaDwarf.binaryTrees.leetcode;

public class _865_SmallestSubtreewithalltheDeepestNodes {

	int max = Integer.MIN_VALUE; 
	TreeNode node = null;
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if(root == null) return null;
		 this.max = Integer.MIN_VALUE; 
		 this.node = null;
		findTheNode(root);
		return this.node;
	}

	public int findTheNode(TreeNode root){

		if(root == null) return 0;
		int left  = findTheNode(root.left );
		int right = findTheNode(root.right);

		int maxDepth =  Integer.max(left , right) + 1;

		if(left == right && maxDepth  > this.max) {
			this.node = root;
			this.max =  maxDepth;
		}
		return maxDepth;
	}	
	
	public int height(TreeNode root) {
		if(root == null) return 0;
		return Integer.max(height(root.left), height(root.right)) + 1;
	}

}
