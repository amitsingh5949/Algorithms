package com.javadwarf.leetcode;

public class _665_NonDecreasingArray {

	public static void main(String[] args) {
		//[3,4,2,3]
	}

	public boolean checkPossibility(int[] nums) {
		
		int count = 0;
		
		for(int i =0 ; i<nums.length-1; i++) {
			
			if(nums[i]> nums[i+1]) {
				nums[i] = nums[i+1];
				count++;
			}
		}
		return count == 0 || count == 1;
	}

}
