package com.javaDwarf.graphs.leetcode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _785_IsGraphBipartite {

	public static void main(String[] args){
		int[][] arr1 = {{1,3}, {0,2}, {1,3}, {0,2}};
		int[][] arr2 = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
		
		int[][] arr3 = {{}};
		int[][] arr4 = {{1,2,3},{0},{0},{0}};
		
		int[][] arr5  =  {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
		
		int[][] arr6 = {{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},
				{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},
				{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
		
		//System.out.println(isBipartite(arr3 ));
		System.out.println(isBipartite(arr6));
	}

	public static boolean isBipartite(int[][] graph) {
		
		if(graph==null || graph.length == 0) return false;

		boolean result = true;

		int[][] weightMatrix = new int[graph.length][graph.length];

		for(int i =0; i<graph.length; i++) {
			for(int j =0; j<graph[i].length; j++) {
				int dest = graph[i][j];
				weightMatrix[i][dest] = 1;
				weightMatrix[dest][i] = 1;
			}
		}

		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();

		Queue<Integer> q1 = new LinkedList<>(); 
		Queue<Integer> q2 = new LinkedList<>();

		for(int i =0 ; i< graph.length; i++) {
			if(graph[i].length > 0) {
				q1.add(i);
				break;
			}
		}
		

		while(!q1.isEmpty() || !q2.isEmpty()) {
			if(!q1.isEmpty()) {
				int curr = q1.poll();
				if(!s1.contains(curr)) {
					for(int k : s1) {
						if(weightMatrix[curr][k] != 0) {
							return false;
						}
					}
					int[] neighbour = graph[curr];
					s1.add(curr);
					for(int k : neighbour) {
						q2.add(k);
					}
				}
			}
			else if(!q2.isEmpty()) {
				int curr = q2.poll();
				if(!s2.contains(curr)) {
					for(int k : s2) {
						if(weightMatrix[curr][k] != 0) {
							return false;
						}
					}
					int[] neighbour = graph[curr];
					s2.add(curr);
					for(int k : neighbour) {
						q1.add(k);
					}
				}

			}
		}
		return result;

	}

}
