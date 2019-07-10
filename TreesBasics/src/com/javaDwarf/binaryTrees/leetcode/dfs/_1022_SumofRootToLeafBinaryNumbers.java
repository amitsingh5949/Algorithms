package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _1022_SumofRootToLeafBinaryNumbers {

	int sum = 0 ;
	public int sumRootToLeaf(TreeNode root) {
		if( root == null) return 0;
		this.sum = 0;
		dfs(root, "");
		return sum;
	}
	
	public void dfs(TreeNode root, String path) {
		if( root == null) return;
		
		if(root.left == null && root.right == null) {
			path =  path + root.val;
			this.sum += Integer.parseInt(path,2);
		}
		
		path = path + root.val;
		dfs(root.left, path);
		dfs(root.right, path);
	}
}
