package com.javadwarf.dynamicprogramming.twoString;

import java.util.Scanner;

public class SubsetSum {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int coin[] = new int[size];
			for(int j=0; j<size; j++){
				coin[j] =  in.nextInt();
			}
			int W = in.nextInt();
			System.out.println(subSetSum(W, coin));
		}
		in.close();
		//System.out.println(subSetSum(9, new int[]{3, 34, 4, 12, 5, 2}));
	}

	public static boolean subSetSum(int W, int[] set){

		boolean[][] matrix = new boolean[set.length+1][W+1]; 

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(i== 0 || j==0){
					matrix[i][j] = false;
				}
				else {
					if(set[i-1]>j){
						matrix[i][j] = matrix[i-1][j];
					}
					else if(set[i-1] == j){
						matrix[i][j] = true;
					}
					else{
						matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-set[i-1]];
					}
					if(j==set.length-1 && matrix[i][j] ){
						return true;
					}
				}
			}
		}
		return false;
	}

}
