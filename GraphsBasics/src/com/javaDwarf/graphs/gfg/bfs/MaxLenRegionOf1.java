package com.javaDwarf.graphs.gfg.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxLenRegionOf1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int rowN = in.nextInt();
			int colN = in.nextInt();
			int matrix[][] = new int[rowN][colN];
			for(int j=0; j<rowN; j++){
				for(int k=0; k<colN; k++){
					matrix[j][k] =  in.nextInt();
				}
			}
			System.out.println(maxLenReg(matrix,rowN,colN));
		}
		in.close();
	}

	private static int maxLenReg(int[][] matrix, int rowN, int colN) {
		int maxLen = -1; 
		boolean[][] visited = new boolean[rowN][colN];
		for(int j=0; j<matrix.length; j++){
			for(int k=0; k<matrix[j].length; k++){
				if(matrix[j][k] == 1 && !visited[j][k]){
					int temp = bfs(new Pos2(j,k),matrix,visited);
					if(temp>maxLen){
						maxLen=temp;
					}
				}
			}
		}
		return maxLen;
	}

	private static int bfs(Pos2 p, int[][] matrix, boolean[][] visited) {
		int maxLen = 0; 
		int[] xArr = {-1,0,1,-1,1,-1,0,1};
		int[] yArr = {-1,-1,-1,0,0,1,1,1};

		Queue<Pos2> q = new LinkedList<>();
		q.add(p);
		visited[p.x][p.y]=true;

		while(!q.isEmpty()){

			Pos2 pCurr = q.poll();

			maxLen++;

			for(int j=0; j<xArr.length; j++){

				if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
						pCurr.x+xArr[j]<matrix.length && pCurr.y+yArr[j]<matrix[pCurr.x+xArr[j]].length &&
						matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]] == 1 && !visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
					q.add(new Pos2(pCurr.x+xArr[j],pCurr.y+yArr[j]));
					visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]=true;
				}
			}
		}
		return maxLen;
	}
}

class Pos2{
	int x;
	int y;

	public Pos2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
