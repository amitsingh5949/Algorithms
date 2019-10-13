package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;

public class _323_NumberofConnectedComponentsinUndirectedGraph {

	public static void main(String[] args) {
		_323_NumberofConnectedComponentsinUndirectedGraph obj = new _323_NumberofConnectedComponentsinUndirectedGraph();
		int[][] a = {{1,0}};
		int x = obj.countComponents(2, a);
		System.out.println(x);

	}

	public int countComponents(int n, int[][] edges) {
		int max = 0; 
		createGraph(n,edges);
		boolean[] visited = new boolean[n];
		for(int i=0; i<n;i++) {
			if(!visited[i]) {
				dfs(i,visited);
				max++;
			}
		}
		return max;
	}

	public void dfs(int vertex,boolean[] visited) {
		visited[vertex] = true;
		ArrayList<Integer> neighbors = graph[vertex];
		for(Integer neighbor : neighbors) {
			if(!visited[neighbor]) {
				dfs(neighbor,visited);
			}
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
			addEdge(edges[i][1], edges[i][0]);
		}
	}

	public static void addEdge(int src, int dest) {
		graph[src].add(dest);
	}


	//////////////////////

}
