package com.javaDwarf.binaryTrees.leetcode.dfs;

import com.javaDwarf.binaryTrees.TreeNode;

public class _298_BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {

	}

	int max = 0;
	public int longestConsecutive(TreeNode root) {
		this.max = 0;
		if(root ==  null) return max;
		longestConsecutive(root, 1);
		return this.max;
	}

	public void longestConsecutive(TreeNode root, int count) {

		if(root ==  null) return ;
		
		this.max = Integer.max(this.max, count);

		TreeNode left = root.left;
		if(left != null) {
			if(root.val == left.val -1) {
				longestConsecutive(root.left, count+1);
			}
			else {
				longestConsecutive(root.left, 1);
			}
		}

		TreeNode right = root.right;
		if(right != null) {
			if(root.val == right.val -1) {
				longestConsecutive(root.right, count+1);
			}
			else {
				longestConsecutive(root.right, 1);
			}
		}
	}
}
