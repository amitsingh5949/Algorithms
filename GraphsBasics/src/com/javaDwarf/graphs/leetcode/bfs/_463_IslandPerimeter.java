package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class _463_IslandPerimeter {

	//BFS  : time nad space  : o(mn)
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int[][] dirs = {{0,-1},{1,0},{-1,0},{0,1}};

		Queue<Pair<Integer, Integer>> q = new LinkedList<>();

		outer : for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){ 
				if(grid[i][j] == 1){
					q.add(new Pair<>(i,j));
					grid[i][j] = 2;
					break outer;
				}
			}
		}

		while(!q.isEmpty()){

			Pair<Integer, Integer> p = q.poll();

			int x = p.getKey();
			int y = p.getValue();

			if(x==0){
				perimeter++;
			}
			if(x==grid.length-1){
				perimeter++;
			}
			if(y==0 ){
				perimeter++;
			}
			if(y==grid[0].length-1){
				perimeter++;
			}

			for(int[] dir : dirs){
				int xNew = x + dir[0];
				int yNew = y + dir[1];

				if(xNew>=0 && xNew< grid.length && yNew>=0 && yNew<grid[0].length){

					if(grid[xNew][yNew] == 0){
						perimeter++;
					}
					else if(grid[xNew][yNew] == 1){
						q.add(new Pair<>(xNew, yNew));
						grid[xNew][yNew] = 2;
					}
				}
			}
		}
		return perimeter;
	}

	//time : o(mn) and space : o(1)
	public int islandPerimeter2(int[][] grid) {
		int perimeter = 0;
		int[][] dirs = {{0,-1},{1,0},{-1,0},{0,1}};

		for(int x=0; x<grid.length; x++){
			for(int y=0;y<grid[0].length; y++){ 
				if(grid[x][y] == 1){
					if(x==0){
						perimeter++;
					}
					if(x==grid.length-1){
						perimeter++;
					}
					if(y==0 ){
						perimeter++;
					}
					if(y==grid[0].length-1){
						perimeter++;
					}
					for(int[] dir : dirs){
						int xNew = x + dir[0];
						int yNew = y + dir[1];
						if(xNew>=0 && xNew< grid.length && yNew>=0 && yNew<grid[0].length && grid[xNew][yNew] == 0){
							perimeter++;
						}
					}
				}
			}
		}
		return perimeter;
	}

}
