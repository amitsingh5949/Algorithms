package january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		Integer[][] matrix = {{0,2,1},{1,2,0},{1,0,0}};
		
		List<List<Integer>> maze = new ArrayList<List<Integer>>();
		
		for(int i =0; i<matrix.length; i++) {
			maze.add(Arrays.asList(matrix[i]));
		}
		
		System.out.println(minMoves(maze, 2, 2));
	}

	public static int result = Integer.MAX_VALUE;
	public static int gold = Integer.MAX_VALUE;

	public static int minMoves(List<List<Integer>> maze, int x, int y) {
		if(maze == null || maze.size() == 0) return -1;
		result = Integer.MAX_VALUE;
		gold = getgoldCoin(maze);

		int[][] matrix = new int[maze.size()][maze.get(0).size()];

		int goldSoFar  = 0;


		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {

				if(maze.get(i).get(j) == 1) {
					matrix[i][j] = Integer.MAX_VALUE;
					continue;
				}

				if(maze.get(i).get(j) == 2) {
					goldSoFar  += 1;
				}

				if(i==0 && j==0) {
					matrix[i][j] = maze.get(i).get(j);
				}
				else if(i==0 && j!=0) {
					matrix[i][j] =  matrix[i][j-1] + 1;
				}
				else if(i!=0 && j==0) {
					matrix[i][j] =   matrix[i-1][j] + 1;
				}
				else {
					matrix[i][j] = Integer.min(matrix[i][j-1] ,matrix[i-1][j]) + 1;
				}

				if(i == x && j == y) {
					if(goldSoFar == gold) {
						return matrix[i][j];
					}

				}
			}
		}
		return -1;
	}

	public static int  getgoldCoin(List<List<Integer>> maze) {
		int count = 0 ;
		for(int i =0; i<maze.size(); i++) {
			for(int j =0; j<maze.get(0).size(); j++){
				if(maze.get(i).get(j) == 2) {
					count += 1;
				}
			}
		}
		return count;
	}


	/*

	public static int result = Integer.MAX_VALUE;
	public static int gold = Integer.MAX_VALUE;

	public static int minMoves(List<List<Integer>> maze, int x, int y) {
		if(maze == null || maze.size() == 0) return -1;
		result = Integer.MAX_VALUE;
		gold = getgoldCoin(maze);
		boolean[][] visited = new boolean[maze.size()][maze.get(0).size()];
		visited[0][0] = true;
		int goldSofar  = 0;
		if(maze.get(0).get(0) == 2) {
			goldSofar = 1;
		}
		dfs(maze, 0, 0, x, y, visited, 0, goldSofar);
		return result == Integer.MAX_VALUE ? -1: result;
	}


	public static void dfs(List<List<Integer>> maze, int x, int y, int x1, int y1, boolean[][] visited, int path, int goldSofar) {

		if(x == x1 && y == y1 && gold == goldSofar) {
			result = Math.min(result, path);
			return;
		}

		if(x == x1 && y == y1 && gold != goldSofar) {
			return;
		}

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i=0; i<xArr.length; i++) {

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < maze.size() && yNew >=0 && yNew < maze.get(0).size()
					&& !visited[xNew][yNew] && maze.get(xNew).get(yNew) != 1) {
				path += 1;
				visited[xNew][yNew] = true;
				if(maze.get(xNew).get(yNew) ==2 ) {
					goldSofar += 1;
				}
				dfs(maze, xNew, yNew, x1,y1, visited,path,goldSofar);
				path -= 1;
				if(maze.get(xNew).get(yNew) ==2 ) {
					goldSofar -= 1;
				}
				visited[xNew][yNew] = false;
			}
		}
	}

	public static int  getgoldCoin(List<List<Integer>> maze) {
		int count = 0 ;
		for(int i =0; i<maze.size(); i++) {
			for(int j =0; j<maze.get(0).size(); j++){
				if(maze.get(i).get(j) == 2) {
					count += 1;
				}
			}
		}
		return count;
	}

	 */

}
