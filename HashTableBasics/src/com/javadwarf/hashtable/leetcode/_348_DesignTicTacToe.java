package com.javadwarf.hashtable.leetcode;

public class _348_DesignTicTacToe {

	public static void main(String[] args) {

	}
	
	int[] rowCount = null;
	int[] columCount = null;
	int leftToRightDiagonal = 0;
	int rightToLeftDiagonal = 0;
	int size = 0;
	
	 /** Initialize your data structure here. */
    public _348_DesignTicTacToe(int n) {
        rowCount = new int[n];
        columCount = new int[n];
        leftToRightDiagonal = 0;
        rightToLeftDiagonal = 0;
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
    	if(player == 1) {
    		rowCount[row]++;
    		columCount[col]++;
    		if( row == col ) {
    			leftToRightDiagonal++;
    		}
    		if( (row+col == size-1)) {
    			rightToLeftDiagonal++;
    		}
    	}
    	else {
    		rowCount[row]--;
    		columCount[col]--;
    		if( row == col ) {
    			leftToRightDiagonal--;
    		}
    		if( (row+col == size-1)) {
    			rightToLeftDiagonal--;
    		}
    	}
    	
    	if(rowCount[row] == size || columCount[col] == size || leftToRightDiagonal == size || rightToLeftDiagonal == size ) {
			return 1;
		}
    	else if(rowCount[row] == size*-1 || columCount[col] == size*-1 || leftToRightDiagonal == size*-1 || rightToLeftDiagonal == size*-1) {
    		return 2;
    	}
    	return 0;
    }

}
