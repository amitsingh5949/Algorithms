package com.javadwarf.dynamicprogramming;

import java.util.Scanner;

public class PalindromPartitioning {

	public static void main(String[] args){
		String s1 = null;
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			s1 = in.next();
			System.out.println(palindromPartition(s1));
		}
		in.close();
	}
	
	
	public static int palindromPartition(String a ){

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
							if(c[i-1]==c[j-1] && matrix[i+1][j-1] == 0){
								matrix[i][j] = 0;
							}
							else{
								int min = Integer.MAX_VALUE;
								for(int x=i; x<j; x++){
									int temp = matrix[i][x] + matrix[x+1][j];
									if(temp<min) min = temp;
								}
								matrix[i][j] = min + 1;
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

	// below method is wrong solution
	public static int palindromPartition1(String a ){

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