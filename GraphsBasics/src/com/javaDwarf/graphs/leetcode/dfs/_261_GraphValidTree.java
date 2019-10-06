package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;

public class _261_GraphValidTree {

	public static void main(String[] args) {

	}
	
	public boolean result = true;
	public boolean validTree(int n, int[][] edges) {
		result = true;
		createGraph(n, edges);
		for(int i=0; i<n; i++) {
			dfs(i,new boolean[n]);
			if(!result) break;
		}
		return result;

	}
	
	public void dfs(int vertex, boolean[] visited) {
		if(visited[vertex]) {
			result = false;
			return;
		}
		visited[vertex] = true;
		ArrayList<Integer> neighbors = graph[vertex];
		for(Integer neighbor : neighbors) {
			dfs(neighbor, visited);
			if(!result) break;
		}
	}
	
//////creation of graph - copy paste at top wherever needed ////////////

	public static ArrayList<Integer>[] graph = null;
	public static int numOfVertices=0;

	public static void createGraph(int n){
		numOfVertices = n;
		graph = new ArrayList[n];
		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
	}

	public static void createGraph(int n, int[][] edges){ // edges may not necessarily be int matrix , it could be List<Pairpoint> or List<String> (comma or space separated src,dest  ), so change accordingly
		numOfVertices = n;
		graph = new ArrayList[n];

		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<edges.length; i++) {
			addEdge(edges[i][0], edges[i][1]);
		}
	}

	public static void addEdge(int src, int dest) {
		graph[src].add(dest);
	}


	//////////////////////

}
