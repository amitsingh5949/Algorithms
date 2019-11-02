package com.javadwarf.leetcode;

public class _896_MonotonicArray {

	public static void main(String[] args) {

	}

	
	
public boolean isMonotonic(int[] A) {
		
		boolean isIncreasing = true;
		boolean isDecreasing = true;
		
		for(int i=1; i<A.length; i++) {

			if(A[i] < A[i-1]) {
				isIncreasing = false;
			}
			
			if(A[i] > A[i-1]) {
				isDecreasing = false;
			}
		}
		return isDecreasing ||isIncreasing;
	}

	public boolean isMonotonic1(int[] A) {
		
		boolean isDecreasing = true;
		boolean isIncreasing = true;
		
		int maxSoFar = A[0];
		int minSoFar = A[0];
		
		for(int i=1; i<A.length; i++) {

			if(A[i] >= minSoFar) {
				minSoFar = A[i];
			}
			else {
				isIncreasing = false;
			}
			
			if(A[i] <= maxSoFar) {
				maxSoFar = A[i];
			}
			else {
				isDecreasing = false;
			}
		}
		return isDecreasing ||isIncreasing;
	}

}
