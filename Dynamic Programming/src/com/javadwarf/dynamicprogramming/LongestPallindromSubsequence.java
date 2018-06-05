package com.javadwarf.dynamicprogramming;

public class LongestPallindromSubsequence {

	public static void main(String[] args){
		
		System.out.println(longestPallindromSubsequence("cbdadc"));
	}

	public static int longestPallindromSubsequence(String a ){

		int max = 0 ;
		char[] c = a.toCharArray();
		int[][] matrix = new int[c.length+1][c.length+1]; 

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
					if(i==0 || j==0){
						matrix[i][j] = 0;
					}
					else {
						if(i==j) {
							matrix[i][j] = 1;
						}
						else if(i<j){
							if(c[i-1]==c[j-1]){
								matrix[i][j] = matrix[i+1][j-1] + 2;
								if(matrix[i][j] > max)
									max = matrix[i][j];
							}
							else{
								matrix[i][j] = Math.max(matrix[i][j-1], matrix[i+1][j]);	
							}
						}
						else{
							matrix[i][j] = 0;
						}
					}
				}
			}
		return max;
	}

}