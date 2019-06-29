package com.javaDwarf.binaryTrees.leetcode.dfs;


import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _108_ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

		TreeNode n =  new _108_ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[] {-10,-3,0,5,9});
		System.out.println(n);
	}

	
	
	public  TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		//return addNode(nums, 0, nums.length-1);
		return addNodeBottom(nums, 0, nums.length-1);
	}
	
	// Top - down approach
	public  TreeNode addNode(int[]nums, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int  mid = (start + end)/2;
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = addNode(nums, start, mid-1);
		root.right = addNode(nums,mid+1, end);
		
		return root;
	}
	
	// bottom -up approach
	// we need to go until we find the position leftmostn
	
	 int head = 0 ;
	
	public  TreeNode addNodeBottom(int[]nums, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int  mid = (start + end)/2;
		
		TreeNode left = addNodeBottom(nums, start, mid-1);
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = left;
		
		this.head++;
		
		
		root.right = addNodeBottom(nums,mid+1, end);
		
		return root;
	}
	

}
