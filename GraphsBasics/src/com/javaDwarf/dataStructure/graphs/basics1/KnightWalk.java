package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightWalk {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int rowN = in.nextInt();
			int colN = in.nextInt();
			int srcX = in.nextInt()-1;
			int srcY = in.nextInt()-1;
			int destX = in.nextInt()-1;
			int destY = in.nextInt()-1;

			System.out.println(minNumOfStepsByKnight(new Pos(srcX,srcY),new Pos(destX,destY), rowN, colN));
		}
		in.close();		
	}

	private static int minNumOfStepsByKnight(Pos src, Pos dest, int rowN, int colN) {
		int count = 0;
		boolean found = false;
		int xArr[] = {-2, -1, 1, 2, -2, -1, 1, 2};
		int yArr[] = {-1, -2, -2, -1, 1, 2, 2, 1};
		boolean[][] visited = new boolean[rowN][colN];

		Queue<Pos> q = new LinkedList<>();
		q.add(src);
		Pos dummyPos = new Pos(-1,-1);
		q.add(dummyPos);

		while(q.size() != 1){

			Pos pCurr = q.poll();
			if(pCurr.x>=0 && pCurr.y>=0 && pCurr.x<rowN && pCurr.y<colN){
				visited[pCurr.x][pCurr.y]=true;	
			}

			if(pCurr.x==dest.x && pCurr.y==dest.y){
				found =true;
				return count;
			}

			if(pCurr.x==-1 && pCurr.y==-1){
				count++;
				q.add(dummyPos);
			}
			else{
				for(int j=0; j<xArr.length; j++){
					if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
							pCurr.x+xArr[j]<rowN && pCurr.y+yArr[j]<colN &&
							!visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
						q.add(new Pos(pCurr.x+xArr[j],pCurr.y+yArr[j]));
					}
				}
			}
		}
		if(found)
			return count;
		else
			return -1;
	}
}

class Pos{
	int x;
	int y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}