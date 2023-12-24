package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		
		Map<Pair<Integer,Integer>, Integer> map = new HashMap<>();
		map.put(new Pair<>(1,2), 2);
		System.out.println(map.get(new Pair<>(1,2)));
		
		
	}

	// if there is topological order in the graph then no cycle

	public boolean canFinishBFSTopological(int numCourses, int[][] prerequisites) {
		generateGraph(numCourses, prerequisites);
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> s = new HashSet<>();


		for(int i=0; i< numCourses; i++){
			if(indegree[i] == 0){
				s.add(i);
				q.add(i);
			}
		}

		while(!q.isEmpty()){
			int curr = q.poll();
			numCourses--;

			List<Integer> neighbors = graph1.getOrDefault(curr, new ArrayList<>());

			for(int i=0; i< neighbors.size(); i++){
				int neighbor = neighbors.get(i);
				indegree[neighbor] -=1;
				if(indegree[neighbor] ==0){
					q.add(neighbor);
				}
			}
		}
		return numCourses==0;
	}

	Map<Integer, List<Integer>> graph1;
	int[] indegree;

	public void generateGraph(int numCourses, int[][] prerequisites){
		graph1 = new HashMap<>();
		indegree = new int[numCourses];
		for(int[] prerequisite : prerequisites){
			List<Integer> neighbors = graph1.getOrDefault(prerequisite[0], new ArrayList<>());
			neighbors.add(prerequisite[1]);
			graph1.put(prerequisite[0], neighbors);
			indegree[prerequisite[1]] += 1;
		}
	}

	//Brute force approach -- v(v+e) time
	// For Every node, run bfs and check if we can come back to same node
	public boolean canFinishBFSBruteForce(int numCourses, int[][] prerequisites) {
		createGraph(numCourses, prerequisites);
		boolean res = true;
		for(int i=0; i< numCourses; i++){
			res = res && bfs(i,new boolean[numCourses]);
		}
		return res;
	}

	public boolean bfs(int node, boolean[] visited){

		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node] = true;

		while(!q.isEmpty()){
			int curr = q.poll();
			for(int i : graph.getOrDefault(curr, new ArrayList<>())){
				if(i == node) return false;
				if(!visited[i]){
					visited[i] = true;
					q.add(i);
				}
			}
		}

		return true;
	}

	Map<Integer, List<Integer>> graph;
	public void createGraph(int n , int[][] edges){
		graph = new HashMap<>();
		for(int[] e: edges){
			List<Integer> l = graph.getOrDefault(e[0],  new ArrayList<>());
			l.add(e[1]);graph.put(e[0],l);
		}
	}

}


;
