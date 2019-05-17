package com.javaDwarf.dataStructure.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
//Dijkstra for weight graph - this is better done by DP not by Dijkstra
public class _64_MinimumPathSum {

	public static void main(String[] args) {
		int[][] arr = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		
		int[][] arr1 = {
				{1,2},
				{5,6},
				{1,1}
		};
		int[][] arr2 = {
				{0}
		};
		
		int[][] arr3 = {
				{9,1,4,8}
		};
		
		int[][] arr4 = {
				{9},{1},{4},{8}
		};
		
		System.out.println(new _64_MinimumPathSum().minPathSum(arr4));
	}

	public  int minPathSum(int[][] grid) {
		Map<Integer, PosDistanceInfo> map = new HashMap<>();
		PosDistanceInfo start = new PosDistanceInfo(0,0, grid[0][0], -1 );

		for(int i = 0; i<grid.length; i++) {
			for(int j =0; j<grid[i].length; j++) {
				if(i==0 && j ==0) {
					map.put(uniqueCellID(0, 0), new PosDistanceInfo(0, 0, grid[0][0], -1));
				}
				else {
					map.put(uniqueCellID(i, j), new PosDistanceInfo(i, j, Integer.MAX_VALUE, -1));
				}
			}
		}

		Set<Integer> visited = new HashSet<>(); 
		Queue<PosDistanceInfo> q = new PriorityQueue<>();
		q.add(start);
		visited.add(uniqueCellID(start.x, start.y));

		int[] xArr = {1,0};
		int[] yArr = {0,1};

		while(!q.isEmpty()) {
			PosDistanceInfo p = q.poll();

			for(int i=0; i<xArr.length ; i++) {
				int nextX = p.x + xArr[i];
				int nextY = p.y + yArr[i];

				if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length ) {
					if(visited.contains(uniqueCellID(nextX, nextY))) {
						if(p.distance + grid[nextX][nextY] < map.get(uniqueCellID(nextX, nextY)).distance) {
							int d = p.distance + grid[nextX][nextY] ;
							map.get(uniqueCellID(nextX, nextY)).distance = d;
							map.get(uniqueCellID(nextX, nextY)).lastVisitedNode = uniqueCellID(p.x, p.y);
						}
					}
					else {
						int d = p.distance + grid[nextX][nextY] ;
						map.get(uniqueCellID(nextX, nextY)).distance = d;
						map.get(uniqueCellID(nextX, nextY)).lastVisitedNode = uniqueCellID(p.x, p.y);
						q.add(new PosDistanceInfo(nextX, nextY, d , uniqueCellID(p.x, p.y)));
						visited.add(uniqueCellID(nextX, nextY));
					}

				}
			}
		}
		return map.get(uniqueCellID(grid.length-1, grid[grid.length-1].length-1)).distance;

	}

	public static int uniqueCellID(int row, int col) {
		return (((row + col) * (row + col + 1) ) / 2) + col;
	}

	class PosDistanceInfo implements Comparable<PosDistanceInfo>{
		int x, y;
		int distance = 0 ;
		int lastVisitedNode = -1;
		public PosDistanceInfo(int x, int y, int distance, int lastVisitedNode) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.lastVisitedNode = lastVisitedNode;
		}
		@Override
		public int compareTo(PosDistanceInfo o) {
			return Integer.compare(this.distance, o.distance);
		}
		@Override
		public String toString() {
			return "("+ x + "," + y + ")-"+distance;
		}
		

	}


}
