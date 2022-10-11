package com.javaDwarf.graphs.leetcode.dfs;

public class _733_FloodFill {

	public static void main(String[] args) {

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		if(image == null || image.length ==0 ) return image;
		
		dfs(image,sr,sc,image[sr][sc], newColor, new boolean[image.length][image[0].length]);
		return image;
	}

	public void dfs(int[][] image, int sr, int sc,int oldColor, int newColor, boolean[][] visited) {

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		visited[sr][sc] = true;
		image[sr][sc] = newColor;

		for(int i =0; i<xArr.length; i++) {

			int xNew = sr + xArr[i];
			int yNew = sc + yArr[i];

			if(xNew >= 0 && xNew<image.length && yNew >= 0 && yNew<image[0].length
					&& !visited[xNew][yNew] && image[xNew][yNew] == oldColor) {
				
				dfs(image,xNew, yNew, oldColor, newColor,visited);
			}
		}
	}
	
	// same as above without using visited
	public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sc,image[sr][sc], color); 
        return image; 
    }
    
    int[] xArr = {-1,1,0,0};
    int[] yArr = {0,0,-1,1};
    
    public void dfs(int[][] image, int sr, int sc, int original, int color ){
        image[sr][sc] = color;
        for(int i=0; i<xArr.length; i++){
            int newX = sr + xArr[i];
            int newY = sc + yArr[i];
            if( newX>=0 && newX<image.length && newY>=0 && newY<image[0].length 
               &&  image[newX][newY] == original){
                dfs(image, newX, newY, original, color);
            }
        }
    }

}

