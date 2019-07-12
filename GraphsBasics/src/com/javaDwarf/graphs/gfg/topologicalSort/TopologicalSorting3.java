package com.javaDwarf.graphs.gfg.topologicalSort;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSorting3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();

		for(int i=0; i<numOfTestCases; i++){
			int numOfVertecies = in.nextInt();
			GraphImpl4 g = new GraphImpl4(numOfVertecies);
			int numOfEdges = in.nextInt();
			for(int j=0; j<numOfEdges; j++){
				g.addEdge(in.nextInt(), in.nextInt());
			}
			g.topoSort(g.vertextList,g.numOfVertecies);
		}
		in.close();
	}

}

class GraphImpl4 {

	ArrayList<Integer>[] vertextList;
	int numOfVertecies;

	public GraphImpl4(int size) {
		vertextList = new ArrayList[size];
		numOfVertecies =size;
		for(int i=0; i<size; i++){
			vertextList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int src, int neighbhour){
		vertextList[src].add(neighbhour);
	}

	public int[] topoSort(ArrayList<Integer> graph[],int N){
		int[] sortedArr = new int[N];
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[N];
		for(int i=0; i<N; i++){
			dfs(i,s,visited,graph);
		}
		int count =0;
		while(!s.isEmpty()){
			sortedArr[count++] = s.pop();
		}
		return sortedArr;
	}

	private void dfs(int i, Stack<Integer> s,boolean[] visited, ArrayList<Integer> graph[]) {
		if(!visited[i]){
			visited[i] = true;
			ArrayList<Integer> list = graph[i];
			for(Integer x : list){
				if(!visited[x]){
					dfs(x,s,visited,graph);
				}
			}
			s.push(i);
		}
	}

}




