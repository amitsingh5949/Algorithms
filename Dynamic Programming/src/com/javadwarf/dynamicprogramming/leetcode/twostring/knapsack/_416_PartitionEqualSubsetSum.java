package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Arrays;

public class _416_PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,5,11,5}));
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,2,3,5}));
		System.out.println(new _416_PartitionEqualSubsetSum().canPartition(new int[] {1,2,5}));
	}

	public boolean canPartition(int[] nums) {
		Arrays.parallelSort(nums);

		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}

		if(sum%2 != 0) return false;
		sum = sum/2;

		boolean[][] matrix = new boolean[nums.length+1][sum+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(i==0 ) {
					matrix[i][j] = false;
				}
				else if(j==0) {
					matrix[i][j] = true;
				}
				else if(nums[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					matrix[i][j] = matrix[i-1][j] || matrix[i-1][j - nums[i-1]]; //as one number can be used only once
				}
			}
		}
		return matrix[nums.length][sum];
	}
}
