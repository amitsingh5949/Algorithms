package com.javaDwarf.graphs.gfg.shortestpath;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class MinimumCostPath {


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int matrix[][] = new int[size][size];
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					matrix[j][k] =  in.nextInt();
				}
			}
			System.out.println(minCostPath(matrix, new PosSPL(0,0,matrix[0][0]), new PosSPL(size-1, size-1, -1)));
		}
		in.close();

	}

	private static int minCostPath(int[][] matrix, PosSPL src, PosSPL dest) {
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Map<Integer, DistanceInfo> map = new TreeMap<>();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				map.computeIfAbsent( uniqueCellID(i, j), 
						(x) -> (x==uniqueCellID(0, 0)) ? new DistanceInfo(matrix[0][0],0) : new DistanceInfo(Integer.MAX_VALUE,-1));
			}
		}

		PriorityQueue<PosSPL> q = new PriorityQueue<>();
		q.add(src);

		while(!q.isEmpty()) {
			PosSPL p = q.poll();

			for(int v=0; v<xArr.length; v++) {
				int nextX = p.x + xArr[v];
				int nextY = p.y + yArr[v];
				if(nextX >= 0 && nextX < matrix.length  && nextY >= 0 && nextY < matrix.length ) {
					int from = uniqueCellID(p.x, p.y);
					int to = uniqueCellID(nextX, nextY);
					map.computeIfPresent(to, (key, value) -> {
						int newDistance = map.get(from).getDistance() + matrix[nextX][nextY];
						if(newDistance < value.getDistance()) {
							value.setDistance(newDistance);
							value.setLastVertex(from);
							q.add(new PosSPL(nextX, nextY, newDistance));
						}
						return value;
					});
				}
			}
		}
		return map.get(uniqueCellID(dest.x, dest.y)).getDistance();
	}

	public static int uniqueCellID(int row, int col) {
		return (((row + col) * (row + col +1) ) /2 ) + col;
	}

}

class PosSPL implements Comparable<PosSPL> {
	int x,y,d;

	public PosSPL(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(PosSPL o) {
		return Integer.compare(this.d, o.d);
	}

}
