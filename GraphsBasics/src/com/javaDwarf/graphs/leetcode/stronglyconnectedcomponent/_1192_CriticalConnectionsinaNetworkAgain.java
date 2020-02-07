package com.javaDwarf.graphs.leetcode.stronglyconnectedcomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1192_CriticalConnectionsinaNetworkAgain {

	public  Set<List<Integer>> componentList = null;

	public  Set<Integer> articulationPoints = null;
	public  Set<Integer> visited  = null;
	public  int time = 0;


	public  Map<Integer, Integer> visitedTime = null; 
	public  Map<Integer, Integer> lowTime  = null;
	public  Map<Integer, Integer> parent  = null;

	public Set<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		createGraph(n);
		for(List<Integer> l : connections) {
			addEdge(l.get(0), l.get(1));
			addEdge(l.get(1), l.get(0));
		}

		componentList = new HashSet<List<Integer>>();

		articulationPoints = new HashSet<>();
		visited = new HashSet<>();
		time = 0;

		visitedTime = new HashMap<>();
		lowTime = new HashMap<>();
		parent = new HashMap<>();
		
		for(int i=0; i<n;i++) {
			dfs(i);
			visited.clear();
			visitedTime.clear();
			lowTime.clear();
			parent.clear();
			time =0;
		}
		
		System.out.println(articulationPoints);

		return componentList;
	}

	public void dfs(int vertex) {

		visited.add(vertex);
		visitedTime.put(vertex, time);
		lowTime.put(vertex, time);
		time++;

		int children = 0;
		boolean isArticulationPoint = false;

		ArrayList<Integer> neighbours = graph[vertex];

		for(int neighbor : neighbours) {

			if(parent.get(vertex) != null && neighbor == parent.get(vertex)) {
				continue;
			}
			else if(!visited.contains(neighbor)) {
				parent.put(neighbor, vertex);
				children++;
				dfs(neighbor);

				if(visitedTime.get(vertex) <= lowTime.get(neighbor)) {
					isArticulationPoint = true;
					if(parent.get(vertex) != null || (parent.get(vertex) == null && children >= 2)) {
						if(vertex>neighbor) {
							componentList.add(Arrays.asList(neighbor,vertex));
						}
						else {
							componentList.add(Arrays.asList(vertex,neighbor));
						}
					}
				}
				else {
					int currLowTime = Math.min(lowTime.get(vertex), lowTime.get(neighbor));
					lowTime.put(vertex,currLowTime);
				}
			}
			else {
				int currLowTime = Math.min(lowTime.get(vertex), visitedTime.get(neighbor));
				lowTime.put(vertex,currLowTime);
			}
		}

		if((parent.get(vertex) == null && children >= 2) || 
				(parent.get(vertex) != null && isArticulationPoint)) {
			articulationPoints.add(vertex);
		}
	}

	public static void main(String[] args) {
		Integer[][] arr = {{0,1},{1,2},{2,0},{1,3}};

		Integer[][] arr1 = {
				{0, 1},
				{0, 2},
				{0, 3},
				{0, 4},
				{3, 5},
				{4, 6},
				{4, 2},
				{6, 3},
				{6, 7},
				{6, 8},
				{7, 9},
				{9, 10},
				{8, 10}
		};
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for(Integer[] x : arr1) {
			ll.add(Arrays.asList(x));
		}
		System.out.println(new _1192_CriticalConnectionsinaNetworkAgain().criticalConnections(11, ll));
	}



	//** graph creation logic

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
}
