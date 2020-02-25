package com.javadwarf.greedy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _986_IntervalListIntersections {

	public static void main(String[] args) {

	}

	public int[][] intervalIntersection(int[][] A, int[][] B){
		
		List<int[]> res = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while(i<A.length && j<B.length) {
			
			int low = Math.max(A[i][0], B[j][0]);
			int high = Math.min(A[i][1], B[j][1]);
			
			if(low<=high) {
				res.add(new int[] {low, high});
			}
			
			if(A[i][1] < B[j][1]) {
				i++;
			}
			else {
				j++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}

}
