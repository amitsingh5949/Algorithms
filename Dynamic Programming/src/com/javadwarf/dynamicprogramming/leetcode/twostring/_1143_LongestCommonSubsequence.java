package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _1143_LongestCommonSubsequence {

	//top-down
	// if same starting char in both strings then check remaining string and if different try removing first character from each string 
	public int longestCommonSubsequenceBUP(String text1, String text2) {
		return lcs(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
	}

	public int lcs(String s1, String s2, int p, int q, Integer[][] dp){

		if(p == s1.length() || q == s2.length()) return 0;

		if(dp[p][q] != null) return dp[p][q];

		dp[p][q] = 0;

		if(s1.charAt(p) == s2.charAt(q)) 
			dp[p][q] = Math.max(dp[p][q], 1 + lcs(s1,s2,p+1,q+1,dp));
		else
			dp[p][q] = Math.max(dp[p][q], Math.max( lcs(s1,s2,p,q+1,dp), lcs(s1,s2,p+1,q,dp))) ;

		return dp[p][q];
	}

	//bottom-up
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
