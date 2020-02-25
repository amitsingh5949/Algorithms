package com.javadwarf.matrix.leetcode;

public class _304_RangeSumQuery2DImmutable {

	public static void main(String[] args) {

	}
	
	int[][] matrix = null;
	int[][] dp = null;

	//we are calculating the area till the index[i][j] from origin [0][0] 
	public _304_RangeSumQuery2DImmutable(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		
		this.matrix = matrix;
		dp = new int[matrix.length][matrix[0].length];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j] - dp[i][j];
			}
		}
	}

	//Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2+1][col2+1] - dp[row2+1][col2] - dp[row2][col2+1] + dp[row2][col2];
	}

}
