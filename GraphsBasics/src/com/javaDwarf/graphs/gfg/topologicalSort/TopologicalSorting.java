package com.javaDwarf.graphs.gfg.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			int numOfVertecies = in.nextInt();
			GraphImpl1 g = new GraphImpl1(numOfVertecies);
			int numOfEdges = in.nextInt();
			for(int j=0; j<numOfEdges; j++){
				g.addEdge(in.nextInt(), in.nextInt());
			}
			Integer[] sortedArr = g.topologicalSort();
			for(int temp : sortedArr)
				System.out.print(temp + " ");
		}
		in.close();
	}
}

class GraphImpl1 {
	static LinkedList<Integer>[] vertextList;
	int numOfVertecies;
	static int[] dependentCount=null;

	public GraphImpl1(int size) {
		vertextList = new LinkedList[size];
		numOfVertecies =size;
		dependentCount = new int[size];
		for(int i=0; i<size; i++){
			vertextList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int neighbhour){
		vertextList[src].addFirst(neighbhour);
		dependentCount[neighbhour] = dependentCount[neighbhour] + 1 ;
	}

	public Integer[] topologicalSort(){
		List<Integer> topoSortList = new ArrayList<>();
		boolean[] visited = new boolean[numOfVertecies];
		for(int i=0 ; i<dependentCount.length; i++){
			dfs(i,visited,topoSortList);
		}
		return topoSortList.toArray(new Integer[0]);
	}

	private static void dfs(int src, boolean[] visited, List<Integer> topoSortList ){
		if(dependentCount[src]==0 && !visited[src]){
			topoSortList.add(src);
			visited[src] =true;
		}
		List<Integer> neighbhour = vertextList[src];
		for(int temp : neighbhour){
			if(dependentCount[src]==0 && !visited[temp]){
					dependentCount[temp] = dependentCount[temp] - 1;
			}
			dfs(temp,visited,topoSortList);
		}
	}
}



