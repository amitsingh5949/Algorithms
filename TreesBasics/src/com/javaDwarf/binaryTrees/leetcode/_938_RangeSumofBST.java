package com.javaDwarf.binaryTrees.leetcode;

public class _938_RangeSumofBST {

	public static int sum = 0;

	public int rangeSumBST(TreeNode root, int L, int R) {
		sum = 0;
		sumBST(root, L, R);
		return sum;
	}

	public void sumBST(TreeNode root, int L, int R) {
		
		if (root == null) return;
		
		if(root.val >= L && root.val <= R) {
			sum += root.val;
		}
		sumBST(root.left, L, R);
		sumBST(root.right, L, R);

	}

}
