package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _529_Minesweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int[] xArr = {-1,0,1,-1,1,-1,0,1};
    int[] yArr = {-1,-1,-1,0,0,1,1,1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        if(board == null || board.length == 0) return board;
        if(click == null || click.length == 0) return board;
        if(click[0] < 0 || click[0]>= board.length) return board;
        if(click[1] < 0 || click[1]>= board[0].length) return board;
        
        if(board[click[0]][click[1]] =='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{click[0], click[1]});
        
        while(!q.isEmpty()){
            
            Integer[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            
            if(board[x][y] != 'E') continue;
            
            Queue<Integer[]> q1 = new LinkedList<>();
            int count = 0; 
            
            for( int i=0; i<xArr.length ; i++){
                
                int xNew = x + xArr[i];
                int yNew = y + yArr[i];
                
                if(xNew>=0 && xNew<board.length && yNew>=0 && yNew < board[0].length){
                    if(board[xNew][yNew] == 'M'){
                        count++;
                    }
                    if(board[xNew][yNew] == 'E'){
                        q1.add( new Integer[]{xNew, yNew});
                    }
                }
            }
            
            if(count == 0){
                board[x][y] = 'B';
                q.addAll(q1);
            }
            else{
               board[x][y] = ((char)(count + '0')); 
            }
            
        }
        
        return board;
        
    }

}
