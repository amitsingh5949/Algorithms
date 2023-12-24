package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		//int[][] matrix  = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] matrix  = {{1,2},{4,3}};
		System.out.println(new _417_PacificAtlanticWaterFlow().pacificAtlantic(matrix));

	}



	//Below is o(m*n)^2 time
	// Brute Force Approach: for each cell , see if we can reach both oceans using DFS. Little optimization also, if we find the cell from where we can reach both
	// oceans then mark it and return true as no need to go in recursion from that cell.

	//Optimal Approach is to run dfs two times
		// 1. start DFS from all Atlantic cells and mark other cell true in Atlantic visited array which are reachable by Atlantic cells
		// 2. start DFS from all pacific cells and mark other cell true in pacific visited array which are reachable by pacific cells
		// take intersection of both true cells 

		// See BFS approach

	List<List<Integer>> res;
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		res = new ArrayList<>();
		int[][] state = new int[heights.length][heights[0].length];
		for(int i=0; i<heights.length; i++){
			for(int j=0; j<heights[0].length; j++){
				dfs(heights, i,j,state);            
			}
		}
		return res;
	}
	// return 1 if pacific, return 2 if Atlantic and 3 for both
	public int dfs(int[][] heights, int x, int y, int[][] state){

		if(state[x][y] == 3) return 3;

		state[x][y] = -1;// visiting cell

		int[] xd = {-1,1,0,0};
		int[] yd = {0,0,-1,1};

		Set<Integer> set = new HashSet<>();

		for( int i=0; i<xd.length; i++){
			int xn = x + xd[i];
			int yn = y + yd[i];
			if(xn < 0 || yn < 0 ) set.add(1); // pacific 
			else if(xn == heights.length || yn == heights[0].length ) set.add(2);// Atlantic
			else if(heights[xn][yn] <=  heights[x][y] && state[xn][yn] != -1) set.add(dfs(heights, xn, yn, state));
		}

		if(set.contains(3) || (set.contains(1) && set.contains(2))){
			state[x][y] = 3;
			res.add(Arrays.stream(new int[]{x,y}).boxed().collect(Collectors.toList()));
			return 3;
		}
		state[x][y] = 0;// backtrack to original state after visiting
		if(set.contains(1)) return 1;
		if(set.contains(2)) return 2;
		return 0;
	}
	
	

	/*****************************************************************************************************************************************************************/

	Set<List<Integer>> resAtlantic = null;
	Set<List<Integer>> resPacific = null;
	boolean[][] pathPossible = null;

	public List<List<Integer>> pacificAtlantic1(int[][] matrix) {

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

