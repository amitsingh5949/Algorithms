package com.javadwarf.dynamicprogramming.singleString;

import java.util.Scanner;

public class LongestPallindromSubstring {

	public static void main(String[] args){
		String s1 = null;

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			s1 = in.next();
			System.out.println(longestPallindromSubstring(s1));
		}
		in.close();
		//System.out.println(longestPallindromSubstring("cbdadc"));
	}

	public static int longestPallindromSubstring(String a ){

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
						if(c[i-1]==c[j-1] && matrix[i+1][j-1] != 0){
							matrix[i][j] = matrix[i+1][j-1] + 2;
							if(matrix[i][j] > max)
								max = matrix[i][j];
						}
						else{
							matrix[i][j] = 0;	
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