package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _530_MinimumAbsoluteDifferenceinBST {

	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1999);
		TreeNode l2 = new TreeNode(1488);
		TreeNode l3 = new TreeNode(4594);
		TreeNode l4 = new TreeNode(15);
		TreeNode l5 = new TreeNode(3326);

		l1.left = l2;
		l1.right = l3;

		l2.left = l4;
		l3.right = l5;

		//int x = new _530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(l1);
		//System.out.println(x);
		
		TreeNode l6 = new TreeNode(5);
		TreeNode l7 = new TreeNode(4);
		TreeNode l8 = new TreeNode(7);

		l6.left = l7;
		l6.right = l8;

		int y = new _530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(l6);
		System.out.println(y);



	}

	
	// using inorder traversal to find minimum difference
	int min = Integer.MAX_VALUE;
	int prev = Integer.MAX_VALUE;
	
	public int getMinimumDifference(TreeNode root) {
		if(root == null) return 0;
		this.min = Integer.MAX_VALUE;
		this.prev = Integer.MAX_VALUE;
		getMinimumDifferenceRec(root);
		return this.min;
	}

	public void getMinimumDifferenceRec(TreeNode root) {
		if(root == null) return ;
		getMinimumDifferenceRec(root.left);
		this.min = Integer.min(this.min, Math.abs(root.val - prev));
		this.prev = root.val;
		getMinimumDifferenceRec(root.right);
	}


	// Brute force for every node
	public int getMinimumDifference1(TreeNode root) {

		if(root == null) return Integer.MAX_VALUE;

		int leftSubTreeMin = getMinimumDifference(root.left);
		int rightSubTreeMin = getMinimumDifference(root.right);

		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		if(root.left!=null) {
			leftMin = Math.abs(root.val - root.left.val);
			TreeNode leftRightMin = root.left.right;

			if(leftRightMin != null) {
				while(leftRightMin.right != null) {
					leftRightMin = leftRightMin.right;
				}
				leftMin = Math.abs(root.val - leftRightMin.val);
			}
		}
		if(root.right!=null) {
			rightMin = Math.abs(root.val - root.right.val);
			TreeNode rightLeftMin = root.right.left;

			if(rightLeftMin != null) {
				while(rightLeftMin.left != null) {
					rightLeftMin = rightLeftMin.left;
				}
				leftMin = Math.abs(root.val - rightLeftMin.val);
			}
		}

		return Integer.min(
				Integer.min(leftMin, rightMin),
				Integer.min(leftSubTreeMin, rightSubTreeMin)
				);
	}

}
