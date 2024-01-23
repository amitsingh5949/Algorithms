package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _10_RegularExpressionMatching {

	public static void main(String[] args) {

	}

	//top-down
	public boolean isMatchTD(String s, String p) {
		return helper(s,p,0,0,new Boolean[s.length()][p.length()]);
	}

	public boolean helper(String s, String t, int i, int j, Boolean[][] dp){

		if(i == s.length() && j == t.length()) return true;
		if(i != s.length() && j == t.length()) return false;


		if(i == s.length() &&  j != t.length()){
			if(t.length() - j == 1 || t.charAt(j+1) != '*') return false;
			return helper(s,t,i,j+2,dp);
		}

		char ch1 = s.charAt(i);
		char ch2 =  t.charAt(j);
		char ch3 = '\0';
		if(j+1 < t.length()){
			ch3 = t.charAt(j+1);
		}
		if(dp[i][j] != null) return dp[i][j];

		if(ch3 == '*'){
			if(ch1 == ch2 || ch2 == '.'){
				dp[i][j] = helper(s,t,i+1,j,dp) || helper(s,t,i,j+2,dp);
			}
			else{
				dp[i][j] = helper(s,t,i,j+2,dp);
			}
		}
		else if(ch1 == ch2 || ch2 == '.'){
			dp[i][j] = helper(s,t,i+1,j+1,dp);
		}
		else{
			dp[i][j] = false;
		}
		return dp[i][j];
	}

	//bottom-up
	public boolean isMatch(String s, String p) {

		boolean[][] matrix = new boolean[s.length()+1][p.length()+1];

		for(int i=0; i<matrix.length; i++ ) {
			for(int j= 0; j<matrix[i].length; j++ ) {
				if(i==0 && j==0) {
					matrix[i][j] = true;
				}
				else if(i==0 && j!=0) {
					if(p.charAt(j-1) == '*'){
						matrix[i][j] =  matrix[i][j-2];
					}
				}
				else if(i!=0 && j==0) {
					matrix[i][j] = false;
				}
				else {
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
						matrix[i][j] = matrix[i-1][j-1]; 
					}
					else if(p.charAt(j-1) == '*') {
						matrix[i][j] = matrix[i][j-2]; //// 0 Occurrences of character before *
						if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
							matrix[i][j] = matrix[i][j] || matrix[i-1][j]; //// for 1 or more Occurrences of character before * ( consider case xa* and xa for 1 or more occurrences we check xa* and x
						}
					}
				}
			}
		}
		return matrix[s.length()][p.length()];
	}

}
