package fundingcircles;

import java.util.Scanner;

public class Problem4 {

	public static int area = 0;

	public static boolean flag = true;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String[] size =  in.nextLine().trim().split(" ") ; 
		int m = Integer.parseInt(size[0]);
		int n = Integer.parseInt(size[1]);

		char[][] grid = new char[m][n];
		for(int i = 0; i < m; i++) {
			String row;
			try {
				row = in.nextLine();
			} catch (Exception e) {
				row = null;
			}
			grid[i] = row.toCharArray();
		}

		int result = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == '.' && !visited[i][j]) {
					visited[i][j] = true;
					area = 0;
					flag = true;
					dfs(i, j, grid, visited);
					if(flag) {
						result += area;
					}
				}
			}
		}
		System.out.println(result);
	}



	public static void dfs(int x, int y, char[][] grid, boolean[][] visited) {

		int[] xArr = { 0, -1, 1, 0};
		int[] yArr = { -1, 0, 0, 1};
		
		if (x == 0 || x == grid.length-1
				|| y == 0 || y == grid[0].length-1) {
			flag = false;
			return;
		}
		
		area++;

		for(int i=0; i<xArr.length; i++){

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < grid.length
					&& yNew >= 0 && yNew < grid[0].length
					&& grid[xNew][yNew] == '.' && !visited[xNew][yNew]){
				visited[xNew][yNew] = true;
				dfs(xNew, yNew, grid, visited);
			}
		}
	}



}
