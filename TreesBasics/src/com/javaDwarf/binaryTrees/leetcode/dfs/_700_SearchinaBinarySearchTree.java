package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _700_SearchinaBinarySearchTree {

	public static void main(String[] args) {

	}

	public TreeNode searchBST(TreeNode root, int val) {
		
		if(root == null) return null;
		
		if(root.val == val) return root;
		
		TreeNode left = searchBST(root.left, val);
		TreeNode right = searchBST(root.right, val);
		
		if(left != null) {
			return left;
		}
		return right;

	}

}
