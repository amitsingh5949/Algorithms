package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _516_LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		
		if(s==null || s.length() == 0) return 0;

		int[][] matrix = new int[s.length()][s.length()];

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
				if(i == j) {
					matrix[i][j] = 1;
				}
				else if(s.charAt(i) == s.charAt(j)) {
					matrix[i][j] = 2 + matrix[i+1][j-1];
				}
				else {
					matrix[i][j] = Integer.max(matrix[i+1][j], matrix[i][j-1]);
				}
			}
		}
		return matrix[0][s.length()-1];
	}
}
