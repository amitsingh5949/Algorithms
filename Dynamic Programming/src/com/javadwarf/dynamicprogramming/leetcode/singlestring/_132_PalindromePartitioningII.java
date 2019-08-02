package com.javadwarf.dynamicprogramming.leetcode.singlestring;

public class _132_PalindromePartitioningII {

	public static void main(String[] args) {
		System.out.println(new _132_PalindromePartitioningII().minCut("ababc"));
	}

	public int minCut(String s) {

		int[][] matrix = new int[s.length()][s.length()];

		for(int k =0; k<matrix.length; k++) {
			for(int i=0,j=k; j<matrix.length;i++,j++) {
				if(i==j) {
					matrix[i][j] = 0;
				}
				else if(s.charAt(i)==s.charAt(j) && matrix[i+1][j-1]==0) {
					matrix[i][j] = 0;
				}
				else {
					int min = Integer.MAX_VALUE;
					int start = i;
					for(int x=i; x<j; x++) {
						min = Integer.min(min,1 + matrix[start][x] +matrix[x+1][j]);
					}
					matrix[i][j] = min;
				}
			}
		}
		return matrix[0][s.length()-1];
	}
}
