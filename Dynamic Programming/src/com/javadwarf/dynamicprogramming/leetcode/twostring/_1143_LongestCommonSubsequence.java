package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _1143_LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {

		char[] arr1 = text1.toCharArray(); 
		char[] arr2 = text2.toCharArray(); 

		int[][] matrix = new int[arr1.length+1][arr2.length+1];

		for(int i=1 ; i<matrix.length; i++) {
			for(int j=1 ; j<matrix[i].length; j++) {

				if(arr1[i-1] == arr2[j-1]) {
					matrix[i][j] = matrix[i-1][j-1] + 1;
				}
				else {
					matrix[i][j] = Math.max(matrix[i][j-1] , matrix[i-1][j]);
				}
			}
		}

		return matrix[arr1.length][arr2.length];
	}

}
