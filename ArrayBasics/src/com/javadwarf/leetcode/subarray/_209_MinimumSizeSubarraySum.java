package com.javadwarf.leetcode.subarray;

public class _209_MinimumSizeSubarraySum {

	public static void main(String[] args) {

	}

	/*
	 * Algorithm

	1. Initialize left pointer to 0 and sum to 0
	2. Iterate over the nums:
		a. Add nums[i] to sum
		b. While sum is greater than or equal to s:
			Update ans=min(ans,i+1−left), where i+1−left is the size of current subarray
			It means that the first index can safely be incremented, since, the minimum subarray starting with this index with sum≥s has been achieved
			Subtract nums[left] from sum and increment left
	 */

	public int minSubArrayLen(int s, int[] nums) {

		if(nums==null || nums.length == 0) return 0;

		int result = Integer.MAX_VALUE;

		int sum = 0;
		int left  = 0;

		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			while(sum >= s) {
				result = Math.min(result, i-left);
				sum -= nums[left];
				left++;
			}
		}
		return result==Integer.MAX_VALUE ? 0 : result+1;//note  answer would be (result+1)
	}

}
