package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _286_WallsandGates {

	class  Pos{
		int x,y;
		public Pos(int x,  int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void wallsAndGates(int[][] rooms) {

		boolean[][] visited = new boolean [rooms.length][rooms[0].length];

		for(int i =0;i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length;j++) {
				if(rooms[i][j] == Integer.MAX_VALUE) {
					int temp = wallsAndGates(new Pos(i,j),rooms,visited,0);
					rooms[i][j] = (temp == 0) ? Integer.MAX_VALUE : temp;
				}
			}
		}
	}

	public int wallsAndGates(Pos p, int[][] rooms, boolean[][] visited, int count) {

		visited[p.x][p.y] = true;

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Queue<Pos> q = new LinkedList<>();

		for(int i=0; i<xArr.length; i++) {
			int xNew = p.x + xArr[i];
			int yNew = p.y + yArr[i];

			if( rooms[xNew][yNew] ==  Integer.MAX_VALUE && xNew >= 0 && xNew < rooms.length 
					&& yNew>=0 && yNew<rooms[0].length
					&& !visited[xNew][yNew]) {

			}
		}
		
		return count;



	}

}
