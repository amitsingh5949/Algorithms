package com.javadwarf.dynamicprogramming.leetcode.lis;

public class _55_JumpGame {

	public static void main(String[] args) {

	}

	
	// DP approach - O(n^2) and O(n)
	// In this approach we store the min jump needed for each element by traversing nums[i] distance for every ith element
	public boolean canJump(int[] nums) {

		int[] jumpCount = new int[nums.length];

		for(int i=0; i<nums.length; i++) {

			if( i!=0 && jumpCount[i] == 0) return false; 

			for(int j=i+1; j<=i+nums[i] && j<nums.length; j++) {

				int nextCount = jumpCount[i] + 1;

				if(j == nums.length-1) {
					return true;
				}
				else if(jumpCount[j] == 0 || jumpCount[j] > nextCount) {
					jumpCount[j] = nextCount;
				}
			}	
		}
		return true;
	}
}
