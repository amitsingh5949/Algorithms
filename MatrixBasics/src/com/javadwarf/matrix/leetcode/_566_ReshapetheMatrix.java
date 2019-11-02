package com.javadwarf.matrix.leetcode;

public class _566_ReshapetheMatrix {

	public static void main(String[] args) {

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		
		if(nums== null || nums.length ==0  ||  (nums.length*nums[0].length != r*c) ) return nums;
		
		int[][] res = new int[r][c];
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i<nums.length; i++) {
			for(int j= 0; j<nums.length; j++) {
				
				res[x][y] = nums[i][j];
				
				y++;
				if(y == c) {
					x++;
					y = 0;
				}
			}
		}
		
		return res;

	}

}
