package com.javaDwarf.graphs.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _785_IsGraphBipartite {
	 
	public static void main(String[] args) {

	}
	
/* BFS, Coloring problem (Huangarian Algorithm) */ // same algorithm can be implemented by dfs as well 
	
	//Same as below, instead of using set, using int array to keep track of color of node
	// idea is to color the graph with two colors such that no two adjacent nodes have same color
	
public boolean isBipartiteBFS(int[][] graph) {
        
        int[] arr = new int[graph.length];
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                boolean isValid = bfs(graph, arr, i);
                if(!isValid) return false;
            }
        }
        
        return true;
    }
    
    public boolean bfs(int[][] graph, int[] arr, int index){
       Queue<Integer> q = new LinkedList<>();
        q.add(index);
        arr[index] = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                
                int curr = q.poll();
                for(int neighbor : graph[curr]){
                    
                    if(arr[neighbor] == 0){
                        arr[neighbor] = arr[curr] *-1;
                        q.add(neighbor);
                    }
                    else if(arr[neighbor] == arr[curr]){
                        return false;
                    }
                }                
            } 
        }
        return true; 
    }
	/****************** Method 2 - same as above using set instead of color arr ****/
	
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

	

}
