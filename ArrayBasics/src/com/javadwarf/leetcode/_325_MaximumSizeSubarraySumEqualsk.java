package com.javadwarf.leetcode;

public class _325_MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {

	}

	public int maxSubArrayLen(int[] nums, int k) {
		
		if (nums==null || nums.length == 0) return 0;
		
		int prefixSum[] = new int[nums.length];
		
		int result = 0 ;
		
		int currSum = nums[0];
		int maxSum = nums[0];
		
		for(int i = 1; i<nums.length; i++) {
			currSum = Integer.max(currSum+nums[i], nums[i]);
			maxSum = Integer.max(maxSum, currSum);
			prefixSum[i] = maxSum;
		}
		
		
		
		return result;

	}

}
