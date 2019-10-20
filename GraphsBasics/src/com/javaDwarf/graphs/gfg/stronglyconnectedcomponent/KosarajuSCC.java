package com.javaDwarf.graphs.gfg.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuSCC {



	public static ArrayList<Integer>[] graph = null;
	public static int numOfVertices = 0;
	public static void createGraph(int n){
		numOfVertices = n;
		graph = new ArrayList[n];
		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
	}
	public static void addEdge(int src, int dest) {
		graph[src].add(dest);
	}

	public int kosaraju(ArrayList<ArrayList<Integer>> list, int N){
		createGraph(N);
		
		for(int i=0; i<list.size();i++) {
			ArrayList<Integer> neighbors = list.get(i);
			for(int j= 0; j<neighbors.size(); j++) {
				addEdge(i, neighbors.get(j));
			}
		}

		Stack<Integer> finishTime = new Stack<>();
		boolean[] visited = new boolean[N];

		for(int i=0; i<N; i++) {
			if(!visited[i])
				dfs(i,finishTime,visited);
		}

		createGraph(N);
		for(int i=0; i<list.size();i++) {
			ArrayList<Integer> neighbors = list.get(i);
			for(int j= 0; j<neighbors.size(); j++) {
				addEdge( neighbors.get(j),i);
			}
		}

		visited = new boolean[N];

		ArrayList<ArrayList<Integer>> componentList = new ArrayList<ArrayList<Integer>>();

		while(!finishTime.isEmpty()) {
			int x = finishTime.pop();
			if(!visited[x]) {
				ArrayList<Integer> ll = new ArrayList<Integer>();
				ll.add(x);
				componentList.add(dfsReversed(x, visited, ll));
			}
		}

		System.out.println(componentList);

		return componentList.size();
	}

	public void dfs(int vertex,Stack<Integer> finishTime,boolean[] visited) {
		if(visited[vertex]) return;
		visited[vertex] = true;
		ArrayList<Integer> neighbors = graph[vertex];
		for(int neighbor : neighbors) {
			if(!visited[neighbor])
				dfs(neighbor,finishTime,visited);
		}
		finishTime.add(vertex);
	}

	public ArrayList<Integer>  dfsReversed(int vertex,boolean[] visited, ArrayList<Integer> component) {
		if(visited[vertex]) return component;
		visited[vertex] = true;
		ArrayList<Integer> neighbors = graph[vertex];
		for(int neighbor : neighbors) {
			if(!visited[neighbor]) {
				component.add(neighbor);
				component = dfsReversed(neighbor,visited,component);
			}
		}
		return component;
	}
}
