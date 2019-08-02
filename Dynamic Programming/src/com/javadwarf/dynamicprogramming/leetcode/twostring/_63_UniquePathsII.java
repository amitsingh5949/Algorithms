package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _63_UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if(obstacleGrid==null || obstacleGrid.length==0) return 0;

		int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length]; 
		
		boolean foundObstacle = false;
		
		for(int i=0; i<matrix.length; i++) {
			if(obstacleGrid[i][0]== 0 && !foundObstacle) {
				matrix[i][0] = 1;
			}
			else {
				foundObstacle = true;
			}
		}
		
		foundObstacle = false;
		
		for(int j=0; j<matrix[0].length; j++) {
			if(obstacleGrid[0][j]== 0 && !foundObstacle) {
				matrix[0][j] = 1;
			}
			else {
				foundObstacle = true;
			}
		}
		

		for(int i=0;i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length; j++) {
				if(obstacleGrid[i][j] != 1 && i!=0 && j!=0) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
	

	public int uniquePaths(int[][] obstacleGrid) {

		if(obstacleGrid==null || obstacleGrid.length==0) return 0;

		int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length]; 

		boolean foundObstacleInFirstRow = false;

		boolean foundObstacleInFirstCol = false;

		for(int i=0;i<matrix.length; i++) {
			for(int j=0;j<matrix[i].length; j++) {
				if(obstacleGrid[i][j] == 1) {
					if(i==0) {
						foundObstacleInFirstRow = true;
					}
					if(j==0) {
						foundObstacleInFirstCol = true;
					}
				}
				else {
					if(i==0 && !foundObstacleInFirstRow ) {
						matrix[i][j] = 1;
					}
					else if(j==0 && !foundObstacleInFirstCol) {
						matrix[i][j] = 1;
					}
					else if(i!=0 && j!=0) {
						matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
					}
					
				}
			}
		}
		return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
}
