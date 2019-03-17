package com.javadwarf.leetcode;

import java.util.Scanner;

public class _268_MissingNumber {

	public static void main (String[] args)
	{



	}



	public static int missingNumber(int[] nums) {

		int sumRange = (nums.length * (nums.length+1))/2;
		int sumArr = 0;

		for(int i = 0; i<nums.length; i++ ) {
			sumArr += nums[i];
		}
		return sumRange - sumArr;
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
