package com.javadwarf.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _36_ValidSudoku {

	public static void main(String[] args) {

	}

	// we need to do it in one iteration
	// There are nine sub-boxes(3*3) in 9*9 grid, based on current (i,j) keeping element count for rows and columns is easy 
	//but for sub boxes index is calculated by int subBoxIndex = (i/3)*3 + (j/3);

	public boolean isValidSudoku(char[][] board) {

		Set<Character>[] rowSet = new HashSet[9];
		Set<Character>[] colSet = new HashSet[9];
		Set<Character>[] subBoxSet = new HashSet[9];

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				
				char ch = board[i][j];

				if(ch != '.') {
					int subBoxIndex = (i/3)*3 + (j/3);

					if(rowSet[i] == null) {
						rowSet[i] =  new HashSet<>();
					}
					if(colSet[j] == null) {
						colSet[j] =  new HashSet<>();
					}
					if(subBoxSet[subBoxIndex] == null) {
						subBoxSet[subBoxIndex] =  new HashSet<>();
					}
					if(rowSet[i].contains(ch) || colSet[j].contains(ch) || subBoxSet[subBoxIndex].contains(ch)) {
						return false;
					}
					rowSet[i].add(ch);
					colSet[j].add(ch);
					subBoxSet[subBoxIndex].add(ch);
				}
			}
		}
		return true;
	}	

}
