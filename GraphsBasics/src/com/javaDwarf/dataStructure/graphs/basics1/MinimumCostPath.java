package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.LinkedList;
import java.util.Scanner;

public class MinimumCostPath {

	//private static int[] x = {-1,0,1,-1,1,-1,0,1};
	//private static int[] y = {-1,-1,-1,0,0,1,1,1};
	
	private static int[] x = {0,-1,1,0};
	private static int[] y = {-1,0,0,1};
	
	private static int costMin = Integer.MAX_VALUE; 

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			costMin = Integer.MAX_VALUE; 
			int size = in.nextInt();
			int matrix[][] = new int[size][size];
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					matrix[j][k] =  in.nextInt();
				}
			}
			System.out.println(minCostPath(matrix));
		}
		in.close();

	}
	private static int minCostPath(int[][] matrix) {
		boolean [][] visited = new boolean[matrix.length][matrix.length];
		calcCost(matrix,0,0,0,visited, new LinkedList<>());
		return costMin;
	}

	private static int calcCost(int[][] matrix, int currX, int currY, int cost, boolean[][] visited, LinkedList<Integer> list){
		
		cost += matrix[currX][currY];
		visited[currX][currY] = true;
		list.addLast(matrix[currX][currY]);
		if(currX==matrix.length-1 && currY==matrix.length-1 && cost<costMin){
			costMin = cost;
			//System.out.println(list);
		}
		else{
			for(int i=0; i<x.length; i++){
				int nextX = currX + x[i];
				int nextY = currY + y[i];
				if((nextX >= 0 && nextX < matrix.length) &&(nextY >= 0 && nextY < matrix.length) && 
						!visited[nextX][nextY]){
					calcCost(matrix, nextX, nextY, cost,visited,list);
					list.removeLast();
					visited[nextX][nextY] = false;
				}
			}
		}
		return cost;
	}

}
