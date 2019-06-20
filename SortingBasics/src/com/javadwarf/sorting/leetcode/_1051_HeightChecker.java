package com.javadwarf.sorting.leetcode;

import java.util.Arrays;

public class _1051_HeightChecker {

	public static void main(String[] args) {

	}

// O(nlogn) time and O(n) space
	public int heightChecker(int[] heights) {
		int result = 0;
		int[] arr = heights.clone();
		Arrays.sort(arr);
		
		for(int i=0; i< heights.length; i++) {
			if(heights[i] != arr[i]) {
				result++;
			}
		}
		return result;
	}
	
	// // O(n) time and O(n) space - using bucket sort

}
