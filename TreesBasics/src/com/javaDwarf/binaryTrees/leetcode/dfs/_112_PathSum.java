package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _112_PathSum {

	public static void main(String[] args) {

	}

	boolean result = false;

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		result = false;
		dfs(root, sum, root.val);
		return result;
	}

	public void dfs(TreeNode root, int sum, int currSum){
		if(root.left == null && root.right == null  && currSum == sum) {
			result =  true;
			return;
		}
		if(root.left != null)
			dfs(root.left, sum, currSum+root.left.val);
		if(root.right != null)
			dfs(root.right, sum, currSum+root.right.val);
	}

}
