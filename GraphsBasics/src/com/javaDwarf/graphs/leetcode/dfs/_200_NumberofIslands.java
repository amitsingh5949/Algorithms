package com.javaDwarf.graphs.leetcode.dfs;

public class _200_NumberofIslands {

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'}, 
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};


		System.out.println(numIslands1(grid));
	}

	//****** Method 1 - dfs approach ***************
	public static int numIslands1(char[][] grid) {

		if(grid.length == 0) return 0;
		int result = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j, grid, visited);
					result++;
				}
			}
		}
		return result;
	}

	public static void dfs(int x, int y, char[][] grid, boolean[][] visited ) {

		int[] xArr = { 0, -1, 1, 0};
		int[] yArr = { -1, 0, 0, 1};

		for(int i=0; i<xArr.length; i++){

			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew < grid.length
					&& yNew >= 0 && yNew < grid[xNew].length
					&& grid[xNew][yNew] == '1' && !visited[xNew][yNew]){
				visited[xNew][yNew] = true;
				dfs(xNew, yNew, grid, visited);
			}
		}
	}
	
	// without visited
	public int numIslandsNoVisitedMatrix(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    int[] xArr = {-1,1,0,0};
    int[] yArr = {0,0,-1,1};
    
    public void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        for(int i=0;i<xArr.length; i++){
            int xNew = x + xArr[i];
            int yNew = y + yArr[i];
            if(xNew>=0 && xNew< grid.length && yNew>=0 && yNew<grid[0].length && grid[xNew][yNew] == '1'){
                dfs(grid, xNew, yNew);
            }
        }
    }

}
