package com.javadwarf.disjointset.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _305_NumberofIslands {

	public static void main(String[] args) {
		
	}

	public static DisjointSet ds = null;

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		
		List<Integer> res = new ArrayList<>();
		if(positions.length == 0) return res;

		char[][] grid = new char[m][n];

		ds = new DisjointSet();

		for(int a=0; a<positions.length; a++) {
			
			int i = positions[a][0];
			int j = positions[a][1];
			
			int v1 = uniqueCellID(i,j);
			grid[i][j] = '1';
			if(ds.map.get(v1)==null) {
				ds.makeSet(v1);
			}
			
			int[] xArr = { 0, -1, 1, 0};
			int[] yArr = { -1, 0, 0, 1};

			for(int k=0; k<xArr.length; k++){

				int xNew = i + xArr[k];
				int yNew = j + yArr[k];

				if(xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && grid[xNew][yNew] == '1'){
					int v2 = uniqueCellID(xNew, yNew);
					ds.union(v1,v2 );
				}
			}
			
			for(int key : ds.map.keySet()) {
				ds.find(key);
			}
			
			int max = 0;
			for(DisjointSet.Node node : ds.map.values()) {
				if(node.data == node.parent.data) {
					max++;
				}
			}
			res.add(max);
		}
		return res;
	}
	
	public static int uniqueCellID(int row, int col) {
		return (((row + col) * (row + col +1) ) /2 ) + col;
	}

}
