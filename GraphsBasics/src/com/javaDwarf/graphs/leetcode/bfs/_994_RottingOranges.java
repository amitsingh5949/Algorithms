package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _994_RottingOranges {

	public static void main(String[] args) {
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		System.out.println(new _994_RottingOranges().orangesRotting(grid));
		

	}
	
	public int orangesRotting1(int[][] grid) {
	       
	       int count = 0;
	       int[][] dir = {{0,-1},{-1,0},{1,0},{0,1}};
	       
	       Queue<int[]> q = new LinkedList<>();
	       
	       for(int i=0; i<grid.length; i++){
	           for(int j =0; j<grid[i].length; j++){
	               if(grid[i][j] == 2){
	                   q.add(new int[]{i,j});
	               }
	           }
	       }
	       
	       
	       while(!q.isEmpty()){
	           int size = q.size();
	           
	           for(int a= 0; a<size; a++){
	               int[] cell = q.poll();
	               
	               for(int i=0;i<dir.length; i++){
	                   int xNew = cell[0] + dir[i][0];
	                   int yNew = cell[1] + dir[i][1];
	                   
	                   if(xNew>=0 && xNew<grid.length && yNew >=0 && yNew<grid[0].length 
	                       && grid[xNew][yNew] == 1){
	                       grid[xNew][yNew] = 2;
	                       q.add(new int[]{xNew,yNew});
	                   }
	               }
	               
	           }
	           count++;
	       }
	       
	       for(int i=0; i<grid.length; i++){
	           for(int j =0; j<grid[i].length; j++){
	               if(grid[i][j] == 1){
	                   return -1;
	               }
	           }
	       }
	       
	       return count == 0 ? 0 : count-1; // count-1 is because for last level we do not need to increment count
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
