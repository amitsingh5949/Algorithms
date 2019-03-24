package com.javadwarf.leetcode;

public class _643_MaximumAverageSubarrayI {

	public static void main(String[] args) {
			System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
	}

	public static double findMaxAverage(int[] nums, int k) {
		if(nums==null || nums.length==0) return 0;
		
		double result = 0 ;
		
		double maxSum = 0;
		
		for(int i =0; i < k; i++) {
			maxSum += nums[i];
		}
		
		result = maxSum;
		
		int start = 0;
		
		for(int i=k ; i<nums.length; i++) {
			
			maxSum = maxSum - nums[start] + nums[i];
			
			if(maxSum > result) {
				result = maxSum;
			}
			
			start = start +1;
		}
		
		return result/k;

	}

}
