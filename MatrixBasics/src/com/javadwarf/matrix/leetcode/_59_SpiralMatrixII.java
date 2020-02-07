package com.javadwarf.matrix.leetcode;

public class _59_SpiralMatrixII {

	public static void main(String[] args) {
System.out.println();
	}

	public int[][] generateMatrix(int n) {
		
		int[][] matrix = new int[n][n];
		
		int startRow = 0;
		int endRow = n-1;
		int startCol = 0;
		int endCol = n-1;

		int count = 1;
		
		while(startRow<=endRow && startCol<=endCol) {

			for(int i=startCol; i<=endCol; i++) {
				matrix[startRow][i] = count++;
			}

			for(int i=startRow+1; i<=endRow; i++) {
				matrix[i][endCol]  = count++;
			}

			for(int i=endCol-1; i>=startCol && endRow>startRow; i--) {
				matrix[endRow][i]  = count++;
			}

			for(int i=endRow-1; i>=startRow+1 && endCol>startCol; i--) {
				matrix[i][startCol] = count++;
			}

			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}

		
		return matrix;

	}

}
