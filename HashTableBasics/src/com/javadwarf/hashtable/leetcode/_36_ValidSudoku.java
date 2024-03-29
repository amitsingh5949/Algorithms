package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _36_ValidSudoku {

	public static void main(String[] args) {

	}
	/*****Technique 1 ***/
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

	//Technique 2 , box key can be generated by (i/3 +""+ j/3)
	public boolean isValidSudoku1(char[][] board) {

		Map<Integer, Set<Character>> rowMap = new HashMap<>(9);
		Map<Integer, Set<Character>> colMap = new HashMap<>(9);
		Map<String, Set<Character>> boxMap = new HashMap<>(9);

		for(int i =0; i<9; i++){

			for(int j =0; j<9; j++){

				char ch = board[i][j] ;

				if(ch != '.'){

					String key = i/3 +""+j/3;

					Set<Character> rowSet = rowMap.getOrDefault(i, new HashSet<>());
					Set<Character> colSet = colMap.getOrDefault(j, new HashSet<>());
					Set<Character> boxSet = boxMap.getOrDefault(key, new HashSet<>());

					if(rowSet.contains(ch) || colSet.contains(ch)  || boxSet.contains(ch)){
						return false;
					}

					rowSet.add(ch);
					rowMap.put(i, rowSet);

					colSet.add(ch);
					colMap.put(j, colSet);

					boxSet.add(ch);
					boxMap.put(key, boxSet);
				}

			}
		}
		return true;
	}

	//Technique 3 , box key can be generated by (i/3 +""+ j/3), use only one set
	public boolean isValidSudoku3(char[][] board) {

		Set<String> set = new HashSet<>(9*9);

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {

				char ch = board[i][j];

				if(ch != '.') {
					String rowKey = ch + "r" + i;
					String colKey = ch + "c" + j;
					String boxKey = ch + "" + i/3 + j/3;
					if(set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) {
						return false;
					}
					set.add(rowKey);
					set.add(colKey);
					set.add(boxKey);
				}
			}
		}
		return true;
	}

	//id can be generated by int boxid = (i/3)*3 + j/3;
	public boolean isValidSudokuBest(char[][] board) {

		Set<String> s = new HashSet<>();

		for( int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){

				if(board[i][j] != '.'){

					String row = "r" + i + board[i][j];
					String col = "c" + j + board[i][j];
					int b =  (i/3)+ j/3;
					String box = "b" + b + board[i][j];
					if(s.contains(row) || s.contains(col) || s.contains(box)) return false;
					s.add(row);
					s.add(col);
					s.add(box);

				}

			}
		}

		return true;
	}

}
