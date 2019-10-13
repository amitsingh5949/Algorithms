package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberofIslands {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'}, 
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};


		System.out.println(numIslands(grid));
	}


	//****** Method 1 - bfs approach **********************************

	public static int numIslands(char[][] grid) {

		if(grid.length == 0) return 0;

		int result = 0;

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {

				if(grid[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j, grid, visited);
					result++;
				}
			}
		}
		return result;

	}

	public static void bfs(int x, int y, char[][] grid, boolean[][] visited ) {

		class Pos{
			public int a, b  = 0;
			public Pos(int a, int b){
				this.a = a;
				this.b = b;
			}
		}

		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(x,y));

		while(!q.isEmpty()){
			Pos p = q.poll();
			int[] xArr = { 0, -1, 1, 0};
			int[] yArr = { -1, 0, 0, 1};

			for(int i=0; i<xArr.length; i++){

				int xNew = p.a + xArr[i];
				int yNew = p.b + yArr[i];

				if(xNew >= 0 && xNew < grid.length
						&& yNew >= 0 && yNew < grid[xNew].length
						&& grid[xNew][yNew] == '1' && !visited[xNew][yNew]){
					visited[xNew][yNew] = true;
					q.add(new Pos(xNew, yNew));
				}
			}
		}
	}

}
