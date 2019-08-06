package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _44_WildcardMatching {

	public static void main(String[] args) {
		System.out.println(new _44_WildcardMatching().isMatch("", "*"));
	}

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
