package com.javaDwarf.binaryTrees.leetcode;

public class _783_MinimumDistanceBetweenBSTNodes {

	public static int diff = Integer.MAX_VALUE;
	
	public static void main(String... args) {
		TreeNode l1 = new TreeNode(96);
		TreeNode l2 = new TreeNode(12);
		TreeNode l3 = new TreeNode(13);
		TreeNode l4 = new TreeNode(52);
		TreeNode l5 = new TreeNode(29);
		
	
		l1.left = l2;
		l2.right = l3;
		l3.right = l4;
		l4.left = l5;
		
		System.out.println(minDiffInBST(l1));
	}
	
	public static int minDiffInBST(TreeNode root) {
		diff = Integer.MAX_VALUE;
		diffInBST(root, Integer.MAX_VALUE);
		return diff;
	}

	public static int  diffInBST(TreeNode root, int previous ) {

		if(root == null) return previous;
		
		previous = diffInBST(root.left, previous);
		if(previous != Integer.MAX_VALUE) {
			diff = Integer.min(diff, root.val - previous);
		}
		previous = diffInBST(root.right, root.val);
		return previous;
		
	}
}