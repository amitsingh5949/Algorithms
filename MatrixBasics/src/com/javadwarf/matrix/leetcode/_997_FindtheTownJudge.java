package com.javadwarf.matrix.leetcode;

public class _997_FindtheTownJudge {

	public static void main(String[] args) {

	}

	public int findJudge(int N, int[][] trust) {

		int[][] matrix = new int[N][N];

		for(int i=0; i<trust.length; i++) {
			int x = trust[i][0]-1;
			int y= trust[i][1]-1;
			matrix[x][y]= 1;
		}

		// now use the find the celebrity logic

		int candidate = 0 ;

		for(int i=1; i<matrix.length; i++) {
			if(matrix[candidate][i] == 1) {
				candidate = i; 
			}
		}

		for(int i=0; i<matrix.length; i++) {
			if(i!=candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] ==0)) {
				return -1;
			}
		}

		return candidate +1;
	}

	/*
	 * Leetcode solution and logic
	 * 
	 * Intuition:
		Consider trust as a graph, all pairs are directed edge.
		The point with in-degree - out-degree = N - 1 becomes the judge.

		Explanation:
		Count the degree, and check at the end.

		Time Complexity:
		Time O(T + N), space O(N)*/



	public int findJudge1(int N, int[][] trust) {
		int[] count = new int[N+1];
		for (int[] t: trust) {
			count[t[0]]--;
			count[t[1]]++;
		}
		for (int i = 1; i <= N; ++i) {
			if (count[i] == N - 1) return i;
		}
		return -1;
	}

}
