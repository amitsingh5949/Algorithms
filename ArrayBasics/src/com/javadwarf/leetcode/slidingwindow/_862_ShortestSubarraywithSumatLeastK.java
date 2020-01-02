package com.javadwarf.leetcode.slidingwindow;

public class _862_ShortestSubarraywithSumatLeastK {

	public static void main(String[] args) {
		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {2,-1,2}, 3));//3

		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {1,2}, 4));//-1

		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {1}, 1));//1
		
		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {17,85,93,-45,-21}, 150));//2
		
		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {84,-37,32,40,95}, 167));//3
		
		System.out.println(new _862_ShortestSubarraywithSumatLeastK().
				shortestSubarray(new int[] {-28,81,-20,28,-29}, 89));//3
	}
	
	

	// below logic fails for last test case,look for same question subarray package for correct implementation
	public int shortestSubarray(int[] A, int K) {

		if(A ==null || A.length ==0) return -1;

		int res = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;

		while(end < A.length) {

			sum += A[end];

			while(start < A.length && sum >=K) {
				res = Math.min(res, end-start+1);
				sum -= A[start];
				start++;
			}
			end++;
		}
		
		while( start < A.length && (sum >=K || (A[start] < 0 && (sum - A[start] >= K) ))){
			res = Math.min(res, end-start);
			sum -= A[start];
			start++;
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

}
