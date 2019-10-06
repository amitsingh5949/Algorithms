package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		//int[][] matrix  = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		//int[][] matrix  = {{0,1},{0,2},{1,2}};
		int[][] matrix  = {{0,1},{1,0}};
		System.out.println(canFinish(2, matrix));
	}

	public static boolean result = true;

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		result = true;
		createGraph(numCourses, prerequisites);
		for(int i=0; i<numCourses; i++) {
			hasNoLoop(i,new boolean[numCourses]);
			if(!result) break;
		}
		return result;
	}


	public static void hasNoLoop(int currVertex, boolean[] visited){
		if(visited[currVertex]) {
			result = false;
			return;
		}
		ArrayList<Integer> neighbours = graph[currVertex];
		for(int neighbour : neighbours) {
			visited[currVertex] = true;
			hasNoLoop(neighbour,visited);
			visited[currVertex] = false;
			if(!result) break;
		}
	}

	/*
	 Code same as above but without use global variable

	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
		createGraph(numCourses, prerequisites);
		boolean res = true;
		for(int i=0; i<numCourses; i++) {
			res =  hasNoLoop(i,new boolean[numCourses],true);
			if(!res) break;
		}
		return res;
	}


	public static boolean hasNoLoop(int currVertex, boolean[] visited, boolean res){
		if(visited[currVertex]) {
			return false;
		}

		ArrayList<Integer> neighbours = graph[currVertex];
		for(int neighbour : neighbours) {
			visited[currVertex] = true;
			res = res && hasNoLoop(neighbour,visited, res);
			visited[currVertex] = false;
			if(!res) break;
		}
		return res;
	}
	 */




	////// creation of graph - copy paste at top wherever needed ////////////

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
