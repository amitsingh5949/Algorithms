package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _221_MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length ==0) return 0;
		
		int[][] result = new int[matrix.length+1][matrix[0].length+1];
		
		int max = 0;
		
		for(int i=0; i<result.length; i++) {
			for(int j=0;j<result[i].length;j++) {
				
				if(i != 0 && j != 0 && matrix[i-1][j-1] == '1') {
					result[i][j] = 1 + Integer.min(result[i-1][j-1], Integer.min(result[i][j-1], result[i-1][j]));
					max = Integer.max(max,result[i][j]);
				}
			}
		}
		return max*max;
	}
}
