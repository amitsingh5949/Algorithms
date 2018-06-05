package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumCostPathBFS { 

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			Pos3 matrix[][] = new Pos3[size][size];
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					matrix[j][k] =  new Pos3(j,k,in.nextInt());
				}
			}
			System.out.println(minCostPath(matrix));
		}
		in.close();
	}
	
	private static int minCostPath(Pos3[][] matrix) {
		return calcCost(matrix[0][0], matrix[matrix.length-1][matrix.length-1], matrix);

	}
	
	private static int calcCost(Pos3 src, Pos3 dest, Pos3[][] matrix) {
		int costMin = 0;
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		Queue<Pos3> q = new LinkedList<>();
		q.add(src);
		src.visited = true;
		

		while(!q.isEmpty()){
			Pos3 pCurr=q.poll();
			
			if(pCurr.x>=0 && pCurr.y>=0 && pCurr.x<matrix.length && pCurr.y<matrix.length){
				pCurr.visited=true;	
			}

			if(pCurr.x==dest.x && pCurr.y==dest.y){
			}

			
			else{
				for(int j=0; j<xArr.length; j++){
					if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
							pCurr.x+xArr[j]<matrix.length && pCurr.y+yArr[j]<matrix.length &&
							!matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]].visited){
						//q.add(new Pos(pCurr.x+xArr[j],pCurr.y+yArr[j]));
						
					}
				}
			}
		}

		return costMin;
	}
}

class Pos3{
	int x;
	int y;
	int cost;
	boolean visited;

	public Pos3(int x, int y,int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		visited = false;
	}
}
