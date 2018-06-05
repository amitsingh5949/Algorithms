package com.javadwarf.dynamicprogramming.singleString;

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
					for(int x=i; x<j; x++){
						int temp = 0;
						if(matrix[i][x]==0 && matrix[x+1][j]==0){
							temp = arr[i]*arr[j]*arr[j+1];	
						}
						else if(matrix[i][x]==0 && matrix[x+1][j]!=0){
							temp = arr[i]*arr[x+1]*arr[j+1] + matrix[x+1][j];
						}
						else if(matrix[i][x]!=0 && matrix[x+1][j]==0){
							temp = matrix[i][x] + arr[i]*arr[x+1]*arr[j+1];
						}
						else{
							temp= matrix[i][x] + matrix[x+1][j] + arr[i]*arr[x+1]*arr[j+1];
						}
						if(temp<min) min = temp;
						matrix[i][j] = min;
					}
				}
			}

		}
		return matrix[0][matrix.length-1];
	}

}
