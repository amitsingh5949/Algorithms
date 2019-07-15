package com.javadwarf.dynamicprogramming.gfg.singleString;

import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int coin[] = new int[size];
			for(int j=0; j<size; j++){
				coin[j] =  in.nextInt();
			}
			System.out.println(matrixChainMultiplication(coin));
		}
		in.close();
		
		//System.out.println(matrixChainMultiplication(new int[]{1,2,3,4,5}));

	}

	public static int matrixChainMultiplication(int[] arr){

		if(arr.length<=1){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int[][] matrix = new int[arr.length-1][arr.length-1];

		for(int k=0; k<matrix.length; k++){
			for(int i=0, j=k; j<matrix.length; i++,j++){
				min = Integer.MAX_VALUE;
				if(i==j){
					matrix[i][j] = 0;
				}
				else{
					int temp = 0;
					for(int x=i; x<j; x++){
						temp = matrix[i][x] + matrix[x+1][j] + arr[i]*arr[x+1]*arr[j+1];
						if(temp<min) min = temp;
						matrix[i][j] = min;
					}
				}
			}

		}
		return matrix[0][matrix.length-1];
	}

}
