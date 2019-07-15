package com.javadwarf.dynamicprogramming.gfg.lis;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int coin[] = new int[size];
			for(int j=0; j<size; j++){
				coin[j] =  in.nextInt();
			}
			System.out.println(longestIncreasingSubsequence(coin));
		}
		in.close();

	}

	public static int longestIncreasingSubsequence(int[] arr){
		int[] temp = new int[arr.length];
		if(arr.length==0) return 0;
		
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && temp[j] >= temp[i]){
						temp[i] = temp[j];
				}
			}
			temp[i] += 1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<temp.length; i++){
			if(temp[i]>max) max = temp[i];
		}
		return max;
	}
}
