package com.javaDwarf.dataStructure.graphs.basics1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PossiblePathsInKEdges {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			GraphImpl4 graph = new GraphImpl4(size);
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					int temp = in.nextInt();
					if(temp == 1){
						graph.addEdge(j, k);
					}
				}
			}
			int src = in.nextInt();
			int dest = in.nextInt();
			int allowedEdge = in.nextInt();
			
			System.out.println();
			graph.printGraph();
			System.out.println();
			System.out.println(graph.possiblePathCount(src, dest, allowedEdge));
		}
		in.close();
	}
}


class GraphImpl4{
	int numOfVerticies;
	List<Integer>[] g=null;

	public GraphImpl4(int numOfVerticies){
		this.numOfVerticies=numOfVerticies;
		g = new List[numOfVerticies];
		for(int i=0; i<numOfVerticies; i++){
			g[i]=new ArrayList<>();
		}
	}

	public void addEdge(int src, int dest){
		g[src].add(dest);
	}

	public int possiblePathCount(int src, int dest, int allowedEdge){
		int count = 0;
		boolean[] visited = new boolean[numOfVerticies];
		count = dfs(src, dest, allowedEdge,0,0,visited);
		return count;
	}

	private int dfs(int src, int dest, int allowedEdge, int currentCount,int edgeTraversed,boolean[] visited) {
		visited[src] = true;
		if(edgeTraversed>allowedEdge){ 
			return currentCount;
		}
		if(src == dest && edgeTraversed == allowedEdge ){
			return ++currentCount;
		}
		List<Integer> neighbhour = g[src];
		for(int temp : neighbhour){
			if(!visited[temp]){
				edgeTraversed = edgeTraversed + 1;
				currentCount = dfs(temp,dest,allowedEdge,currentCount,edgeTraversed,visited);
				edgeTraversed = edgeTraversed - 1;
				visited[temp] = false;
			}
		}
		return currentCount;
	}
	public void printGraph(){
		for(int i=0; i<g.length; i++){
			System.out.print("Vertex " + i +" neighbhour -> " );
			for(Integer temp : g[i]){
				System.out.print(temp + " ");
			}
			System.out.println();
		}
	}
}

/*
1
5
0 0 0 0 1 1 1 1 1 1 1 0 1 0 1 0 0 1 0 0 1 0 0 1 1
2 4 2*/