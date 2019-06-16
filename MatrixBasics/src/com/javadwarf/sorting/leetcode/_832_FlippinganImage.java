package com.javadwarf.sorting.leetcode;

public class _832_FlippinganImage {

	public static void main(String[] args) {
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(flipAndInvertImage(A));
	}

	public  static int[][] flipAndInvertImage(int[][] A) {

		int start = 0;
		int end = A.length-1;

		for(int i = 0; i<A.length; i++) {

			start = 0;
			end = A.length-1;

			while(start <= end) {
				int temp = A[i][end];
				A[i][end] = A[i][start];
				A[i][start] = temp;

				A[i][start] ^= 1; // xor will filp the element
				if(start!= end)
					A[i][end] ^= 1;
				start++;
				end--;
			}
		}

		return A;

	}

}
