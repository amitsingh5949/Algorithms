package com.javadwarf.leetcode.slidingwindow;

public class _713_SubarrayProductLessThanK {

	public static void main(String[] args) {
		System.out.println(new _713_SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[] {10, 5,2,6},100));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		if(k <=1 || nums==null || nums.length ==0) return 0;

		int count = 0;

		int currProduct = 1;

		int start = 0;
		int end = 0;

		while(end<nums.length) {

			currProduct *= nums[end];

			while(currProduct >= k) {
				currProduct /= nums[start];
				start++;
			}
			count += (end - start + 1);
			end++;
		}
		return  count;
	}

}
