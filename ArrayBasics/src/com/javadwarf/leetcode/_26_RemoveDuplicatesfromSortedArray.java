package com.javadwarf.leetcode;

//Two Pointer
public class _26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {1,2,2}));
	}


	public static int removeDuplicates(int[] nums) {
		int result = 0;


		for(int i =0 ; i<nums.length-1; i++) {
			if(nums[i]==nums[i+1]) {
				nums[i] = Integer.MIN_VALUE;
			}
		}

		for(int i =0 ; i<nums.length; i++) {
			if(nums[i] != Integer.MIN_VALUE) {
				result++;
			}
		}

		int blankIndex = 0;
		int filledIndex = 0;

		while(true) {
			
			while(blankIndex < nums.length && nums[blankIndex] != Integer.MIN_VALUE) {
				blankIndex++;
			}
			
			if(filledIndex < blankIndex) {
				filledIndex = blankIndex;
			}

			while(filledIndex < nums.length && nums[filledIndex] == Integer.MIN_VALUE) {
				filledIndex++;
			}
			
			
			if(filledIndex>= nums.length || blankIndex >= nums.length) {
				break;
			}

			nums[blankIndex] = nums[filledIndex];
			nums[filledIndex] = Integer.MIN_VALUE;

		}

		return result;

	}
}
