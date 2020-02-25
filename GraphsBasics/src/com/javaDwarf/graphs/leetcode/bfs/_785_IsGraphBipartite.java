package com.javaDwarf.graphs.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _785_IsGraphBipartite {
	 
	public static void main(String[] args) {

	}
	
	Set<Integer> set1 = null;
	Set<Integer> set2 = null;
	Set<Integer> visited = null;

	public boolean isBipartite(int[][] graph) {
		
		set1 = new HashSet<>();
		set2 = new HashSet<>();
		visited = new HashSet<>();
		
		for(int i=0;i<graph.length; i++) {
			if(!visited.contains(i)) {
				if(!bfs(graph, i)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean bfs(int[][] graph, int node) {

		Queue<Integer> q = new LinkedList<>();
		q.add(node);


		while(!q.isEmpty()) {
			int curr = q.poll();
			visited.add(curr);

			Set<Integer> parentSet = set1.contains(curr)? set1 : set2;
			Set<Integer> neighborsSet = parentSet==set1 ? set2 : set1;

			int[] neighbors = graph[curr];

			for(int neighbor : neighbors) {
				if(!visited.contains(neighbor)) {
					if(parentSet.contains(neighbor)) {
						return false;
					}
					neighborsSet.add(neighbor);
					q.add(neighbor);
				}
			}
		}
		return true;
	}

	/* DFS, Coloring problem (Huangarian Algorithm) */

}
