package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _538_ConvertBSTtoGreaterTree {

	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(13);
		
		n1.left = n2;
		n1.right =n3;
		
		new _538_ConvertBSTtoGreaterTree().convertBST(n1);
		System.out.println(n1);

	}

	
	// iterative solution would be to  put all elements in stack inorder and 
	// then pop and subtract keeping the sum of popped elements
	
	//recursive solution - below solution is recursive in order 
	//this question  can also be solved by reverse recursive order
	public TreeNode convertBST(TreeNode root) {

		int sum = sumOfBST(root, 0);
		
		convertBST(root, sum, 0);

		return root;

	}

	public int sumOfBST(TreeNode root, int sum) {

		if(root == null) return sum;

		sum += root.val;

		sum = sumOfBST(root.left, sum);
		sum = sumOfBST(root.right, sum);

		return sum;


	}

	public int convertBST(TreeNode root, int sum, int currSum) {

		if(root == null) return currSum;

		currSum = convertBST(root.left, sum,  currSum);
		currSum += root.val;
		root.val = sum - currSum + root.val;
		currSum = convertBST(root.right, sum,  currSum);
		
		return currSum;
		
	}

}
