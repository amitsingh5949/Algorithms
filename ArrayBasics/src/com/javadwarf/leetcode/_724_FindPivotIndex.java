package com.javadwarf.leetcode;

public class _724_FindPivotIndex {

	public static void main(String[] args) {

	}
	public int pivotIndex(int[] nums) {

		int res = -1;

		if(nums == null || nums.length==0) return res;

		int sum = 0;
		int leftSum = 0;

		for(int x : nums) {
			sum += x;
		}

		for(int i=0; i<nums.length; i++) {
			
			if(leftSum == sum - nums[i]- leftSum) {
				return i;
			}
			leftSum += nums[i];
		}
		return res;
	}
}
