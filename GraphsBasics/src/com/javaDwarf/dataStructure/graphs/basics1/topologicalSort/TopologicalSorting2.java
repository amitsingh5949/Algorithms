package com.javaDwarf.dataStructure.graphs.basics1.topologicalSort;

import java.util.ArrayList;
import java.util.Scanner;

public class TopologicalSorting2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int numOfVertecies = in.nextInt();
			GraphImpl2 g = new GraphImpl2(numOfVertecies);
			int numOfEdges = in.nextInt();
			for(int j=0; j<numOfEdges; j++){
				g.addEdge(in.nextInt(), in.nextInt());
			}
			int[] sortedArr = topoSort(g.vertextList, numOfVertecies);
			for(int temp : sortedArr)
				System.out.print(temp + " ");
		}
		in.close();
	}

	public static int[] topoSort(ArrayList<Integer> graph[],int N)
	{
		int[] sortOrder = new int[N];
		int sortCount = 0 ;
		boolean[] visited = new boolean[N];

		int[] dependentCount = getDependentCount(graph, N);

		boolean isGraphSorted = false;
		while(!isGraphSorted){
			isGraphSorted = true;
			for(int i=0 ; i<dependentCount.length; i++){
				if(dependentCount[i]==0 ){
					if( !visited[i]){
						sortOrder[sortCount++] = i;
						visited[i] = true;
						ArrayList<Integer> neighbourList = graph[i];
						for(int temp : neighbourList){
							if(dependentCount[temp]>0){
								dependentCount[temp] = dependentCount[temp] - 1;
							}
						}
					}
				}
				else{
					isGraphSorted = false;
				}
			}
		}
		return sortOrder;
	}

	private static int[] getDependentCount(ArrayList<Integer>[] graph, int n) {
		int[] dependentCount = new int[n];
		for(int i=0;i<graph.length;i++){
			ArrayList<Integer> list = graph[i];
			for(int j=0;j<list.size();j++){
				dependentCount[list.get(j)] = dependentCount[list.get(j)] + 1 ;
			}
		}
		return dependentCount;
	}

}

class GraphImpl2 {

	ArrayList<Integer>[] vertextList;
	int numOfVertecies;

	public GraphImpl2(int size) {
		vertextList = new ArrayList[size];
		numOfVertecies =size;
		for(int i=0; i<size; i++){
			vertextList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int src, int neighbhour){
		vertextList[src].add(neighbhour);
	}

}




