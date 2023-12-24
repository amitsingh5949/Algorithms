package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class _130_SurroundedRegions {
	public void solve(char[][] board) {

		Queue<Pair<Integer, Integer>> q = new LinkedList<>();

		// we don't need to change 'X's and boundaries 'O', all we have to worry about non-boundary 'O' 
		//mark non-boundary 'O with 'W' just to differentiate with boundary 'O'
		//Add boundary 'O' to queue as these will turn their neighbors 'O' as well.
		for(int i=0;i<board.length; i++){
			for(int j=0;j<board[0].length; j++){
				if(board[i][j] == 'O' ){
					if(i==0 || i== board.length-1 || j ==0 || j==board[0].length-1) q.add(new Pair<>(i,j));
					else board[i][j] = 'W';
				}
			}
		}

		// Run BFS and turn all boundary 'O' neighbors to 'O" as well
		int[] xd = {0,0,-1,1};
		int[] yd = {-1,1,0,0};

		while(!q.isEmpty()){
			int size = q.size();
			for(int k=0; k<size; k++){
				Pair<Integer, Integer> curr = q.poll();
				for(int i=0; i<xd.length; i++){
					int xn = curr.getKey() + xd[i];
					int yn = curr.getValue() + yd[i];
					if(xn >=0 && xn<board.length && yn >=0 && yn<board[0].length && board[xn][yn] == 'W') {
						q.add( new Pair<>(xn, yn));
						board[xn][yn] = 'O';
					}
				}
			}
		}

		//Remaining non-boundary 'O' which were not in contact of boundary 'O' , we can flip them to 'X'
		for(int i=0;i<board.length; i++){
			for(int j=0;j<board[0].length; j++){
				if(board[i][j] == 'W' ) board[i][j] = 'X';
			}
		}
	}

}