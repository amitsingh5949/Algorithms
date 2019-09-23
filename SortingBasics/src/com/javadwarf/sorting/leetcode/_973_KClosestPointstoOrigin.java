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
	
	//Divide and Conqure Approach is o(n) + o(n)

}
