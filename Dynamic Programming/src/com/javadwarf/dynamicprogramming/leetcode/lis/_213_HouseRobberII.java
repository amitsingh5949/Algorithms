package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _213_HouseRobberII {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		
		if(nums== null || nums.length == 0) return 0;
		else if(nums.length == 1) return nums[0];

		int max1 = 0;
		int prevMax = 0;
		int currMax = 0;

		for(int i=0; i<nums.length-1; i++) {
			int temp =currMax;
			currMax = Math.max(prevMax+nums[i] , currMax);
			prevMax = temp;
		}

		max1 = currMax;

		prevMax = 0;
		currMax = 0;

		for(int i=1; i<nums.length; i++) {
			int temp =currMax;
			currMax = Math.max(prevMax+nums[i] , currMax);
			prevMax = temp;
		}
		
		return Math.max(currMax, max1);

	}


}

