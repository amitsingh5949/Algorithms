package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _563_BinaryTreeTilt {
	
	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		
		l1.left = l2;
		l1.right = l3;
		
		int x = new _563_BinaryTreeTilt().findTilt(l1);
		System.out.println(x);
		
	}


	public int tilt = 0;
	public int findTilt(TreeNode root) {
		this.tilt = 0 ;
		findTilt(root, 0);
		return this.tilt;
	}

	public int findTilt(TreeNode root, int sum) {

		if(root == null) return 0;

		int sumleft  = findTilt(root.left, sum);
		int sumRight  = findTilt(root.right, sum);

		tilt += Math.abs(sumleft - sumRight);

		return sumleft + sumRight + root.val;

	}



}
