package com.javadwarf.leetcode.subarray;

import java.util.Deque;
import java.util.LinkedList;

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

	public int shortestSubarray(int[] A, int K) {

		if(A == null || A.length == 0) return -1;

		int res = Integer.MAX_VALUE;

		int[] P = new int[A.length+1];
		P[0] = 0;
		for(int i=0; i<A.length;i++) {
			P[i+1] = P[i] + A[i];
		}

		Deque<Integer> dq = new LinkedList<Integer>();

		// in this loop p[a] will work as p[x]  and p[y] both
		for(int a=0; a< P.length; a++) {

			// p[a] is similar to p[x] 
			// we want p[x] as small as possible  and x as large as possible
			// move x toward right
			// remove all elements from left which are smaller than p[a]
			while(!dq.isEmpty() && P[a] <= P[dq.getLast()]) {
				dq.pollLast();
			}

			// p[a] is similar to p[y] 
			// we want p[y] as large as possible  and y as small as possible
			// move y toward left
			// remove all elements from right for which P[a] - P[dq.getFirst()] >= K

			while(!dq.isEmpty() && P[a] - P[dq.getFirst()] >= K) {
				res = Math.min(res, a-dq.pollFirst());
			}

			dq.add(a);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}



}
