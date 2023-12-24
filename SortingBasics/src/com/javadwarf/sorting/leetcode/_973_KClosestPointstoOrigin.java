package com.javadwarf.sorting.leetcode;

import java.util.Arrays;

public class _973_KClosestPointstoOrigin {

	public static void main(String[] args) {

	}

	// Sorting solution : o(nlogn) + o(n)
	public int[][] kClosest(int[][] points, int K) {
		Arrays.parallelSort(points, (a,b) -> Double.compare(Math.sqrt(Math.pow(a[0], 2.0) + Math.pow(a[1],2.0)),
				Math.sqrt(Math.pow(b[0], 2.0) + Math.pow(b[1],2.0))));
		int[][] results = new int[K][2];
		for(int i=0; i<K; i++) {
			results[i] = points[i];
		}
		return results;
	}
	
	//Divide and Conquer Approach is o(n) + o(n) -- using quick select, 
		//divide the array at a pivot point such that all coordinates
		// left to pivot are closer to origin and all on right are farther from origin
		// we need to find pivot at index k and return all elements left to it since order is not important, we don't need to sort these elements.

}
