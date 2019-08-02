package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _647_PalindromicSubstringsCount {

	public int countSubstrings(String s) {
		
		if(s == null || s.length() == 0) return 0;
		
		int[][] matrix = new int[s.length()][s.length()];

		int count = 1;

		for(int k=0; k<s.length();k++) {
			for(int i=0,j=k; j<s.length() ;i++,j++) {
				if(i==j) {
					matrix[i][j] = 1;
				}
				else if(s.charAt(i) == s.charAt(j) && (matrix[i+1][j-1] != 0 || j-i==1)) {
					matrix[i][j] = 2+matrix[i+1][j-1];
					count++;
				}
			}
		}
		return count;
	}

}
