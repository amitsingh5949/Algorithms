package com.javaDwarf.graphs.leetcode.dfs;

public class _695_MaxAreaofIsland {

	public static void main(String[] args) {
		
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(new _695_MaxAreaofIsland().maxAreaOfIsland(grid));

	}

	// below approach works but if we try global pointer then it won't work. helper function must calculate area and return
	public int maxAreaOfIsland(int[][] grid) {
		
		int max = 0;
		
		if(grid==null|| grid.length==0) return max;
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for(int i=0; i<grid.length; i++) {
			for(int j =0; j<grid[0].length; j++) {
				if(!visited[i][j] && grid[i][j] == 1) {
					int temp = dfs(grid, visited, 0,i,j);
					max = Math.max(temp, max);
				}
			}
		}
		return max;
	}
	
	public int dfs(int[][] grid, boolean[][] visited, int sum, int x, int y) {
		
		sum += 1;
		visited[x][y] = true;
		
		int[] xArr = { 0, -1, 1, 0};
		int[] yArr = { -1, 0, 0, 1};

		for(int i=0; i<xArr.length; i++){
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];
			if(xNew >= 0 && xNew < grid.length
					&& yNew >= 0 && yNew < grid[xNew].length
					&& grid[xNew][yNew] == 1 && !visited[xNew][yNew]){
				sum = dfs(grid, visited,sum,xNew,yNew);
				
			}
		}
		return sum;
	}

}
