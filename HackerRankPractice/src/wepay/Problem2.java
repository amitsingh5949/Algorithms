package wepay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



public class Problem2 {

	private static final int[] xArr = {0,-1,1,0};
	private static final int[] yArr = {-1,0,0,1};

	public static int movesToSolve(List<List<Integer>> puzzle) {
		int count  = 0;

		int[][] board = new int[puzzle.size()][puzzle.get(0).size()];

		for(int i=0; i<puzzle.size(); i++) {
			for(int j =0; j<puzzle.get(0).size(); j++) {
				board[i][j] = puzzle.get(i).get(j);
			}
		}

		if(board == null || board.length == 0) return count;

		int[][] target = new int[board.length][board[0].length];

		int num =0;

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

