package com.javadwarf.leetcode;

import java.util.Arrays;

//XOR
public class _268_MissingNumber {

	public static int missingNumber(int[] nums) {

		int sumRange = (nums.length * (nums.length+1))/2;
		int sumArr = 0;

		for(int i = 0; i<nums.length; i++ ) {
			sumArr += nums[i];
		}
		return sumRange - sumArr;
	}
	
	//same as above, less LOC
	public int missingNumber11(int[] nums) {
        return (nums.length * (nums.length + 1))/2 - Arrays.stream(nums).sum();
    }

	public static int missingNumber1(int[] nums) {

		int sumRange = 0;

		for(int i=1; i<nums.length; i++) {
			sumRange ^= i;

		}

		int sumArr = 0;

		for(int i = 0; i<nums.length; i++ ) {
			sumArr ^= nums[i];
		}
		return sumRange ^ sumArr;
	}




}
