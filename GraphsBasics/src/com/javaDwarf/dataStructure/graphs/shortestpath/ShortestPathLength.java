package com.javaDwarf.dataStructure.graphs.shortestpath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathLength {

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
			Pos src = new Pos(0,0);
			Pos dest = new Pos(s.nextInt(),s.nextInt());
			System.out.println(shortestPathLength(matrix, row, col, src, dest));
		}
		s.close();
	}

	private static int shortestPathLength(int[][] matrix, int row, int col, Pos src, Pos dest) {
		
		if(matrix[0][0]==0) {
			return -1;
		}
		
		if(dest.x==0 && dest.y==0 && matrix[0][0]==1) {
			return 0;
		}
		
		boolean[][] visited = new boolean[row][col];

		Map<Integer, DistanceInfo> map = new HashMap<>();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map.computeIfAbsent( uniqueCellID(i, j), 
						(x) -> (x==uniqueCellID(0, 0)) ? new DistanceInfo(0,0) : new DistanceInfo(-1,-1));
			}
		}

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Queue<Pos> q = new LinkedList<>();
		if(matrix[src.x][src.y] != 0) {
			q.add(src);
			visited[src.x][src.y] = true;
		}
		while(!q.isEmpty()) {
			Pos p = q.poll();

			for(int v = 0; v< xArr.length; v++) {

				int nextX = p.x + xArr[v];
				int nextY = p.y + yArr[v];

				if(nextX >= 0 && nextX < row  &&  nextY >= 0 && nextY < col &&
						matrix[nextX][nextY] != 0 && !visited[nextX][nextY] ) {

					visited[nextX][nextY]  = true;
					q.add(new Pos(nextX, nextY));
					int from = uniqueCellID(p.x, p.y);
					int to = uniqueCellID(nextX, nextY);
					map.computeIfPresent(to, (key, value) -> {
						if(value.getDistance() == -1) {
							value.setLastVertex(from);
							value.setDistance(map.get(from).getDistance() + 1);
						}
						return value;
					});
				}
			}

		}
		
		return map.get(uniqueCellID(dest.x, dest.y)).getDistance() == 0 ? -1 : map.get(uniqueCellID(dest.x, dest.y)).getDistance() ;
	}

	public static int uniqueCellID(int row, int col) {
		return (((row + col) * (row + col +1) ) /2 ) + col;
	}

}
