package com.javadwarf.dynamicprogramming.lis;

import java.util.Scanner;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int coin[] = new int[size];
			for(int j=0; j<size; j++){
				coin[j] =  in.nextInt();
			}
			System.out.println(longestBitonicSubsequence(coin) ); 
		}
		in.close();

	}
	
	public static int longestBitonicSubsequence(int[] arr){
		
		int max = Integer.MIN_VALUE;
		
		int[] lisLeft = longestIncreasingSubsequence(arr);
		int[] lisRight = reverse(longestIncreasingSubsequence(reverse(arr)));
		
		for(int j=0; j<arr.length; j++) {
			int x  = lisLeft[j] +lisRight[j] -1;
			if(x>max) max = x;
		}
		return max;
	}

	public static int[] longestIncreasingSubsequence(int[] arr){
		int[] temp = new int[arr.length];
		if(arr.length==0) return new int[]{0};
		
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && temp[j] >= temp[i]){
						temp[i] = temp[j];
				}
			}
			temp[i] += 1;
		}
		return temp;
	}
	
	public static int[] reverse(int[] arr){
		int[] temp = new int[arr.length];
		for(int i=arr.length-1,j=0; i>=0; i--,j++) 
			temp[j] =arr[i];
		return temp;
	}
}
