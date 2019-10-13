package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
				bfs(i,visited);
				max++;
			}
		}
		return max;
	}
	
	public void bfs(int vertex,boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		while(!q.isEmpty()) {
			Integer i = q.poll();
			visited[i] = true;
			
			ArrayList<Integer> neighbors = graph[i];
			for(Integer neighbor : neighbors) {
				if(!visited[neighbor]) {
					q.add(neighbor);
				}
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
