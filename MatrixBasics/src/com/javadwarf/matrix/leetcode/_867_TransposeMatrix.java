package com.javadwarf.matrix.leetcode;

public class _867_TransposeMatrix {

	public static void main(String[] args) {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		new _867_TransposeMatrix().transpose(A);

	}
	public int[][] transpose(int[][] A) {
		int[][] B = new int[A[0].length][A.length];
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A[0].length; j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}

	//works only on n*n matrix
	public int[][] transpose1(int[][] A) {
		
		if( A == null || A.length==0) return A;
		
		for(int k=1; k<A[0].length; k++) {
			
			int i1 = 0 ;
			int i2 = 0;
			for(int j=k; j<A[0].length; j++, i1++, i2++) {
				int temp = A[i1][j];
				A[i1][j] = A[j][i2] ;
				A[j][i2] = temp;
			}
			
		}
		return A;
	}

}
