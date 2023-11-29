package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _44_WildcardMatching {

	public static void main(String[] args) {
		System.out.println(new _44_WildcardMatching().isMatch("", "*"));
	}

	//top-down
	Boolean[][] dp;
	public boolean isMatchTopDown(String s, String p) {
		dp = new Boolean[s.length()][p.length()];
		return helper(s,p,0,0);
	}

	public boolean helper(String s, String p, int i, int j){

		if(i==s.length() && j == p.length()) return true;

		if(i==s.length()){
			int x = j;
			while(x < p.length()){
				if(p.charAt(x++) != '*')
					return false;
			}
			return true;
		}
		if(i!=s.length() && j == p.length()) return false;
		if(i==s.length() && j != p.length()) return false;

		if(dp[i][j] != null) return dp[i][j];

		char ch1 = s.charAt(i);
		char ch2 = p.charAt(j);

		boolean res = false;

		if(ch1 == ch2 || ch2 == '?'){
			res = res || helper(s,p,i+1,j+1);
		}
		else if( ch2 == '*'){
			res = res || helper(s,p,i,j+1) || helper(s,p,i+1,j) ;
		}
		dp[i][j] = res;
		return res;
	}


	//Bottom up
	public boolean isMatch(String s, String p) {

		boolean[][] matrix = new boolean[s.length()+1][p.length()+1];

		for(int i=0; i<matrix.length; i++ ) {
			for(int j= 0; j<matrix[i].length; j++ ) {
				if(i==0 && j==0) {
					matrix[i][j] = true;
				}
				else if(i==0 && j!=0) {
					if(p.charAt(j-1) == '*') {
						matrix[i][j] = matrix[i][j-1];
					}
				}
				else if(i!=0 && j==0) {
					matrix[i][j] = false;
				}
				else {
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
						matrix[i][j] = matrix[i-1][j-1];
					}
					else if(p.charAt(j-1) == '*') {
						matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-1] || matrix[i][j-1];
					}
				}
			}
		}
		return matrix[s.length()][p.length()];
	}
}


