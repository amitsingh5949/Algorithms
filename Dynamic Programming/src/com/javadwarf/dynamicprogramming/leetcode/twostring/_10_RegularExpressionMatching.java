package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _10_RegularExpressionMatching {

	public static void main(String[] args) {

	}
	
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
