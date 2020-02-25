package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1102_PathWithMaximumMinimumValue {

	public static void main(String[] args) {
		int[][] A = {{5,4,5},{1,2,6},{7,4,6}};
		
		System.out.println(new _1102_PathWithMaximumMinimumValue().maximumMinimumPath(A));

	}

	private static final int[] xArr = {0,-1,1,0};
	private static final int[] yArr = {-1,0,0,1};

	private static int min = Integer.MAX_VALUE;
	private static int sum = Integer.MIN_VALUE;
	
	// DFS not working, see the same question  in bfs package

	public int maximumMinimumPath(int[][] A) {
		min = A[0][0];
		sum = Integer.MIN_VALUE;
		boolean[][] visited = new boolean[A.length][A[0].length];
		visited[0][0] = true;
		List<Integer> path = new ArrayList<>();
		path.add(A[0][0]);
		dfs(0, 0, A, visited,A[0][0], A[0][0], path);
		return min;
	}

	public void dfs(int x, int y, int[][] A, boolean[][] visited, int sumSoFar, int minSoFar, List<Integer> path) {

		if(x == A.length-1 && y == A[0].length-1) {
			if(sumSoFar > sum) {
				sum = sumSoFar;
				min = Math.min(min, minSoFar);
			}
			return;
		}

		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<xArr.length; i++) {

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >=0 && xNew<A.length && yNew>=0 && yNew<A[0].length && !visited[xNew][yNew]) {
				if(pq.isEmpty()) {
					pq.add(i);
				}
				else {
					
					int xMax = x + xArr[pq.peek()];
					int yMax = x + xArr[pq.peek()];
					
					if(A[xNew][yNew] == A[xMax][yMax]) {
						pq.add(i);
					}
					else if(A[xNew][yNew] > A[xMax][yMax]) {
						pq.clear();
						pq.add(i);
					}
				}
			}
		}

		while(!pq.isEmpty()) {

			int i = pq.poll();

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			visited[xNew][yNew] = true;
			path.add(A[xNew][yNew]);
			dfs(xNew, yNew, A, visited, sumSoFar + A[xNew][yNew],  Math.min(minSoFar, A[xNew][yNew]),path);
			path.remove(path.size()-1);
			visited[xNew][yNew] = false;
		}
	}
}
