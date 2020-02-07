package amazon.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {

	public static void main(String[] args) {
		
		int[][] grid = {{0, 1, 1, 0, 1},
				 {0, 1, 0, 1, 0},
				 {0, 0, 0, 0, 1},
				 {0, 1, 0, 0, 0}};
		
		int[][] grid1 = {{0, 0, 0, 0, 0},
				 {0, 0, 0, 0, 0},
				 {0, 0, 0, 0, 0},
				 {0, 0, 0, 0, 0}};
		
		int[][] grid2 = {{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1}};
		
		int[][] grid4 = {{1,1,1,1}};
		
		int[][] grid5 = {{1,0,0,1}};
		
		System.out.println(new ZombieInMatrix().minDays(grid5));

	}

	public int minDays(int[][] grid) {

		int count = 0;
		
		if(grid == null || grid.length ==0 ) return 0;

		Queue<Cell> q = new LinkedList<>();

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		boolean allZeros =  true;

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					q.add(new Cell(i,j));
					visited[i][j] = true;
					allZeros = false;
				}
			}
		}
		
		if(allZeros) return -1;

		q.add(null);

		while(q.size() > 1) {

			Cell cell = q.poll();

			if(cell == null) {
				q.add(null);
				count++;
				continue;
			}

			int x = cell.x;
			int y = cell.y;

			int[] xArr = {0,-1,1,0};
			int[] yArr = {-1,0,0,1};

			for(int i=0; i<xArr.length; i++) {

				int xNew = x + xArr[i];
				int yNew = y + yArr[i];

				if(xNew >= 0 && xNew < grid.length && yNew >=0 && yNew < grid[0].length  &&
						grid[xNew][yNew] == 0 && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					q.add(new Cell(xNew, yNew));
				}
			}
		}

		return count;
	}

}

class Cell{

	public int x ;
	public int y;

	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}