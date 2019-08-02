package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Scanner;
// copied from knapsack problem in gfg folder
public class _0Or1_KnapSackProblem {

	static int val[] ;
	static int wt[] ;
	static int  W ;
	static int[][] matrix  ;
	static int numOfItems  ;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			numOfItems = in.nextInt();
			W = in.nextInt();
			val = new int[numOfItems];
			for(int j=0; j<numOfItems; j++){
				val[j] =  in.nextInt();
			}
			wt = new int[numOfItems];
			for(int k=0; k<numOfItems; k++){
				wt[k] =  in.nextInt();
			}  
			System.out.println(knapsackVal());
		}
		in.close();
	}

	
	public static int knapsackVal(){

		matrix = new int[numOfItems+1][W+1];
		int max  = 0 ;

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){

				if(i== 0 || j==0){
					matrix[i][j] = 0;
				}
				else {
					if(wt[i-1]>j){
						matrix[i][j] = matrix[i-1][j];
					}
					else{
						matrix[i][j] = Math.max( matrix[i-1][j], val[i-1]+matrix[i-1][j-wt[i-1]]);
						if(matrix[i][j] > max)
							max = matrix[i][j];
					}
				}
			}
		}
		return max;
	}
}