package com.javadwarf.dynamicprogramming.gfg.twoString;

import java.util.Scanner;

public class MaxSquareSubMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int row = in.nextInt();
			int col = in.nextInt();
			int coin[][] = new int[row][col];
			for(int j=0; j<row; j++){
				for(int k=0; k<col; k++){
					coin[j][k] =  in.nextInt();
				}
			}
			System.out.println(maxSquare(coin, row, col));
		}
		in.close();
	}

	private static int maxSquare(int[][] coin, int row, int col) {
		int max = 0;
		int[][] matrix = new int[row+1][col+1];

		for(int j=0; j<=row; j++){
			for(int k=0; k<=col; k++){

				if(j!=0 && k!=0 && coin[j-1][k-1] != 0) {
					int temp = Integer.min(matrix[j-1][k-1], 
							Integer.min(matrix[j-1][k],matrix[j][k-1])) + 1;
					matrix[j][k] = temp;
					if(temp > max) 
						max = temp;
				}
			}
		}
		return max;
	}
}