package com.javadwarf.gfg;

import java.util.Scanner;

public class KadanesAlgorithmSubArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			System.out.println(maxSubSetSum(a));
		}
		s.close();
	}

	// Think at each index what is the maximum sub array sum possible
	// to calculate sum at i , we will use the already calculated sum till i-1
	// max sub array at nth index would be
	//  maximum of (a[i], max sum till i-1 +a[i] )

	private static int maxSubSetSum(int[] a) {
		int lastSum = 0;
		int currSum = 0;
		int start = 0;
		int end = 0 ;
		int begin = 0 ;

		int maxElementIndex = 0;

		for(int i=0; i<a.length; i++) {

			// for all -ve element array
			if(a[maxElementIndex] < a[i]) {
				maxElementIndex = i;
			}

			currSum += a[i];

			if(currSum < a[i]) {
				currSum = a[i];
				begin = i;
			}
			
			if(currSum > lastSum) {
				lastSum = currSum;
				start = begin;
				end = i;
			}
		}

		if(a[maxElementIndex]<0) { // if all elements in array are -ve then just return max element
			return a[maxElementIndex];
		}

		int sum = 0;
		for(int i =start; i<=end; i++) {
			sum += a[i];
		}
		return sum;
	}
}
