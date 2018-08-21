package com.javadwarf.dynamicprogramming.twoString;

import java.util.Scanner;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		int l1 =0;
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
			System.out.println(longestSubSequence(s1,s2));
		}
		in.close();
		
	}

	public static int longestSubSequence(String s1, String s2){
		int max  = 0 ;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int[][] matrix = new int[c2.length+1][c1.length+1];

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i== 0 || j==0){
					matrix[i][j] = 0;
				}
				else {
					if(c2[i-1]==c1[j-1]){
						matrix[i][j] = matrix[i-1][j-1]+1;
						if(matrix[i][j] > max)
							max = matrix[i][j];
					}
					else{
						matrix[i][j] = Math.max(matrix[i][j-1],matrix[i-1][j]);
					}
				}
			}
		}

		return max;
	}

}
