package com.javaDwarf.binaryTrees.leetcode;

public class _110_BalancedBinaryTree {

	public static void main(String[] args) {

	}


	public boolean isBalanced = true;

	public boolean isBalanced(TreeNode root) {
		isBalanced = true;
		isHeightBalanced(root);
		return isBalanced;
	}

	public int isHeightBalanced(TreeNode root) {

		if(root == null) return 0;

		int leftHeight = isHeightBalanced(root.left) + 1;
		int rightHeight = isHeightBalanced(root.right) + 1;

		if(Math.abs(leftHeight - rightHeight) > 1) {
			this.isBalanced = false;
		}
		return Integer.max(leftHeight, rightHeight);
	}

}
