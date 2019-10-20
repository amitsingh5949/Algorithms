package com.javadwarf.leetcode.twopointer;

import java.util.Arrays;

public class _1099_TwoSumLessThanK {

	public static void main(String[] args) {

	}
	
    //O(n^2)
	public int twoSumLessThanK1(int[] A, int K) {
		int max = -1;
		for(int i =0 ;i<A.length-1; i++) {
			for(int j=i+1;j<A.length-1;j++) {
				int temp = A[i]+A[j];
				if(temp<K)
					max = Math.max(temp, max);
			}
		}
		return max;   
	}
	
	// Condition i<j is ignored still works with two pointer approach
	public int twoSumLessThanK(int[] A, int K) {
		
		int max = -1;
		Arrays.sort(A);
		int begin = 0;
		int end = A.length-1;
		
		while(begin<end){
			int temp = A[begin] + A[end];
			if(temp<K) {
				max = Math.max(max, temp);
				begin++;
			}
			else {
				end--;
			}
		}
		return max;   
	}

}
