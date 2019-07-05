package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _404_SumofLeftLeaves {

	public static void main(String[] args) {

	}

	public int sumOfLeftLeaves(TreeNode root) {

		if(root == null) return 0;

		return sumOfLeftLeaves(root, 0);
	}

	public int sumOfLeftLeaves(TreeNode root, int sum) {

		if(root == null)  return sum;

		if(root.left != null && root.left.left == null  && root.left.right==null) {
			return (sum + root.left.val);
		}

		sum = sumOfLeftLeaves(root.left, sum);
		sum = sumOfLeftLeaves(root.right, sum);

		return sum;
	}

}
