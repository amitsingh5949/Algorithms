package com.javaDwarf.binaryTrees.leetcode;

public class _543_DiameterofBinaryTree {

	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(5);

		l1.left = l2;
		l1.right = l5;

		l2.left = l3;
		l2.right = l4;

		l5.right = l6;

		System.out.println(new _543_DiameterofBinaryTree().diameterOfBinaryTree(l1));

	}


	public int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		diameterOfBinaryTreeRec(root);
		return this.diameter;
	}

	public int diameterOfBinaryTreeRec(TreeNode root) {

		if(root == null) return 0;

		int left = diameterOfBinaryTreeRec(root.left);
		int right = diameterOfBinaryTreeRec(root.right) ;

		int currDiameter = left + right;

		this.diameter = Integer.max(this.diameter, currDiameter);

		return Integer.max(left, right) +1;

	}

}
