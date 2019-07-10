package com.javaDwarf.binaryTrees.leetcode.bst;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _333_LargestBSTSubtree {

	public static void main(String[] args) {
		
		TreeNode l1 = new TreeNode(10);
		TreeNode l2 = new TreeNode(5);
		TreeNode l3 = new TreeNode(15);
		TreeNode l4 = new TreeNode(1);
		TreeNode l5 = new TreeNode(8);
		TreeNode l6 = new TreeNode(7);
		
		l1.left = l2;
		l1.right = l3;
		
		l2.left = l4;
		l2.right = l5;
		
		l3.right = l6;
		int x = new _333_LargestBSTSubtree().largestBSTSubtree(l1);
		System.out.println(x);

	}
// wrong logic below
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	int max = 0 ;
	int currMax = 0;

	public int largestBSTSubtree(TreeNode root) {
		if( root == null) return 0;
		this.prev = new TreeNode(Integer.MIN_VALUE);;
		this.max = 0 ;
		this.currMax = 0;
		dfs(root);
		return this.max;
	}

	public void dfs(TreeNode root) {
		if(root == null) return;
		dfs(root.left);
		if(prev.val <= root.val) {
			prev = root;
			this.currMax += 1;
			this.max = Integer.max(this.max, this.currMax);
		}
		else {
			prev = root;
			this.currMax = 1;
		}
		dfs(root.right);
	}

}
