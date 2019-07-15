package com.javadwarf.dynamicprogramming.gfg.lis;

import java.util.Scanner;

public class MaxIncreasingSumSubSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTest  = in.nextInt();

		for(int i=0; i<numOfTest; i++){
			int size = in.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++){
				arr[j] = in.nextInt();
			}
			System.out.println(maxIncreasingSumSubSequence(arr));
		}
		in.close();
	}

	public static int maxIncreasingSumSubSequence(int[] arr ){
		int[] temp  =new int[arr.length];
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[j]<arr[i] && temp[j]>=temp[i]){
					temp[i] = temp[j] ;
				}
			}
			temp[i] += arr[i]; 
		}
		int max = Integer.MIN_VALUE;
		for(int k=0; k<temp.length; k++){
			if(max<temp[k]) max = temp[k];
		}
		return max;
	}
}
