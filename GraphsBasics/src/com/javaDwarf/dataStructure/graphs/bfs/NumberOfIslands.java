package com.javaDwarf.dataStructure.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int numOfTest = s.nextInt();
		int[][] matrix = null;

		for(int i=0; i<numOfTest; i++) {

			int row = s.nextInt();
			int col = s.nextInt();
			matrix = new int[row][col];
			for(int x = 0; x< row; x++) {
				for(int y = 0; y< col; y++) {
					matrix[x][y] = s.nextInt();
				}
			}
			System.out.println(findIslands(matrix, row, col));
		}
		s.close();
	}

	private static int findIslands(int[][] matrix, int row, int col) {

		int maxLen = 0; 

		boolean[][] visited = new boolean[row][col];

		for(int x = 0; x< row; x++) {
			for(int y = 0; y< col; y++) {
				if(bfs(matrix, visited,x, y)) {
					maxLen++;
				}
			}
		}
		return maxLen;
	}

	private static boolean bfs(int[][] matrix, boolean[][] visited, int x, int y) {
		class Pos5{
			int x, y;

			public Pos5(int x, int y) {
				super();
				this.x = x;
				this.y = y;
			}
		}

		boolean  result = false; 
		int[] xArr = {-1,0,1,-1,1,-1,0,1};
		int[] yArr = {-1,-1,-1,0,0,1,1,1};

		Queue<Pos5> q = new LinkedList<>();

		if(matrix[x][y] != 0 && !visited[x][y]) {
			result = true;
			visited[x][y] = true;
			q.add(new Pos5(x, y));
		}

		while(!q.isEmpty()) {
			Pos5 p = q.poll();

			for(int x1 = 0; x1< xArr.length; x1++) {
					if(  p.x + xArr[x1]>=0    &&    p.x + xArr[x1]<matrix.length    &&
							p.y + yArr[x1]>=0    && 	p.y + yArr[x1]<matrix[p.x + xArr[x1]].length &&
							matrix[p.x + xArr[x1]][p.y+yArr[x1]] != 0 && !visited[p.x + xArr[x1]][p.y+yArr[x1]] ) {
						visited[p.x + xArr[x1]][p.y+yArr[x1]]  = true;
						q.add(new Pos5(p.x + xArr[x1], p.y+yArr[x1]));
					}
			}
		}
		return result;
	}
}


