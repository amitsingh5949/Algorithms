package com.javaDwarf.leetcode;

import java.util.Arrays;

public class _698_PartitiontoKEqualSumSubsets {

	public static void main(String[] args) {
		/*System.out.println(canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
		System.out.println(canPartitionKSubsets(new int[] {4, 3, 2, 3, 6, 1, 1}, 4));
		System.out.println(canPartitionKSubsets(new int[] {2,2,2,2,3,4,5}, 4));

		System.out.println(canPartitionKSubsets(new int[] {2,2,10,5,2,7,2,2,13}, 3));
		System.out.println(canPartitionKSubsets(new int[] {2,2,7,2,2,10,5,2,13}, 3));

		System.out.println(canPartitionKSubsets(new int[] {1,2,2,2,2}, 3));*/
		System.out.println(canPartitionKSubsets(new int[] {10,10,10,7,7,7,7,7,7,6,6,6}, 3));
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {

		Arrays.parallelSort(nums);
		for(int i=0, j=nums.length-1; i<j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		boolean result = false;

		if(nums == null || nums.length == 0) return false;

		int sum = 0 ;
		for(int i : nums) {
			sum += i; 
		}

		if(sum%k != 0) return false;
		int targetSum = sum/k;

		for(int i=0; i<nums.length; i++ ) {
			if(nums[i] != Integer.MIN_VALUE) {
				int temp = nums[i];
				nums[i] = Integer.MIN_VALUE;
				result = recFunc(nums, targetSum-temp, i+1, result);
				if(result == false) {
					return false;
				}
			}
		}
		return result;
	}

	public static boolean recFunc(int[] nums, int sum, int index, boolean result ) {

		if(sum < 0) {
			return false;
		}

		if(sum == 0) {
			return true;
		}

		for(int i = index ; i< nums.length; i++) {
			if(nums[i] != Integer.MIN_VALUE) {
				int temp = nums[i];
				nums[i] = Integer.MIN_VALUE;
				result = recFunc(nums, sum-temp, i+1, result);
				if(result == false && i==nums.length-1) {
					nums[i] = temp;
					return false;
				}
				else if(result == true) {
					return true;
				}
				else if(result == false && i<nums.length-1) {
					nums[i] = temp;
				}
			}
		}
		return result;
	}

}
