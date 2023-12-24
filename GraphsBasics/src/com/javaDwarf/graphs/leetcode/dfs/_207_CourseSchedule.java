package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _207_CourseSchedule {

	public static void main(String[] args) {
	}
	
	
	 /******************************************************************************************************************************************************************/
	//below is time : v(v+e), check from every node can you come back to same node, exponential time( exploring each path starting every node, visiting the node and backtracking)
	
	public boolean canFinishBacktrackingBruteForce(int numCourses, int[][] prerequisites) {
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
    
    /******************************************************************************************************************************************************************/
    //Modification to above solution to bring down complexity from exponential to v(v+e)
    
    public boolean canFinisDFSBruteForce(int numCourses, int[][] prerequisites) {
        boolean ans = true;
        generateGraph(numCourses, prerequisites);
        
        for(int i=0; i<numCourses; i++){
            ans = ans && dfsOptimised(i,i, new HashSet<>());
        }
        return ans;
    }
    
    public boolean dfsOptimised(int start, int curr, Set<Integer> visited){
        List<Integer> neighbors = graph1.getOrDefault(curr, new ArrayList<>());
        boolean ans = true;
        for(int i=0; i<neighbors.size(); i++){
            if(neighbors.get(i) == start) return false;
            if(!visited.contains(neighbors.get(i))){
                visited.add(neighbors.get(i));
                ans = ans && dfsOptimised(start, neighbors.get(i), visited);
            }
        }
        return ans;
    }
    
    /******************************************************************************************************************************************************************/
    
    //Using  dfs topological sorting using unexplored, exploring and explored set
    // order in which nodes are added in explored set is the topological order
    
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
            if(ans && unexplored.contains(i)){ // can also write if(ans && !explored.contains(i)) and get rid of unexplored set all together. Only exploring and explored set needed.
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
	
	// Below two codes are exactly same as first solution. Need to check complexity again, is it 2^v  or some other exponential 
	// interesting thing is , the below two codes will give TLE and first will not, exponential time( exploring each path starting every node , visiting the node and backtracking)
	/*******************************************************************/

	public static boolean result = true;

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		result = true;
		createGraph(numCourses, prerequisites);
		for(int i=0; i<numCourses; i++) {
			hasNoLoop(i,new boolean[numCourses]);// for every course we are creating new visited arr, so new dfs for evry node
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

	 /******************************************************************************************************************************************************************/
	// Code same as above but without use global variable

	 public static boolean canFinishBF(int numCourses, int[][] prerequisites) {
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
