package com.javaDwarf.graphs.leetcode.dfs;

public class _529_Minesweeper {

	public static void main(String[] args) {
		char[][] board = {
				{'E','E','E','E','E','E','E','E'},
				{'E','E','E','E','E','E','E','M'},
				{'E','E','M','E','E','E','E','E'},
				{'M','E','E','E','E','E','E','E'},
				{'E','E','E','E','E','E','E','E'},
				{'E','E','E','E','E','E','E','E'},
				{'E','E','E','E','E','E','E','E'},
				{'E','E','M','M','E','E','E','E'}
				};
		
		System.out.println(new _529_Minesweeper().updateBoard(board, new int[] {0,0}));

	}

	private static int[] xArr = {-1,0,1,-1,1,-1,0,1};
	private static int[] yArr = {-1,-1,-1,0,0,1,1,1};

	private boolean mineFound = false;

	public char[][] updateBoard(char[][] board, int[] click) {
		mineFound = false;
		dfs(click[0],click[1], board, new boolean[board.length][board[0].length]);
		return board;
	}

	public void dfs(int x, int y ,char[][] board, boolean[][] visited) {

		if(mineFound) {
			return;
		}

		visited[x][y] = true;
		update(x, y, board);

		if(board[x][y] == 'B') {
			for(int i=0; i<xArr.length; i++) {
				int xNew = x + xArr[i];
				int yNew = y + yArr[i];

				if(xNew >= 0 && xNew<board.length && yNew >= 0 && yNew<board[0].length 
						&& !visited[xNew][yNew] && board[xNew][yNew] == 'E') {
					dfs(xNew,yNew,board,visited);
				}
			}
		}
	}

	public void update(int x, int y ,char[][] board) {

		if(board[x][y] == 'M') {
			board[x][y] = 'X';
			mineFound = true;
			return;
		}

		int numOfMines = 0;

		for(int i=0; i<xArr.length; i++) {
			int xNew = x + xArr[i];
			int yNew = y + yArr[i];

			if(xNew >= 0 && xNew<board.length && yNew >= 0 && yNew<board[0].length) {
				if(board[xNew][yNew] == 'M') {
					numOfMines++;
				}
			}
		}

		if(numOfMines == 0) {
			board[x][y] = 'B';
		}
		else{
			board[x][y] = Integer.toString(numOfMines).charAt(0);
		}
	}

}
