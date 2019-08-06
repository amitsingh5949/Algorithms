package com.javadwarf.dynamicprogramming.leetcode.twostring;

import java.util.Scanner;

public class _887_SuperEggDrop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int i=0;i<test;i++) {
			System.out.println(superEggDrop(s.nextInt(), s.nextInt()));
		}
		s.close();
		
		
		//System.out.println(new _887_SuperEggDrop().superEggDrop(1, 2));
	}

	// TLE on leetcode o(KN^2) + O(k*N)
	public static  int superEggDrop(int K, int N) {

		int[][] matrix = new int[K+1][N+1];

		for(int i=0; i<matrix.length; i++) {
			for(int j =0; j<matrix[i].length; j++) {
				if(i==0 || j==0) {
					matrix[i][j] = 0;
				}
				else if(i==1) {
					matrix[i][j] = j;
				}
				else if(i>j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					int min = Integer.MAX_VALUE;
					for(int x=1; x<=j; x++) {
						int temp = 1 + Integer.max(matrix[i-1][x-1], matrix[i][j-x]);
						min = Integer.min(min,temp);
					}
					matrix[i][j] = min;
				}
			}
		}
		return matrix[K][N];
	}

}
