package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _300_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		//System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLISBS(new int[] {1,3,6,7,9,4,10,5,6}));
		System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLISBS(new int[] {3,5,6,2,5,4,19,5,6,7,12}));
	}

	// DP based solution - O(n^2) and O(n)
	public int lengthOfLIS(int[] nums) {

		if(nums == null || nums.length == 0) return 0;

		int result = 1;

		int[] output = new int[nums.length];

		for(int i=0; i<nums.length; i++) {

			output[i] = 1;

			for(int j=i-1; j>=0; j--) {
				if(nums[j] < nums[i]) {
					output[i] = Integer.max(output[i], output[j] + 1);
					result = Integer.max(result, output[i]);
				}
			}
		}
		return result;
	}


	// Binary Search based solution - O(nlogn) and o(n)
	public int lengthOfLISBS(int[] nums) {

		if(nums == null || nums.length == 0) return 0;

		int last = 0;
		int[] output = new int[nums.length];
		output[0] = nums[0];

		for(int i=1; i<nums.length; i++) {

			if(output[last] < nums[i]) {
				output[++last] = nums[i];
			}
			else {
				// apply binary search in output array to find place where we need to replace
				int start = 0;
				int end = last;
				int mid = (start + end)/2;
				 
				while(start <= end) {
					mid = (start + end)/2;
                    if(output[mid] == nums[i]){
                    	start = mid;
                        break ;
                    }
					else if(output[mid] > nums[i]) {
						end = mid-1;
					}
					else {
						start = mid+1;
					}
				}
				output[start] = nums[i];
			}
		}
		return last+1;
	}
}
