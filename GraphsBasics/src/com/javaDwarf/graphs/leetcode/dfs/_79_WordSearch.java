package com.javaDwarf.graphs.leetcode.dfs;

public class _79_WordSearch {

	public static void main(String[] args) {
		char[][] arr = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};

		System.out.println(new _79_WordSearch().exist(arr, "ABCCED"));

	}

	public boolean exist(char[][] board, String word) {

		if(word == null || word.length()== 0 || board == null || board.length == 0 ) return false;

		for( int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == word.charAt(0) && 
						helper(board, word, i,j,1, new boolean[board.length][board[0].length])){
					return true;
				}
			}
		}
		return false;
	}

	int[] xArr = {-1,1,0,0};
	int[] yArr = {0,0,-1,1};

	public boolean helper(char[][] board, String word, int x, int y, int idx, boolean[][] visited){

		visited[x][y] = true;

		if(idx == word.length()) return true;

		boolean result = false;

		for( int k=0; k<xArr.length; k++){
			int xn = x + xArr[k];
			int yn = y + yArr[k];

			if(xn >=0 && xn<board.length && yn>=0 && yn<board[0].length
					&& board[xn][yn] == word.charAt(idx) && !visited[xn][yn]){
				result = result || helper(board, word, xn, yn, idx+1, visited);
			}
		}

		visited[x][y] = false;

		return result;
	}
}
