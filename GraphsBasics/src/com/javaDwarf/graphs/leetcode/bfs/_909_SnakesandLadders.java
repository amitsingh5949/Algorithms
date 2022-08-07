package com.javaDwarf.graphs.leetcode.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _909_SnakesandLadders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
// bfs approach with visited array
	int n = 0;
	int m = 0;

	public int snakesAndLadders(int[][] board) {
		n = board.length;
		m = board[0].length;

		Set<Integer> visited = new HashSet<>();
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited.add(1);

		while(!q.isEmpty()){

			int size = q.size();

			for(int i= 0; i< size; i++){

				int cellId = q.poll();

				for(int j=1; j<=6; j++){

					int nextCellId = cellId + j;

					if(nextCellId == n*m) return count+1;

					if(!visited.contains(nextCellId)){
						visited.add(nextCellId);
						int[] nextCellCordinates = getCellXY(nextCellId);
						if(board[nextCellCordinates[0]][nextCellCordinates[1]] != -1){
							nextCellId = board[nextCellCordinates[0]][nextCellCordinates[1]];
						}

						if(nextCellId == n*m) return count+1;
						q.add(nextCellId);
					}
				}
			}

			count++;
		}

		return -1;
	}

	public int[] getCellXY(int cellId){
		int x = (n - 1) - (cellId-1) / m;
		// if even row from bottom then movement is from left to right
		boolean isEvenRow = ((cellId-1) / m)%2 == 0; 
		int y = isEvenRow ?  (cellId-1) % m : (m-1) - (cellId-1) % m ;
		return new int[]{x, y};
	}

	/*                       
	    public int getCellId(int x , int y){
	      int xNew = (n-1) - x;
	      // if even row from bottom then movement is from left to right
	      boolean isEvenRow = x%2 == 0; 
	      int yNew =  isEvenRow ? y : (m-1) - y;  
	      return xNew * m + yNew + 1;    
	    }*/
	
	// bfs approach without visited array
	public int snakesAndLadders1(int[][] board) {
        n = board.length;
        m = board[0].length;
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        board[n-1][0] = -2;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i= 0; i< size; i++){
                
                int cellId = q.poll();
                
                for(int j=1; j<=6; j++){
                    
                    int nextCellId = cellId + j;
                    
                    if(nextCellId == n*m) return count+1;
                    
                    int[] nextCellCordinates = getCellXY(nextCellId);
                    
                    if(board[nextCellCordinates[0]][nextCellCordinates[1]] != -2){
                        
                        if(board[nextCellCordinates[0]][nextCellCordinates[1]] != -1){
                            nextCellId = board[nextCellCordinates[0]][nextCellCordinates[1]];
                        }
                        
                        board[nextCellCordinates[0]][nextCellCordinates[1]] = -2;
                        nextCellCordinates = getCellXY(nextCellId);
                        board[nextCellCordinates[0]][nextCellCordinates[1]] = -2;
                        
                        if(nextCellId == n*m) return count+1;
                        
                        q.add(nextCellId);
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
	//dp - does not work
	
	    
	public int snakesAndLadders2(int[][] board) {
        n = board.length;
        m = board[0].length;
        int[][] dp = new int[board.length][board.length];
        
        for(int[] arr : dp){
            Arrays.fill(arr, n*n+1);
        }
        dp[n-1][0] = 0;
        
        for(int i=1; i< n*n; i++){
            
            int[] cellCoordinate = getCellXY(i);
            
            for( int j=1; j<=6; j++){
                
                int nextCell = i + j;
                
                if(nextCell > n*n) continue;
                
                int[] nextCellCoordinate = getCellXY(nextCell);
                
                if(board[nextCellCoordinate[0]][nextCellCoordinate[1]] != -1){
                    nextCell = board[nextCellCoordinate[0]][nextCellCoordinate[1]];
                    nextCellCoordinate = getCellXY(nextCell);
                    
                }
                dp[nextCellCoordinate[0]][nextCellCoordinate[1]] = Math.min(dp[nextCellCoordinate[0]][nextCellCoordinate[1]],
                                                                           dp[cellCoordinate[0]][cellCoordinate[1]] + 1);
                }
            }            
        
        if(n%2==0){
             return dp[0][0] == n*n+1?-1:dp[0][0];
        }
        else{
             return dp[0][n-1] == n*n+1?-1:dp[0][n-1];
        }
    
    }

}
