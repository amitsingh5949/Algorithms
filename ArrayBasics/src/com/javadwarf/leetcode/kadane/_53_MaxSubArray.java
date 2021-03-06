package com.javadwarf.leetcode.kadane;

import java.util.Scanner;

public class _53_MaxSubArray {

	public static void main(String[] args) {
		/*Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			System.out.println(maxSubSetSum(a));
		}
		s.close();*/

		System.out.println(maxSubSetSumWithIndexes(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(maxSubSetSumWithIndexes(new int[] {-2,-1}));
		System.out.println(maxSubSetSumWithIndexes(new int[] {1}));
		
		System.out.println(maxSubSetSumWithIndexes(new int[] {-2,1}));
		System.out.println(maxSubSetSumWithIndexes(new int[] {1,2}));
		System.out.println(maxSubSetSumWithIndexes(new int[] {1}));
		
	}


	// Think at each index what is the maximum sub array sum possible
	// to calculate sum at i , we will use the already calculated sum till i-1
	// max sub array at nth index would be
	// maximum of (a[i], max sum till i-1 +a[i] )
	private static int maxSubSetSum(int[] a) {
		int currSum = a[0];
		int lastMax = a[0];

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


	// Getting start and end index of the sub array as well 
	private static int maxSubSetSumWithIndexes(int[] a) {

		int lastMax = a[0];
		int currSum = a[0];
		int begin = 0;
		int start = 0;
		int end = 0;

		for(int i=1; i<a.length; i++) {
			currSum +=  a[i];
			if( currSum < a[i]  ) {
				currSum = a[i];
				begin = i;
			}
			if(currSum > lastMax) {
				lastMax = currSum;
				start = begin;
				end = i;
			}
		}

		int result  = 0;
		for(int i = start; i<=end;i++) {
			result += a[i];
		}
		return result;
	}
	
	

	// ******** Method 1- Wikipedia solution, same as above

	private static int maxSubSetSum1(int[] a) {
		int lastMax = a[0];
		int currSum = a[0];

		for(int i=1; i<a.length; i++) {
			currSum = Integer.max(a[i], a[i]+currSum);
			lastMax = Integer.max(lastMax, currSum);;
		}
		return lastMax;
	}

}
