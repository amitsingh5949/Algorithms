package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		//int[][] matrix  = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] matrix  = {{1,2},{4,3}};
		System.out.println(new _417_PacificAtlanticWaterFlow().pacificAtlantic(matrix));

	}

	Set<List<Integer>> resAtlantic = null;
	Set<List<Integer>> resPacific = null;
	boolean[][] pathPossible = null;
	List<List<Integer>> res = null;

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {

		resAtlantic = new HashSet<>();
		resPacific = new HashSet<>();
		res = new ArrayList<List<Integer>>();
		
		if(matrix == null || matrix.length ==0 ) return res;
		
		pathPossible = new boolean[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				visited[i][j] = true;
				if(dfs(i,j, matrix, visited,false, "atlantic")){
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					resAtlantic.add(temp);
					pathPossible[i][j] = true;
				}
			}
		}
		
		pathPossible = new boolean[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				visited[i][j] = true;
				if(dfs(i,j, matrix, visited,false, "pacific")){
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					resPacific.add(temp);
					pathPossible[i][j] = true;
				}
			}
		}
		
		for(List<Integer> temp : resAtlantic) {
			if(resPacific.contains(temp)) {
				res.add(temp);
			}
		}
		
		return res;
	}


	public boolean dfs(int x, int y, int[][] matrix, boolean[][] visited, boolean res, String ocean) {


		if(pathPossible[x][y] || ( ocean.equalsIgnoreCase("atlantic") 
				&& (x == matrix.length-1 || y == matrix[0].length-1))){
			return true;
		}
		else if (pathPossible[x][y] || (ocean.equalsIgnoreCase("pacific")
				&& (x == 0 || y == 0))){
			return true;
		}

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i=0; i<xArr.length; i++) {

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew>=0 && xNew<matrix.length && 
					yNew >=0 && yNew<matrix[xNew].length &&
					!visited[xNew][yNew] && matrix[x][y] >= matrix[xNew][yNew]) {
				visited[xNew][yNew] = true;
				res = res || dfs(xNew, yNew, matrix, visited, res, ocean);
				visited[xNew][yNew] = false;
			}
		}
		return res;
	}

}
