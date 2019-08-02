package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _72_EditDistance {

	public static void main(String[] args) {
		System.out.println(new _72_EditDistance().minDistance("horse", "ros"));
	}


	public int minDistance(String word1, String word2) {

		int[][] matrix = new int[word1.length()+1][word2.length()+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j= 0; j<matrix[i].length; j++) {

				if(i==0 && j==0) {
					matrix[i][j] = 0;
				}
				else if(i==0 && j!=0) {
					matrix[i][j] = j;
				}
				else if(i!=0 && j==0) {
					matrix[i][j] = i;
				}
				else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1];
				}
				else {
					matrix[i][j] = Math.min(matrix[i][j-1],
							Math.min(matrix[i-1][j-1] ,matrix[i-1][j])) +1;
				}

			}

		}

		return matrix[word1.length()][word2.length()];
	}
}
