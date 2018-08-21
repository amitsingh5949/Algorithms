package com.javadwarf.dynamicprogramming.twoString;

import java.util.Scanner;

public class KnapsackProblem {

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
						matrix[i][j] = Math.max(val[i-1]+matrix[i-1][j-wt[i-1]], matrix[i-1][j]);
						if(matrix[i][j] > max)
							max = matrix[i][j];
					}
				}
			}
		}
		return max;
	}


	/*Struggle with wrong solution :)
	 * public static int knapsack(){
		int[] knapSackArr = new int[numOfItems+1];
		for(int i=0; i<knapSackArr.length-1; i++){
			knapSackArr[i]=wt[i];
		}
		knapSackArr[numOfItems] = W;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				matrix[i][j] = getValue(i, j,knapSackArr);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix[numOfItems-2][numOfItems-1];
	}

	public static int getValue(int i, int j,int[] knapSackArr){
		int value = 0;
		int currentWeight = wt[i];
		int currentKnapsackWeight = knapSackArr[j];

		int totalCurrentWeight = 0;
		for(int k =0; k<wt.length;k++){
			if(currentWeight >= wt[k])
				totalCurrentWeight += wt[k];
			else
				break;
		}

		if(currentKnapsackWeight <= totalCurrentWeight){
			if(currentWeight == currentKnapsackWeight){
				if((i-1)<=0){
					value = val[i];
				}
				else{
					value = Math.max(val[i], matrix[i-1][j]);
				}
			}
			if(currentWeight < currentKnapsackWeight){
				if((i-1)>=0){
					value =  matrix[i-1][j];
				}
				if((i-1)>=0 && (j-i-1)>=0){
					value =  Math.max(Math.max(val[i], matrix[i-1][j]),
							(val[i]+matrix[i-1][j-i-1]));
				}
			}
			if(currentWeight > currentKnapsackWeight){
				if((i-1)>=0){
					value =  matrix[i-1][j];
				}
			}
		}
		else{
			return 0;
		}
		return value;
	}*/

}
