package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.TreeNode;

public class _437_PathSumIII {

	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);

		l1.left = l2;

		l1.right = l3;

		System.out.println(new _437_PathSumIII().pathSum(l1,3));

	}


	int numOfPath = 0; 
	public int pathSum(TreeNode root, int sum) {

		this.numOfPath = 0; 
		dfs(root, sum);
		return this.numOfPath;

	}

	public void dfs(TreeNode root, int sum) {

		if(root == null ) return ;

		dfsAgain(root, sum-root.val);
		dfs(root.left, sum);
		dfs(root.right, sum);

	}

	public void dfsAgain(TreeNode root, int sum) {

		if(root == null ) return ;

		if(sum ==0) this.numOfPath++;
		if(root.left != null)
			dfsAgain(root.left, sum-root.left.val);
		if(root.right != null)
			dfsAgain(root.right, sum-root.right.val);

	}

}
