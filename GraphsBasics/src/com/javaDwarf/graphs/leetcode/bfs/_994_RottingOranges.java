package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _994_RottingOranges {

	public static void main(String[] args) {
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		System.out.println(new _994_RottingOranges().orangesRotting(grid));
		

	}
	
	public int orangesRotting(int[][] grid) {
		
		int count = 0;
		
		Queue<Cell> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 2) {
					q.add(new Cell(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		q.add(null);
		
		while(q.size() > 1) {

			Cell cell = q.poll();
			
			if(cell == null) {
				q.add(null);
				count++;
				continue;
			}
			
			int x = cell.x;
			int y = cell.y;
			
			int[] xArr = {0,-1,1,0};
			int[] yArr = {-1,0,0,1};

			for(int i=0; i<xArr.length; i++) {

				int xNew = x + xArr[i];
				int yNew = y + yArr[i];

				if(xNew >= 0 && xNew < grid.length && yNew >=0 && yNew < grid[0].length  &&
						 grid[xNew][yNew] == 1 && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					q.add(new Cell(xNew, yNew));
				}
			}
		}
		
		for(int i=0; i<visited.length; i++) {
			for(int j=0; j<visited[0].length; j++) {
				if(grid[i][j] != 0 && !visited[i][j]) {
					return -1;
				}
			}
		}
		return count;
	}
	
}

class Cell{
	
	public int x ;
	public int y;
	
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
