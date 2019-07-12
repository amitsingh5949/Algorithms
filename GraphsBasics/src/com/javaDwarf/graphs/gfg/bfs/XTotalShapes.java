package com.javaDwarf.graphs.gfg.bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class XTotalShapes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int rowN = in.nextInt();
			int colN = in.nextInt();
			char matrix[][] = new char[rowN][colN];
			for(int j=0; j<rowN; j++){
				matrix[j] =  in.next().toCharArray();
			}
			System.out.println(xtotalShapes(matrix,rowN,colN));
		}
		in.close();
	}

	private static int xtotalShapes(char[][] matrix, int rowN, int colN) {
		int minX = 0; 
		boolean[][] visited = new boolean[rowN][colN];
		for(int j=0; j<matrix.length; j++){
			for(int k=0; k<matrix[j].length; k++){
				if(matrix[j][k] == 'X' && !visited[j][k]){
					bfs(new Pos1(j,k),matrix,visited);
					minX++;
				}
			}
		}
		return minX;
	}

	private static void bfs(Pos1 p, char[][] matrix, boolean[][] visited) {
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Queue<Pos1> q = new LinkedList<>();
		q.add(p);

		while(!q.isEmpty()){

			Pos1 pCurr = q.poll();
			visited[pCurr.x][pCurr.y]=true;

			for(int j=0; j<xArr.length; j++){

				if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
						pCurr.x+xArr[j]<matrix.length && pCurr.y+yArr[j]<matrix[pCurr.x+xArr[j]].length &&
						matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]] == 'X' && !visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
					q.add(new Pos1(pCurr.x+xArr[j],pCurr.y+yArr[j]));
				}
			}
		}
	}
}

class Pos1{
	int x;
	int y;

	public Pos1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
