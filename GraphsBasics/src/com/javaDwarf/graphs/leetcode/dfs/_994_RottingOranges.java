package com.javaDwarf.graphs.leetcode.dfs;

public class _994_RottingOranges {

	public static void main(String[] args) {
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		System.out.println(new _994_RottingOranges().orangesRotting(grid));
		

	}
	
	public int orangesRotting(int[][] grid) {
		int count = 0;
		return count;
	}
	
	//Time Limit Exceeded 

	public int orangesRotting1(int[][] grid) {

		if(grid == null || grid.length == 0) return 0;

		int[][] rottenBoard = null;

		int freshOranges = 0;

		int count = 0;

		while(true) {

			rottenBoard = new int[grid.length][grid[0].length];
			freshOranges = 0;
			
			for(int i=0;i<grid.length; i++) {
				for(int j=0; j<grid[0].length; j++) {
					rottenBoard[i][j] = grid[i][j];
					if(grid[i][j] == 1) {
						freshOranges += 1;
					}
				}
			}
			
			if(freshOranges==0) {
				break;
			}
			else {
				count++;
			}

			for(int i=0;i<grid.length; i++) {
				for(int j=0; j<grid[0].length; j++) {
					if(grid[i][j] == 2) {
						rotNeighbours(grid, rottenBoard, i, j);
					}
				}
			}
			
			grid = rottenBoard;
		}
		return count;
	}
	
	public void rotNeighbours(int[][] board, int[][] rottenBoard, int x, int y) {

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};
		
		for(int i =0; i<xArr.length; i++) {
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < board.length && yNew >= 0 && yNew < board[0].length
					&& board[xNew][yNew] == 1) {
				rottenBoard[xNew][yNew] = 2;
			}
		}
	}

}
