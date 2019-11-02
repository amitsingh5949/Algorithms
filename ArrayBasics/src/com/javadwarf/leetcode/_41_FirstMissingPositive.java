package com.javadwarf.leetcode;

public class _41_FirstMissingPositive {

	public static void main(String[] args) {

		//System.out.println(new _41_FirstMissingPositive().firstMissingPositive(new int[] {1,2,0}));
		//System.out.println(new _41_FirstMissingPositive().firstMissingPositive(new int[] {3,4,-1,1}));
		//System.out.println(new _41_FirstMissingPositive().firstMissingPositive(new int[] {7,8,9,11,12}));
		System.out.println(new _41_FirstMissingPositive().firstMissingPositive(new int[] {2,1}));
		System.out.println(new _41_FirstMissingPositive().firstMissingPositive(new int[] {Integer.MAX_VALUE}));

	}

	public int firstMissingPositive(int[] nums) {

		for(int i=0; i<nums.length; i++) {

			while(nums[i]>=1 && nums[i]<=nums.length) {

				int dest = nums[nums[i]-1];

				nums[nums[i]-1] = Integer.MIN_VALUE;

				if(dest >= 1 && dest <= nums.length) {
					if(nums[i] != Integer.MIN_VALUE) // this is condition added to pass test case {2,1} when dest updates the same num[i]
						nums[i] = dest;
				}
				else {
					nums[i] = -1;
				}
			}
		}

		for(int i=0; i<nums.length; i++) {
			if(nums[i] != Integer.MIN_VALUE) {
				return i+1;
			}
		}

		return nums.length+1;
	}

}
