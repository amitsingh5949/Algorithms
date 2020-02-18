package com.javadwarf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _888_FairCandySwap {

	public int[] fairCandySwap(int[] A, int[] B) {

		int[] arr = new int[2];

		int sumA = 0;
		int sumB = 0;

		Set<Integer> s = new HashSet<>();
		for(int i = 0; i<A.length; i++) {
			sumA += A[i];
		}

		for(int i = 0; i<B.length; i++) {
			sumB += B[i];
			s.add(B[i]);
		}

		int avgDiff = (Math.abs(sumA - sumB))/2;

		for(int i = 0; i<A.length; i++) {
			if(sumA > sumB) {
				if(s.contains(A[i]-avgDiff)) {
					arr[0] = A[i];
					arr[1] = A[i]-avgDiff;
					break;
				}
			}else {
				if(s.contains(A[i]+avgDiff)) {
					arr[0] = A[i];
					arr[1] = A[i]+avgDiff;
					break;
				}
			}
		}
		return arr;
	}

	
	//Minor improvement to lessen lines of code
	public int[] fairCandySwap1(int[] A, int[] B) {

		int[] arr = new int[2];

		int sumA = 0;
		int sumB = 0;

		
		for(int i = 0; i<A.length; i++) {
			sumA += A[i];
		}
		
		Set<Integer> s = new HashSet<>();
		for(int i = 0; i<B.length; i++) {
			sumB += B[i];
			s.add(B[i]);
		}

		int avgDiff = (sumA - sumB)/2;

		for(int i = 0; i<A.length; i++) {
			if(s.contains(A[i]-avgDiff)) {
				arr[0] = A[i];
				arr[1] = A[i]-avgDiff;
				break;
			}
		}
		return arr;
	}
}
