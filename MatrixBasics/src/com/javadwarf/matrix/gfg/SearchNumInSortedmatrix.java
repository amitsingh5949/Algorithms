package com.javadwarf.matrix.gfg;

import java.util.Scanner;

public class SearchNumInSortedmatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int row = s.nextInt();
			int col = s.nextInt();
			int[][] matrix = new int[row][col];
			for(int x=0; x<row; x++) {
				for(int y=0; y<col; y++) {
					matrix[x][y] = s.nextInt();
				}
			}
			int k = s.nextInt();
			System.out.println(search(matrix, row, col, k));
		}
		s.close();
	}

	private static int search(int[][] matrix, int row, int col, int k) {
		int result = 0;
		int x = 0;
		int y = 0;
		while(true) {
			if(matrix[x][y]==k) {
				result = 1;
				break;
			}
			if(x+1 < row && k >= matrix[x+1][y]) {
				x = x+1;
			}
			else if(y+1 < col && k >= matrix[x][y+1] ) {
				y = y+1;
			}
			else if( (x+1< row && y+1< col && k<= matrix[x+1][y] && k<=matrix[x][y+1]) ||
					(x+1 == row && y+1 == col && matrix[x][y]!=k) ||
					(x+1 == row && y+1<col &&  k<=matrix[x][y+1]) ||
					(x+1 < row && y+1 == col &&  k<=matrix[x+1][y]) ){
				result = 0;
				break;
			}
		}
		return result;
	}
}
