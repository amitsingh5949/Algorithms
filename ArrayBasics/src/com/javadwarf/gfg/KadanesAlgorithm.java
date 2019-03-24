package com.javadwarf.gfg;

import java.util.Scanner;

public class KadanesAlgorithm {

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
		int lastMax = a[0];
		int currSum = a[0];

		for(int i=1; i<a.length; i++) {
			currSum += a[i];
			if(currSum < a[i]) {
				currSum = a[i];
			}
			if(currSum > lastMax) {
				lastMax = currSum;
			}
		}
		return lastMax;
	}
	
	// it works too
	private static int maxSubSetSum1(int[] a) {
		int lastMax = a[0];
		int currSum = a[0];

		for(int i=1; i<a.length; i++) {
			
			if(currSum < 0 && currSum < a[i]) {
				currSum = a[i];
			}
			currSum += a[i];
			if(currSum > lastMax) {
				lastMax = currSum;
			}
		}
		return lastMax;
	}
}
