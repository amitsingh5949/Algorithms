package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		//int[][] matrix  = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		//int[][] matrix  = {{0,1},{0,2},{1,2}};
		int[][] matrix  = {{0,1},{1,0}};
		System.out.println(canFinish(2, matrix));
	}

//wrong logic -- 
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean result = true;
		createGraph(numCourses, prerequisites);
		for(int i=0; i<numCourses; i++) {
			result = hasNoLoopBFS(i,new boolean[numCourses]);
			if(!result) break;
		}
		return result;
	}

	private static boolean hasNoLoopBFS(int i, boolean[] visited) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);

		int count = 0;
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			if(count>numOfVertices) {
				return false;
			}
			else {
				count++;
			}
			List<Integer> neighbours = graph[curr];
			for(Integer neighbour : neighbours ) {
				q.add(neighbour);
			}
		}

		return true;
	}

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
