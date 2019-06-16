package com.javadwarf.sorting.leetcode;

import java.util.Arrays;

public class _1051_HeightChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

}
