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

public class _261_GraphValidTree {

	public static void main(String[] args) {

	}
	// Logic For undirected graph to have cycle : 
	//The idea is to check for back edges. If while doing BFS, 
	//a back edge is encountered(an edge leading from the current node to some of it's ancestor node except it's parent), return true else false.

	// Logic For Undirected graph to connected :
	// one BFS pass will visit all vertices, that is visited set should have all the vertices.

	public boolean validTree(int n, int[][] edges) {

		createGraph(n, edges);
		
		Set<Integer> visited = new HashSet<>();
		Queue<Pair<Integer, Integer>> q = new LinkedList<>();
		q.add(new Pair<>(0, -1));

		while(!q.isEmpty()){

			Pair<Integer, Integer> curr = q.poll();

			if(visited.contains(curr.getKey())) return false;
			visited.add(curr.getKey());

			for( int i : graph.getOrDefault(curr.getKey(), new ArrayList<>()))
				if(i != curr.getValue()) 
					q.add(new Pair<>(i,curr.getKey()));
		}

		return visited.size() == n;
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
