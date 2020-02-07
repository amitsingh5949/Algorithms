package com.javaDwarf.graphs.leetcode.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//works only with directed graph 
public class KosarajuSCC {
	
	public static void main(String[] args) {
		Integer[][] edges = {{1, 0},{ 0, 2}, {2, 1}, {0, 3},{ 3, 4}};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(Integer[] arr : edges) {
			list.add(Arrays.asList(arr));
		}
		
		System.out.println(new KosarajuSCC().kosaraju(list, 5));
		
	}

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

	public int kosaraju(List<List<Integer>> list, int N){
		createGraph(N);
		for(List<Integer> l : list) {
			addEdge(l.get(0), l.get(1));	
		}

		Stack<Integer> finishTime = new Stack<>();
		boolean[] visited = new boolean[N];

		for(int i=0; i<N; i++) {
			if(!visited[i])
				dfs(i,finishTime,visited);
		}

		createGraph(N);
		for(List<Integer> l : list) {
			addEdge(l.get(1),l.get(0));	
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
