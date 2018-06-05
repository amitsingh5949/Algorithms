package com.javadwarf.dynamicprogramming;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		/*int l1 =0;
		int l2 =0;
		char[] c1=null;
		char[] c2 = null;
		String s1 = null;
		String s2 = null;
		
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			l1 = in.nextInt();
			l2 = in.nextInt();
			s1 = in.next();
			s2 = in.next();
			System.out.println(editDistance(s1,s2));
		}
		in.close();*/
		System.out.println(editDistance("lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq", 
				"hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh"));
		System.out.println(editDistance("sunday","saturday"));
	}

	public static int editDistance(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int[][] matrix = new int[c2.length+1][c1.length+1];

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i== 0){
					matrix[i][j] = j;
				}
				else if( j==0){
					matrix[i][j] = i;
				}
				else {
					if(c2[i-1]==c1[j-1]){
						matrix[i][j] = matrix[i-1][j-1];
					}
					else{
						/*if(i<j){
							matrix[i][j] = matrix[i][j-1] +1;
						}
						else if(i==j){
							matrix[i][j] = matrix[i-1][j-1] +1;
						}
						else if(i>j){
							matrix[i][j] = matrix[i-1][j] +1;
						}*/
						matrix[i][j] = Math.min(matrix[i][j-1],
								Math.min(matrix[i-1][j-1] ,matrix[i-1][j])) +1;
					}
				}
			}
		}
		return matrix[c2.length][c1.length];
	}
}

