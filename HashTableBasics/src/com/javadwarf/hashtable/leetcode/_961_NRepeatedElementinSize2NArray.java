package com.javadwarf.hashtable.leetcode;

public class _961_NRepeatedElementinSize2NArray {

	public static void main(String[] args) {
		int[] arr1 = {2,1,2,5,3,2};
		int[] arr2 = {5,1,5,2,5,3,5,4};

		int[] arr3 = {1,2,3,3};
		int[] arr4 = {9,5,3,3};

		int[] arr5 = {9,5,3,9};
		System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes(arr1));
		System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes(arr2));
		System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes(arr3));
		System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes(arr4));
		System.out.println(new _961_NRepeatedElementinSize2NArray().repeatedNTimes(arr5));

	}


	// WE NEED TO COMPARE THE CURREBT ELEMENT TO ITS NEIGHBOR 1,2,3 AS ALL OTHER ELEMENTS ARE UNIQUE

	/*
	 * Consider all subarrays of length 4. There must be a major element in at least one such subarray.

			This is because either:
			
			1. There is a major element in a length 2 subarray, or;
			2. Every length 2 subarray has exactly 1 major element, which means that a length 4 subarray that begins at
			 a major element will have 2 major elements.
			 
	Thus, we only have to compare elements with their neighbors that are distance 1, 2, or 3 away.
	 */
	public int repeatedNTimes(int[] A) {
		for(int i=0; i<A.length; i++) {

			if(i <A.length-1 && A[i]==A[i+1]) {
				return A[i];
			}
			else if(i < A.length-2 && (A[i]==A[i+1]||A[i]==A[i+2])) {
				return A[i];
			}
			else if(i < A.length-3 && (A[i]==A[i+1]||A[i]==A[i+2]||A[i]==A[i+3])) {
				return A[i];
			}
		}
		return -1;
	}

}
