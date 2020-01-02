package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.TreeNode;

public class _687_LongestUnivaluePath {

	public static void main(String[] args) {

	}

	int ans;
	public int longestUnivaluePath(TreeNode root) {
		if(root==null) return 0;
		ans = 0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode root) {

		if(root==null) return 0;

		int left = dfs(root.left);
		int right = dfs(root.right);
		int arrowLeft = 0, arrowRight = 0;// we are using extra variable arrowleft because if the condition doesn't satisfy we don't want to add left+right, we want to add left +0 or right +0
		if(root.left != null && root.val == root.left.val) {
			arrowLeft = left + 1;
		}
		if(root.right != null && root.val == root.right.val) {
			arrowRight = right + 1;
		}

		ans = Math.max(ans, arrowLeft + arrowRight);
		return Math.max(arrowLeft, arrowRight);
	}
	
}
