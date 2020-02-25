package com.javaDwarf.graphs.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

public class _694_NumberofDistinctIslands {

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
		System.out.println(new _694_NumberofDistinctIslands().numDistinctIslands(grid));

	}

	private static final int[] xArr = {0,-1,1,0};
	private static final int[] yArr = {-1,0,0,1};
	
	public int numDistinctIslands(int[][] grid) {

		Set<String> set = new HashSet<>();

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for(int i=0; i<grid.length; i++) {
			
			for(int j=0; j<grid[i].length; j++) {

				if(grid[i][j] == 1 && !visited[i][j]) {
					
					StringBuffer sb = new StringBuffer();
					sb.append("C");
					visited[i][j] = true;
					dfs(i,j,grid,visited,sb);
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

	public void dfs(int x, int y, int[][] grid, boolean[][] visited, StringBuffer sb) {
		
		
		for(int i =0; i<xArr.length; i++) {
			
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];
			
			if(xNew >= 0 && xNew < grid.length && yNew>=0 && yNew < grid[0].length && grid[xNew][yNew] == 1 && !visited[xNew][yNew]) {
				visited[xNew][yNew] = true;
				if(i == 0) {
					sb.append("L");
				}
				else if(i == 1) {
					sb.append("T");
				}
				else if(i == 2) {
					sb.append("B");
				}
				else if(i == 3) {
					sb.append("R");
				}
				dfs(xNew,yNew,grid,visited,sb);
				sb.append("E");// Important step to append End 
				// run test case {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}}; without E and you will understand
			}
		}
	}
}
