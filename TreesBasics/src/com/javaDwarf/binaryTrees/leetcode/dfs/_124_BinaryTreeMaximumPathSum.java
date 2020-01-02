package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


// similar to _687_LongestUnivaluePath
public class _124_BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	int ans;
	public int maxPathSum(TreeNode root) {
		ans = 0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode root) {
		if(root == null) return 0;

		int left = dfs(root.left);
		int right = dfs(root.right);

		ans = Math.max(ans, 
				Math.max(Math.max(root.val, left+right+root.val),
						Math.max(left+root.val, right+root.val)));
		return Math.max(root.val, Math.max(left, right) + root.val);

	}

}
