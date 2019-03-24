package com.javadwarf.leetcode;

import java.util.Arrays;

public class _561_ArrayPartition1 {
	

	public int arrayPairSum(int[] nums) {
		
		if(nums==null || nums.length==0) return 0;
		
		int result = 0;
		
		
		
		return result;

	}
	
	// sort the array, answer would be sum of 2nd max, 4th max, 6th max.... last max i.e 1st min
	public int arrayPairSum1(int[] nums) {
		
		if(nums==null || nums.length==0) return 0;
		
		int result = 0;
		
		Arrays.sort(nums);
		
		for(int i =0 ; i<nums.length; i = i+2) {
			result += nums[i];
		}
		
		return result;

	}
}
