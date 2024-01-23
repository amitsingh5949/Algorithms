package com.javadwarf.matrix.leetcode;

public class _48_RotateImage {

	public static void main(String[] args) {

	}

	
	// transpose solution
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
	
	// Approach : reverse all diagonals and then reverse all columns
	public void rotate1(int[][] matrix) {
        for(int j=0;j<matrix[0].length;j++) reverseDiagonal(matrix,0,j);
        for(int i=1;i<matrix.length;i++) reverseDiagonal(matrix,i,0);
        for(int j=0;j<matrix[0].length;j++) reverseColumn(matrix,0,j);
    }
    
    public void reverseDiagonal(int[][] matrix, int i, int j){
        int x = i, y = j;
        while(x<matrix.length && y<matrix[0].length){
            x++; y++;
        } 
        x--; y--;
        
        while(i<x && j<y){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[x][y];
            matrix[x][y] = temp;
            i++; j++; x--; y--;
        }
    }
    
    public void reverseColumn(int[][] matrix, int i, int j){
        int x = matrix.length-1, y = j;
        while(i<x){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[x][y];
            matrix[x][y] = temp;
            i++; x--;
        }
    }

}


