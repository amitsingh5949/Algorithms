	package com.javaDwarf.graphs.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Topological sorting begins using Queue and BFS

public class TopologicalSort {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(findOrder(4, matrix));

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
		
		// till here above code creates the graph and also count the degree(num of parents) of each vertex
		
		// topological sorting begins using Queue and BFS
		  //1. First add  all vertices in queue with 0 degree

		int count = 0;
		int[] order = new int[numOfVertices];
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		 //2. poll queue and decrement the degree count of polled vertex neighbors, neighbor degree is 0 add to queue
		while(!q.isEmpty()) {
			int vertex = q.poll();
			order[count++] = vertex;
			
			ArrayList<Integer> neighbours = graph[vertex];
			
			for(int neighbour : neighbours) {
				degree[neighbour] -= 1;
				if(degree[neighbour]  == 0) {
					q.add(neighbour);
				}
			}
		}
		
		//if(count == numCourses)  that means there is no loop
		
		return order;
	}

}
