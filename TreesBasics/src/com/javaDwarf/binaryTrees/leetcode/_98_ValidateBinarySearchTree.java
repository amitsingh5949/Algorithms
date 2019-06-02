package com.javaDwarf.binaryTrees.leetcode;

public class _98_ValidateBinarySearchTree {

	public static int prev = Integer.MAX_VALUE;
	public static boolean flag = true;

	public static void main(String[] args) {
		/*TreeNode l1 = new TreeNode(96);
		TreeNode l2 = new TreeNode(12);
		TreeNode l3 = new TreeNode(13);
		TreeNode l4 = new TreeNode(52);
		TreeNode l5 = new TreeNode(29);
		
	
		l1.left = l2;
		l2.right = l3;
		l3.right = l4;
		l4.left = l5;
		
		System.out.println(isValidBST(l1));*/
		
		TreeNode l1 = new TreeNode(0);
		
		System.out.println(isValidBST(l1));

	}

	public static boolean isValidBST(TreeNode root) {
		prev = Integer.MAX_VALUE;
		flag = true;
		return isValidBST(root, true);
	}

	public static  boolean isValidBST(TreeNode root, boolean isBST) {
		if(root == null) return isBST;
		
		isBST = isValidBST(root.left, isBST);
		
		if(flag) {
			prev = root.val;
			flag = false;
		}
		else {
			if(root.val <= prev) {
				isBST = false;
			}
			prev = root.val;
		}
		isBST = isValidBST(root.right, isBST);
		
		return isBST;
	}



}
