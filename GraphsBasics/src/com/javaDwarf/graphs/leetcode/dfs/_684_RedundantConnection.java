package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

public class _684_RedundantConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Cycle detection logic. Using DFS approach 
	// same as what we used in directed graph using dfs
	// start dfs from each node and see if you come back to the a node which is already visited using a visited set.
	// Only difference is that we pass parent node to the dfs function so while exploring neighbors of curr node, dfs should not visit parent as neighbor.
	
	
	//o(v*(v+e)) time
	int loc = Integer.MIN_VALUE;
    int[] res;
    
    public int[] findRedundantConnection(int[][] edges) {
        createGraph(edges);
        for(int i=0; i<graph.size(); i++)
            dfs(i,-1, new HashSet<>());
        return res;
    }
    
    public void dfs(int node, int parent, Set<Integer> visited){
        if(visited.contains(node)) {
            Pair<Integer, Integer> p = new Pair<>(parent, node);
            if(pos.get(p) !=null && pos.get(p) > loc){
                loc = pos.get(p);
                res = new int[]{parent, node};
            }
            return;
        }
        
        visited.add(node);
        for( int i : graph.getOrDefault(node, new ArrayList<>())){
            if( i != parent) 
               dfs(i, node, visited);
        }
    }
    
    Map<Integer, List<Integer>>graph;
    Map<Pair<Integer, Integer>, Integer> pos;
    
    public void createGraph(int[][] edges){
        
        graph= new HashMap<>();
        pos = new HashMap<>();
        int i=0;
        
        for(int[] e : edges){
            
            pos.put(new Pair<>(e[0],e[1]),i++);
            
            List<Integer> l =  graph.getOrDefault(e[0], new ArrayList<>());
            l.add(e[1]);
            graph.put(e[0],l);
            
            List<Integer> l1 =  graph.getOrDefault(e[1], new ArrayList<>());
            l1.add(e[0]);
            graph.put(e[1],l1);
        }
    }

}
