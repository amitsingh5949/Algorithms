package com.javadwarf.dynamicprogramming.leetcode.twostring;

//variation of longestCommonSubSequence dynamic programming

public class _583_DeleteOperationforTwoStrings {
	
	public static void main(String[] args) {
		System.out.println(new _583_DeleteOperationforTwoStrings().minDistance("sea", "eat"));
	}
	
	public int minDistance(String word1, String word2) {
		return (word1.length()+word2.length()- 2*longestCommonSubSequence(word1, word2));
	}

	private int longestCommonSubSequence(String word1, String word2) {

		int[][] matrix = new int[word1.length()+1][word2.length()+1];

		for(int i=0; i<matrix.length; i++) {
			
			for(int j=0; j<matrix[i].length; j++) {

				if(i==0||j==0) {
					matrix[i][j] = 0;
				}
				else {
					if(word1.charAt(i-1) == word2.charAt(j-1)){
						matrix[i][j] = 1+matrix[i-1][j-1];
					}
					else{
						matrix[i][j] = Integer.max(matrix[i-1][j], matrix[i][j-1]);
					}
				}
			}	
		}
		return matrix[word1.length()][word2.length()];
	}
}
