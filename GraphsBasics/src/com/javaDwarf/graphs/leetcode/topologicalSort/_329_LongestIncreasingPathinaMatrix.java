package com.javaDwarf.graphs.leetcode.topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class _329_LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {
		int[][] nums = {
				{3,4,5},
				{3,2,6},
				{2,2,1}
		};

		int [][] nums1 = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};

		System.out.println(new _329_LongestIncreasingPathinaMatrix().longestIncreasingPath(nums1));

	}

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		//calculate the degree of each cell
		int[][] degree = new int[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				for(int k=0; k<xArr.length; k++) {
					int xNew = i + xArr[k];
					int yNew = j + yArr[k];
					if(xNew >=0 && xNew<matrix.length && yNew>=0 && yNew<matrix[0].length &&
							matrix[xNew][yNew] > matrix[i][j]) {
						degree[xNew][yNew] += 1;
					}
				}
			}
		}

		//Add 0 degree nodes to Queue
		Queue<Pos> q = new LinkedList<>();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(degree[i][j] == 0) {
					q.add(new Pos(i,j));
				}
			}
		}

		//Apply level order traversal BFS + topological sort using (appending null technique to keep count of level)
		q.add(null);
		int max = 0;
		while(q.size() > 1) {
			Pos p = q.poll();
			if(p == null) {
				max++;
				q.add(null);
				continue;
			}
			for(int k=0; k<xArr.length; k++) {
				int xNew = p.x + xArr[k];
				int yNew = p.y + yArr[k];
				if(xNew >=0 && xNew<matrix.length && yNew>=0 && yNew<matrix[0].length &&
						matrix[xNew][yNew] > matrix[p.x][p.y]) {
					degree[xNew][yNew] -= 1;
					if(degree[xNew][yNew]==0) {
						q.add(new Pos(xNew, yNew));
					}
				}
			}
		}
		return ++max;
	}

	class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
