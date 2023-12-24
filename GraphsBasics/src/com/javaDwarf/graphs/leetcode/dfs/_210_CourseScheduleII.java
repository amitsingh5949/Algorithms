package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _210_CourseScheduleII {
	
	//Using  dfs topological sorting using unexplored, exploring and explored set
    // order in which nodes are added in explored set is the topological order
	
	int[] order=null;
    int currIndex=0;
    boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        order = new int[numCourses];
        createGraph( numCourses, prerequisites);
        
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for( int i=0; i<numCourses; i++){
            if(!hasCycle && !visited.contains(i)){
                dfs(i, visiting, visited);
            }
        }
        
        return hasCycle ? new int[0] : order;
    }
    
    public void dfs(int node , Set<Integer> visiting,Set<Integer> visited  ){
        
        if(hasCycle || visiting.contains(node)){
            hasCycle = true;
            return;
        }
        
        visiting.add(node);
        
        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
        
        for( int i : neighbors){
            if(!visited.contains(i)){
                dfs(i, visiting, visited);
            }
        }
        
        visiting.remove(node);
        visited.add(node);
        order[currIndex++] = node;
        
    }
    
    Map<Integer, List<Integer>> graph;
    public void createGraph(int n, int[][] edges){
        graph = new HashMap<>();
        for(int[] e:edges){
            List<Integer> l = graph.getOrDefault(e[0], new ArrayList<>());
            l.add(e[1]);
            graph.put(e[0],l);
        }
    }

}
