package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _64_MinimumPathSum {

	public int minPathSum(int[][] grid) {
		
		if(grid== null || grid.length==0) return 0;
		
		int[][] matrix = new int[grid.length][grid[0].length];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(i==0 && j==0) {
					matrix[i][j] = grid[i][j];
				}
				else if(i==0 && j!=0) {
					matrix[i][j] =  matrix[i][j-1] + grid[i][j];
				}
				else if(i!=0 && j==0) {
					matrix[i][j] =   matrix[i-1][j] + grid[i][j];
				}
				else {
					matrix[i][j] = Integer.min(matrix[i][j-1] ,matrix[i-1][j]) + grid[i][j];
				}
			}
		}
		return matrix[grid.length-1][grid[0].length-1];
	}
}
