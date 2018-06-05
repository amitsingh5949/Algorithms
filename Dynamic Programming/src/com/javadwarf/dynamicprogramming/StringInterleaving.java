package com.javadwarf.dynamicprogramming;

import java.util.Scanner;

public class StringInterleaving {

	public static void main(String[] args) {
		/*String s1 = null;
		String s2 = null;
		String s3 = null;

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			s2 = in.next();
			s2 = in.next();
			s3 = in.next();
			System.out.println(stringInterleaving(s1,s2,s3));
		}
		in.close();*/
		System.out.println(stringInterleaving("xy", "wz","wzxy"));
	}

	public static boolean stringInterleaving(String s1, String s2,String s3){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		boolean[][] matrix = new boolean[c2.length+1][c1.length+1];

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){

				if(i == 0 || j == 0){
					if(i==0 && j==0){
						matrix[i][j] = true;
					}
					else{
						if(i==0){
							if(c1[j-1]==c3[j-1] ){
								matrix[i][j] = matrix[i][j-1];
							}
						}
						if(j==0){
							if(c2[i-1]==c3[i-1] ){
								matrix[i][j] = matrix[i-1][j];
							}
						}
					}
				}
				else{
					if(c2[i-1]==c3[i+j-1] && c1[j-1]!=c3[i+j-1]){
						matrix[i][j] = matrix[i-1][j];
					}
					else if(c1[j-1]==c3[i+j-1] && c2[i-1]!=c3[i+j-1]){
						matrix[i][j] = matrix[i][j-1];
					}
					else if(c2[i-1]==c3[i+j-1] && c1[j-1]==c3[i+j-1]){
						matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
					}
				}
			}
		}
		return matrix[c2.length][c1.length];
	}

	public static boolean stringInterleaving1(String s1, String s2,String s3){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		boolean[][] matrix = new boolean[c2.length+1][c1.length+1];

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){

				if(i == 0 || j == 0){
					if(i==0 && j==0){
						matrix[i][j] = true;
					}
					else{
						if(i==0){
							if(c1[j-1]==c3[j-1] && matrix[i][j-1]){
								matrix[i][j] = true;
							}
							else{
								matrix[i][j] = false;
							}
						}
						if(j==0){
							if(c2[i-1]==c3[i-1] && matrix[i-1][j]){
								matrix[i][j] = true;
							}
							else{
								matrix[i][j] = false;
							}
						}
					}
				}
				else{
					if(c2[i-1]==c3[i+j-1] || c1[j-1]==c3[i+j-1]){
						if(matrix[i-1][j] || matrix[i][j-1]){
							matrix[i][j] = true;
						}
						else{
							matrix[i][j] = false;
						}
					}
					else{
						matrix[i][j] = false;
					}
				}
			}
		}
		return matrix[c2.length][c1.length];
	}
}
