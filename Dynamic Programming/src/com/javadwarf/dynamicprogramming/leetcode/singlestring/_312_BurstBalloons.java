package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _312_BurstBalloons {

	public int maxCoins(int[] nums) {
		
		if(nums==null || nums.length==0) return 0;
		
		int[][] matrix = new int[nums.length][nums.length];
		
		for(int k=0; k<matrix.length;k++) {
			for(int i=0,j=k; j<matrix.length; i++,j++) {
				
				int max = Integer.MIN_VALUE;
				
				for(int x = i; x<=j;x++) {
					int left = 0;
					int right = 0;
					if(x != i) {
						left = matrix[i][x-1];
					}
					if(x != j) {
						right = matrix[x+1][j];
					}
					int curr = nums[x];
					if(i != 0 ) {
						curr *= nums[i-1];
					}
					if(j != nums.length-1) {
						curr *= nums[j+1];
					}
					max = Integer.max(max, left+curr+right);
				}
				matrix[i][j] = max;
			}
		}
		return matrix[0][nums.length-1];
	}
}
