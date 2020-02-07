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

	public static void main(String[] args) {



	}

	public void wallsAndGates(int[][] rooms) {
		
		if(rooms== null || rooms.length==0) return ;

		boolean[][] visited = new boolean [rooms.length][rooms[0].length];

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Queue<Pos> q = new LinkedList<>();

		for(int i =0;i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length;j++) {
				if(rooms[i][j] == 0) {
					q.add(new Pos(i,j));
					visited[i][j] = true;
				}
			}
		}
		q.add(null);

		int count = 0;

		while(q.size() > 1) {

			Pos p = q.poll();

			if(p == null) {
				q.add(null);
				count++;
				continue;
			}

			for(int i=0; i<xArr.length; i++) {

				int xNew = p.x + xArr[i];
				int yNew = p.y + yArr[i];

				if(  xNew >= 0 && xNew < rooms.length && yNew>=0 && yNew<rooms[0].length && 
						rooms[xNew][yNew] ==  Integer.MAX_VALUE && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					rooms[xNew][yNew] = count;
					q.add(new Pos(xNew,yNew));
				}
			}
		}

	}


	// time limit exceeded- instead putting empty room and going to gate put gate in queue and go to empty room
	public void wallsAndGates1(int[][] rooms) {

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
