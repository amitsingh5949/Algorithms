package com.javaDwarf.graphs.leetcode.dfs;

public class _130_SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','O','X','X'}};
		char[][] board1 = {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
		new _130_SurroundedRegions().solve(board1);
		System.out.println(new String(board1[1]));
	}

	
	// wrong code below, see BFS approach, understand it and maybe then can write DFS based on BFS approach. (Hint : same as rotten orange)
	public void solve(char[][] board) {

		if(board ==  null || board.length == 0) return;

		boolean[][] visited = new boolean[board.length][board[0].length]; 

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				dfs(new Pos(i,j),board, visited);
			}
		}
	}

	public void dfs (Pos p , char[][] board, boolean[][] visited) {

		visited[p.x][p.y] = true;

		if(p.x ==  board.length-1 || p.y == board[0].length-1) return;

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i =0; i<xArr.length; i++) {

			int xNew = p.x + xArr[i];
			int yNew = p.y + yArr[i];

			if(xNew >= 0 && xNew<board.length && yNew >= 0 && yNew<board[0].length
					&& !visited[xNew][yNew]) {

				if(board[xNew][yNew] == 'O' 
						&& (xNew == 0 || xNew ==  board.length-1 
						|| yNew == 0 || yNew == board[0].length-1)) {
					return;
				}
				else if(board[p.x][p.y]== 'X' && board[xNew][yNew] == 'O' ) {
					boolean flip = true;
					for(int j =0; j<xArr.length; j++) {
						int neighbourX = xNew + xArr[j];
						int neighbourY = yNew + yArr[j];
						if(neighbourX >= 0 && neighbourX<board.length 
								&& neighbourY >= 0 && neighbourY<board[0].length
								&& board[neighbourX][neighbourY] == 'O'
								&& (neighbourX == 0 || neighbourX ==  board.length-1 
								|| neighbourY == 0  || neighbourY == board[0].length-1)){
							flip = false;
						}
					}
					if(flip) {
						board[xNew][yNew] = 'X';
					}
					else {
						return;
					}
				}
				dfs(new Pos(xNew, yNew), board, visited);
			}
		}
	}

	class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
