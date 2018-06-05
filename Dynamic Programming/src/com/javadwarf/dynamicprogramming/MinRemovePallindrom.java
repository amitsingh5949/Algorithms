package com.javadwarf.dynamicprogramming;

public class MinRemovePallindrom {

	public static void main(String[] args){
		
		System.out.println(minRemovePallindrom("aebcbda"));
	}

	public static int minRemovePallindrom(String a ){

		char[] c = a.toCharArray();
		int[][] matrix = new int[c.length+1][c.length+1]; 

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
					if(i==0 || j==0){
						matrix[i][j] = 0;
					}
					else {
						if(i==j) {
							matrix[i][j] = 0;
						}
						else if(i<j){
							if(c[i-1]==c[j-1]){
								matrix[i][j] = matrix[i+1][j-1];
							}
							else{
								matrix[i][j] = Math.min(matrix[i][j-1], matrix[i+1][j]) + 1;
							}
						}
						else{
							matrix[i][j] = 0;
						}
					}
				}
			}
		return matrix[1][c.length]; 
	}

}