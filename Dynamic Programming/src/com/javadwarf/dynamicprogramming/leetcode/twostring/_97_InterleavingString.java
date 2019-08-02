package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _97_InterleavingString {

	public static void main(String[] args) {
		System.out.println(new _97_InterleavingString().isInterleave("aab", "axy", "aaxaby"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {

		if(s3.length() != s1.length()+s2.length()) return false;

		boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j =0; j<matrix[i].length;j++) {

				if(i==0 || j==0) {
					if(i==0 && j==0) {
						matrix[i][j] = true;
					}
					else if(i==0) {
						if(matrix[i][j-1] && s3.charAt(j-1) == s2.charAt(j-1) ) {
							matrix[i][j] = true;
						}
					}
					else if(j==0) {
						if(matrix[i-1][j] && s3.charAt(i-1) == s1.charAt(i-1) ) {
							matrix[i][j] = true;
						}
					}
				}
				else {
					if( s3.charAt(i+j-1) != s1.charAt(i-1) && s3.charAt(i+j-1) != s2.charAt(j-1)){						
						matrix[i][j] = false;
					}
					else if( s3.charAt(i+j-1) == s1.charAt(i-1) && s3.charAt(i+j-1) == s2.charAt(j-1)){						
						matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
					}
					else if( (s3.charAt(i+j-1) == s1.charAt(i-1)) && matrix[i-1][j] ) {
						matrix[i][j] = true;
					}
					else if(s3.charAt(i+j-1) == s2.charAt(j-1) && matrix[i][j-1] ) {
						matrix[i][j] = true;
					}
				}
			}
		}

		return matrix[s1.length()][s2.length()];

	}

}
