package com.javaDwarf.graphs.leetcode.bfs;

import java.util.PriorityQueue;
import java.util.Queue;

public class _1102_PathWithMaximumMinimumValue {

	public static void main(String[] args) {
		int[][] A = {{5,4,5},{1,2,6},{7,4,6}};
		System.out.println(new _1102_PathWithMaximumMinimumValue().maximumMinimumPath(A));
	}

	private static final int[] xArr = {0,-1,1,0};
	private static final int[] yArr = {-1,0,0,1};

	private static int min = -1;

	public int maximumMinimumPath(int[][] A) {
		
		boolean[][] visited = new boolean[A.length][A[0].length];
		
		Queue<int[]> q = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0],a[0]));
		q.add(new int[] {A[0][0],0,0});
		min = A[0][0];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			
			int[] a = q.poll();
			
			min = Math.min(min, a[0]);
			
			if(a[1] == A.length-1 && a[2] == A[0].length-1) {
				return min;
			}
			
			for(int i=0; i<xArr.length; i++) {

				int xNew = a[1] + xArr[i];
				int yNew = a[2] + yArr[i];

				if(xNew >=0 && xNew<A.length && yNew>=0 && yNew<A[0].length 
						&& !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					q.add(new int[] {A[xNew][yNew], xNew, yNew});
				}
			}
			
		}
		return min;
	}
}
