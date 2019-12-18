package amazon.aakash;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

	public static void main(String[] args) {

	}
	
	private static int maxOfMinAltitudes1(int columnCount, int rowCount, int[][] mat) {
        int l = mat.length;
        int w = mat[0].length;
        int minPath = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[l][w];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.add(new int[]{0,0,0});
        visited[0][0] = true;
        
        while(queue.size() > 0) {
            int[] currPos = queue.poll();
            int smallest = currPos[2];
            
            int[] xDir = new int[]{-1, 1, 0, 0};
            int[] yDir = new int[]{ 0, 0, 1, -1};
            
            for(int i = 0; i < 4; i++) {
                int newY = currPos[0] + yDir[i];
                int newX = currPos[1] + xDir[i];
                
                if(newY >= 0 && newY < l && newX >= 0 && newX < w) {
                    if(newX == l -1 && newY == w - 1) {
                        if(minPath < smallest){
                            minPath = smallest;
                        }
                    } else 
                        if(!visited[newY][newX]) {
                        visited[newY][newX] = true;
                        if(smallest < mat[newY][newX]) {smallest = mat[newY][newX]; }
                        queue.add(new int[]{newY, newX, smallest});
                    }
                } 
            }
        }
        return minPath;
    }
	
	private static int maxOfMinAltitudes(int columnCount, int rowCount, int[][] mat) {
		    int r = mat.length, c = mat[0].length;
		    int[][] dp = new int[r][c];
		    dp[0][0] = Integer.MAX_VALUE; 
		    for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], mat[i][0]);
		    for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], mat[0][j]);
		    for (int i = 1; i < r; ++i) { 
		      for (int j = 1; j < c; ++j) {
		        if (i == r - 1 && j == c - 1) {
		          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
		        } else {
		          int score1 = Math.min(dp[i][j - 1], mat[i][j]); 
		          int score2 = Math.min(dp[i - 1][j], mat[i][j]); 
		          dp[i][j] = Math.max(score1, score2);
		        }
		      }
		    }
		    return dp[r - 1][c - 1];
		    
	 }

}
