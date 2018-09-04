package com.javaDwarf.dataStructure.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RobotMove {

	public static int min = 0;
	public static boolean found = false;

	public static void main(String[] args) {
		List<List<Integer>>  l = new ArrayList<>();

		List<Integer>  l1 = new ArrayList<>();
		l1.add(1);
		l1.add(0);
		l1.add(0);
		l.add(l1);

		List<Integer>  l2 = new ArrayList<>();
		l2.add(1);
		l2.add(0);
		l2.add(0);
		l.add(l2);

		List<Integer>  l3 = new ArrayList<>();
		l3.add(1);
		l3.add(9);
		l3.add(1);
		l.add(l3);
		System.out.println(removeObstacle(3, 3, l));
	}

	public static  int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){
		int[][] matrix = new int[numRows][numColumns];

		for(int i=0; i<numRows; i++) {
			List<Integer> l = lot.get(i);
			for(int j=0; j<numColumns; j++) {
				matrix[i][j] = l.get(j);
			}
		}
		removeObstacle(new Pos14(0,0),numRows, numColumns, matrix);

		if(matrix[0][0] == 0)
			return -1;
		if(found)
			return min;
		else 
			return -1;
	}

	public static  void removeObstacle(Pos14 src, int numRows, int numColumns, int[][]matrix){

		boolean[][] visited = new boolean[numRows][numColumns];
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};	

		Queue<Pos14> q = new LinkedList<>();
		q.add(src);
		q.add(null);
		visited[src.x][src.y]=true;

		while(q.size() == 1){

			Pos14 pCurr = q.poll();

			if(pCurr == null) {
				min++;
				q.add(null);
				continue;

			}

			if(matrix[pCurr.x][pCurr.y]==9){
				found = true;
				break;
			}
			else{
				for(int j=0; j<xArr.length; j++){

					if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
							pCurr.x+xArr[j]<numRows && pCurr.y+yArr[j]<numColumns &&
							matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]] != 0 && 
							!visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
						q.add(new Pos14(pCurr.x+xArr[j],pCurr.y+yArr[j]));
						visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]=true;
					}
				}
			}
		}
	}
}

class Pos14{
	int x;
	int y;

	public Pos14(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
