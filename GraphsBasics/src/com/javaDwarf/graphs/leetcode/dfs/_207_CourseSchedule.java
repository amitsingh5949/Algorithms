package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _207_CourseSchedule {

	public static void main(String[] args) {
		//int[][] matrix  = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		//int[][] matrix  = {{0,1},{0,2},{1,2}};
		int[][] matrix  = {{0,1},{1,0}};
		System.out.println(canFinish(2, matrix));
	}
	
	//below is time : v(v+e), check from every node can you come back to same node
	
	public boolean canFinishBruteForse(int numCourses, int[][] prerequisites) {
        boolean ans = true;
        generateGraph(numCourses, prerequisites);
        
        for(int i=0; i<numCourses; i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            ans = ans && dfs(i,i, visited);
            visited.remove(visited.size()-1);
        }
        return ans;
    }
    
    public boolean dfs(int start, int curr, Set<Integer> visited){
        List<Integer> neighbors = graph1.getOrDefault(curr, new ArrayList<>());
        boolean ans = true;
        for(int i=0; i<neighbors.size(); i++){
            if(neighbors.get(i) == start) return false;
            if(!visited.contains(neighbors.get(i))){
                visited.add(neighbors.get(i));
                ans = ans && dfs(start, neighbors.get(i), visited);
                visited.remove(visited.size()-1);
            }
        }
        return ans;
    }
    
    Map<Integer, List<Integer>> graph1;
    
    public void generateGraph(int numCourses, int[][] prerequisites){
    	graph1 = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            List<Integer> neighbors = graph1.getOrDefault(prerequisite[0], new ArrayList<>());
            neighbors.add(prerequisite[1]);
            graph1.put(prerequisite[0], neighbors);
        }
    }
    
    //Using  dfs topological sorting using unexplored, exploring and explored set
    
public boolean canFinishDFSToplogicalSort(int numCourses, int[][] prerequisites) {
        
        createGraph(numCourses, prerequisites);
        
        Set<Integer> unexplored = new HashSet<>();
        Set<Integer> exploring = new HashSet<>();
        Set<Integer> explored = new HashSet<>();
        
        for(int i=0; i<numCourses; i++){
            unexplored.add(i);            
        }
        
        boolean ans = true;
        for(int i=0; i<numCourses; i++){
            if(unexplored.contains(i)){
                ans = ans && dfs(i, unexplored, exploring, explored);
            }
        }
        return ans;
    }
    
    public boolean dfs(int curr, Set<Integer> unexplored, Set<Integer> exploring, Set<Integer> explored){
        if(exploring.contains(curr)) return false;
        
        unexplored.remove(curr);
        exploring.add(curr);
        
        boolean ans = true;
        List<Integer> neighbors = graph1.getOrDefault(curr, new ArrayList<>());
        for(int i=0; i<neighbors.size(); i++){
            if(!explored.contains(neighbors.get(i))){
                ans = ans && dfs(neighbors.get(i), unexplored, exploring, explored);
            }
        }
        exploring.remove(curr);
        explored.add(curr);
        return ans;
    }
	
	
	// the below code will give TLE if comment line if(!result) break; 
	/*******************************************************************/

	public static boolean result = true;

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		result = true;
		createGraph(numCourses, prerequisites);
		for(int i=0; i<numCourses; i++) {
			hasNoLoop(i,new boolean[numCourses]);
			if(!result) break;
		}
		return result;
	}


	public static void hasNoLoop(int currVertex, boolean[] visited){
		if(visited[currVertex]) {
			result = false;
			return;
		}
		ArrayList<Integer> neighbours = graph[currVertex];
		for(int neighbour : neighbours) {
			visited[currVertex] = true;
			hasNoLoop(neighbour,visited);
			visited[currVertex] = false;
			if(!result) break;
		}
	}

	/*
	 Code same as above but without use global variable

	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
		createGraph(numCourses, prerequisites);
		boolean res = true;
		for(int i=0; i<numCourses; i++) {
			res =  hasNoLoop(i,new boolean[numCourses],true);
			if(!res) break;
		}
		return res;
	}


	public static boolean hasNoLoop(int currVertex, boolean[] visited, boolean res){
		if(visited[currVertex]) {
			return false;
		}

		ArrayList<Integer> neighbours = graph[currVertex];
		for(int neighbour : neighbours) {
			visited[currVertex] = true;
			res = res && hasNoLoop(neighbour,visited, res);
			visited[currVertex] = false;
			if(!res) break;
		}
		return res;
	}
	 */




	////// creation of graph - copy paste at top wherever needed ////////////

	public static ArrayList<Integer>[] graph = null;
	public static int numOfVertices=0;

	public static void createGraph(int n){
		numOfVertices = n;
		graph = new ArrayList[n];
		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
	}

	public static void createGraph(int n, int[][] edges){ // edges may not necessarily be int matrix , it could be List<Pairpoint> or List<String> (comma or space separated src,dest  ), so change accordingly
		numOfVertices = n;
		graph = new ArrayList[n];

		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<edges.length; i++) {
			addEdge(edges[i][0], edges[i][1]);
		}
	}

	public static void addEdge(int src, int dest) {
		graph[src].add(dest);
	}


	//////////////////////

}
