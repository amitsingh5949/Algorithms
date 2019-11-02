package com.javadwarf.matrix.leetcode;

public class _48_RotateImage {

	public static void main(String[] args) {

	}

	public void rotate(int[][] matrix) {

		transpose(matrix);

		for(int i= 0; i<matrix.length; i++) {

			int start = 0;

			int end = matrix[i].length;

			while(start < end) {
				int temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;
			}
		}
	}

	public void transpose(int[][] A) {

		for(int k=1; k<A[0].length; k++) {
			int i1 = 0 ;
			int i2 = 0;
			for(int j=k; j<A[0].length; j++, i1++, i2++) {
				int temp = A[i1][j];
				A[i1][j] = A[j][i2] ;
				A[j][i2] = temp;
			}
		}
	}

}
