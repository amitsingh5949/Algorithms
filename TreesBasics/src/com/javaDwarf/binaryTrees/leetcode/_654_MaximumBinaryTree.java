package com.javaDwarf.binaryTrees.leetcode;

public class _654_MaximumBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums==null || nums.length==0) return null;
		return constructMaximumBinaryTree(nums, 0, nums.length-1);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		
		if(start> end) return null;
		
		int max = start;
		for(int i=start; i<=end; i++) {
			if(nums[max] < nums[i]) {
				max = i;
			}
		}
		
		TreeNode root = new TreeNode(nums[max]);
		root.left = constructMaximumBinaryTree(nums, start, max-1);
		root.right = constructMaximumBinaryTree(nums, max +1, end);
		
		return root;
	}

	}
