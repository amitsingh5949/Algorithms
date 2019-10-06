package com.javaDwarf.graphs.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _210_CourseScheduleII {

	public static void main(String[] args) {
		
		//int[][] matrix = {{1,0},{2,0},{3,1},{3,2}};
		int[][] matrix = {{1,0}};
		System.out.println(findOrder(2, matrix));

	}

	public static  int[] findOrder(int numCourses, int[][] prerequisites) {

		ArrayList<Integer>[] graph = null;
		int  numOfVertices=0;
		int[] degree = new int[numCourses];

		numOfVertices = numCourses;
		graph = new ArrayList[numOfVertices];

		for(int i=0; i<numOfVertices;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<prerequisites.length; i++) {
			degree[prerequisites[i][1]] += 1;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		int count = numCourses-1;
		int[] order = new int[numOfVertices];
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int vertex = q.poll();
			order[count--] = vertex;
			
			ArrayList<Integer> neighbours = graph[vertex];
			
			for(int neighbour : neighbours) {
				degree[neighbour] -= 1;
				if(degree[neighbour]  == 0) {
					q.add(neighbour);
				}
			}
		}
		
		if(count !=0) return new int[0];
		return order;
	}

}
