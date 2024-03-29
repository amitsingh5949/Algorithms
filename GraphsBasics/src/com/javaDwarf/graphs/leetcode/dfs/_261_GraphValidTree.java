package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _261_GraphValidTree {

	public static void main(String[] args) {

	}
	// Logic For undirected graph to have cycle : 
	//The idea is to check for back edges. If while doing DFS, 
	//a back edge is encountered(an edge leading from the current node to some of it's ancestor node except it's parent), return true else false.
	
	// Logic For Undirected graph to connected :
	// one DFS pass will visit all vertices, that is visited set should have all the vertices.
	
	public boolean validTree(int n, int[][] edges) {
		createGraph(n, edges);
		Set<Integer> visited = new HashSet<>();
		boolean res = dfs(0,-1, visited);// check for cycle
		return  res && visited.size() == n;// and check for graph to be connected(not a forest) 
	}

	public boolean dfs(int node, int parent, Set<Integer> visited){
		if(visited.contains(node)) return false;
		visited.add(node);
		boolean res = true;
		for( int i : graph.getOrDefault(node, new ArrayList<>()))
			if(i != parent) res = res && dfs(i, node, visited);
		return res;
	}

	Map<Integer, List<Integer>> graph;
	public void createGraph(int n, int[][] edges){
		graph = new HashMap<>();
		for( int[] e : edges){
			List<Integer> l = graph.getOrDefault(e[0], new ArrayList<>());
			l.add(e[1]);
			graph.put(e[0], l);
			List<Integer> l1 = graph.getOrDefault(e[1], new ArrayList<>());
			l1.add(e[0]);
			graph.put(e[1], l1);
		}
	}



}
