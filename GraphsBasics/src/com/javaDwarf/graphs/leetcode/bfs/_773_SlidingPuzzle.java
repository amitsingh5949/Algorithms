package com.javaDwarf.graphs.leetcode.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Entire state of board is considered as one node, so in starting we have only one node
 * Target node would be {1,2,3}{4,5,0}
 * At each node apply BFS, get neighbors of current node by swapping empty tile with its neighbors and if state is not visited then add to queue
 * if current state becomes equal to target then break  and return count
 *  use of Arrays.deepToString(board) to get String and add in visited set and compare
 *  // use of clone to get new board, don't apply swapping on same board
 */

public class _773_SlidingPuzzle {

	public static void main(String[] args) {
		int[][] board = {{1,2,3},{4,0,5}};
		System.out.println(new _773_SlidingPuzzle().slidingPuzzle(board));
	}

	private static final int[] xArr = {0,-1,1,0};
	private static final int[] yArr = {-1,0,0,1};

	public int slidingPuzzle(int[][] board) {

		int count  = 0;

		if(board == null || board.length == 0) return count;

		int[][] target = new int[board.length][board[0].length];

		int num =1;

		Node start = null;

		for(int i=0; i<board.length; i++) {
			for(int j =0; j<board[0].length; j++) {
				if(board[i][j] == 0) {
					start = new Node(i, j,board);
				}
				target[i][j] = num;
				num++;
			}
		}
		
		target[board.length-1][board[0].length-1] = 0;

		String targetString = Arrays.deepToString(target);

		Set<String> visited = new HashSet<>();
		
		boolean found = false;

		Queue<Node> q = new LinkedList<>();
		q.add(start);
		q.add(null);

		while(q.size() > 1) {

			Node node = q.poll();

			if(node == null) {
				count++;
				q.add(null);
				continue;
			}
			
			visited.add(node.deepStringBoard);

			if(node.deepStringBoard.equals(targetString)) {
				found = true;
				break;
			}
			
			for(int i=0; i<xArr.length; i++) {
				int xNew = node.blankTileX + xArr[i];
				int yNew = node.blankTileY + yArr[i];

				if(xNew >=0 && xNew< board.length && yNew>=0 && yNew< board[0].length) {
					
					int[][] neighborNodeBoard = new int[node.board.length][node.board[0].length];
					
					for(int k =0; k<node.board.length; k++) {
						neighborNodeBoard[k] = node.board[k].clone();
					}

					neighborNodeBoard[node.blankTileX][node.blankTileY] = neighborNodeBoard[xNew][yNew];
					neighborNodeBoard[xNew][yNew] = 0;

					String neighborNodeBoardDeepString = Arrays.deepToString(neighborNodeBoard);

					if(!visited.contains(neighborNodeBoardDeepString)) {
						q.add(new Node(xNew, yNew, neighborNodeBoard));
					}
				}
			}
		}
		return found?count:-1;
	}

	class Node{

		int blankTileX = 0;
		int blankTileY = 0;
		int[][] board = null;
		String deepStringBoard = null;

		public Node(int blankTileX, int blankTileY, int[][] board) {
			super();
			this.blankTileX = blankTileX;
			this.blankTileY = blankTileY;
			this.board = board;
			deepStringBoard = Arrays.deepToString(board);
		}
	}

}
