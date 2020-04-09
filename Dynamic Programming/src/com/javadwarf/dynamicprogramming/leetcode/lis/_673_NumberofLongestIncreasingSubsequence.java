package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _673_NumberofLongestIncreasingSubsequence {

	public static void main(String[] args) {
		//System.out.println(new _673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1,3,5,4,7}));
		//System.out.println(new _673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2,2,2,2,2}));
		System.out.println(new _673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
	}

	
	
	public int findNumberOfLIS(int[] nums) {

		if(nums == null || nums.length ==0 ) return 0;

		int[] count = new int[nums.length];
		Arrays.fill(count, 1);
		int[] output = new int[nums.length];

		for(int i=0; i<nums.length; i++) {
			output[i] = 1;
			for(int j=i-1; j>=0; j--) {
				if(nums[j] < nums[i]) {
					if(output[i] < output[j] + 1) {
						
					}
				}
			}
		}
		
		int result = 1;
		return result;
	}
}
