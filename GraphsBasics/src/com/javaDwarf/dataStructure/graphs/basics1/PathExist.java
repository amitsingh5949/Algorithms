package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PathExist {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int matrix[][] = new int[size][size];
			Pos4 src = null;
			Pos4  dest = null;
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					matrix[j][k] =  in.nextInt();
					if(matrix[j][k] == 1)
						src = new Pos4(j,k);
					if(matrix[j][k] == 2)
						dest = new Pos4(j,k);
				}
			}
			System.out.println(pathExist(src, dest, matrix)?"1":"0");
		}
		in.close();
	}

	private static boolean pathExist(Pos4 src, Pos4 dest, int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix.length];
		boolean pathExist = false; 
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};	

		Queue<Pos4> q = new LinkedList<>();
		q.add(src);
		visited[src.x][src.y]=true;

		while(!q.isEmpty()){

			Pos4 pCurr = q.poll();

			if(pCurr.x==dest.x && pCurr.y==dest.y){
				return true;
			}
			else{
				for(int j=0; j<xArr.length; j++){
					if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
							pCurr.x+xArr[j]<matrix.length && pCurr.y+yArr[j]<matrix[pCurr.x+xArr[j]].length &&
							matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]] != 0 && !visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
						q.add(new Pos4(pCurr.x+xArr[j],pCurr.y+yArr[j]));
						visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]=true;
					}
				}
			}
		}
		return pathExist;
	}
}

class Pos4{
	int x;
	int y;

	public Pos4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
