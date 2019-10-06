package com.javaDwarf.graphs.leetcode.dfs;

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
		
		if(matrix == null || matrix.length == 0) return 0;
		int max = 0;
		int[][] memo = new int[matrix.length][matrix[0].length];

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(memo[i][j] == 0) {
					memo[i][j]= dfs(new Pos(i,j), 1, matrix, new boolean[matrix.length][matrix[0].length],memo);
				}
				max = Math.max(max,memo[i][j]);
			}
		}
		return max;
	}

	public int dfs(Pos p, int currLen, int[][] matrix, boolean[][] visited, int[][] memo ) {

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i=0; i<xArr.length; i++) {
			int xNew = p.x + xArr[i];
			int yNew = p.y + yArr[i];
			
			if(xNew >=0 && xNew<matrix.length && yNew>=0 && yNew<matrix[0].length &&
					!visited[p.x][p.y] && matrix[xNew][yNew] > matrix[p.x][p.y]) {
				visited[p.x][p.y] = true;
				if(memo[xNew][yNew] == 0) {
					memo[xNew][yNew] = dfs(new Pos(xNew,yNew), 1, matrix, visited , memo);
				}
				int temp = currLen + memo[xNew][yNew];
				memo[p.x][p.y] = Math.max(memo[p.x][p.y], temp);
				visited[p.x][p.y] = false;
			}
		}
		return (memo[p.x][p.y]==0)?1:memo[p.x][p.y];
	}


	class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
