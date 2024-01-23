package com.javaDwarf.graphs.leetcode.shortestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _787_CheapestFlightsWithinKStops {
	
	
	
	
	/******************************************************************************************************************************************/
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        createGraph(n,flights);
        Map<Integer, DistanceTable> distanceMap = new HashMap<>();
        distanceMap.put(src, new DistanceTable(src, src, 0, k));
        
        for(int i=0; i<n; i++){
            if(i!=src)  
                distanceMap.put(i, new DistanceTable(i, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE));
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{src, 0,k});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            for(int neighbor : graph.get(curr[0])){
                 int d = distanceMap.get(curr[0]).distance + weights[curr[0]][neighbor];
                if( d < distanceMap.get(neighbor).distance && curr[2] >= 0){
                    distanceMap.put(neighbor, new DistanceTable(neighbor, curr[0], d, curr[2]-1) );
                    pq.add(new int[]{neighbor,d, curr[2]-1});
                }
            }
        }
        
        return distanceMap.get(dst).distance==Integer.MAX_VALUE?-1:distanceMap.get(dst).distance;
        
    }
    
    Map<Integer, List<Integer>> graph;
    int[][] weights;
    public void createGraph(int n, int[][] flights){
        
        graph = new HashMap<>();
        for(int i=0; i<n; i++) 
            graph.put(i, new ArrayList<>());
        weights = new int[n][n];
        
        for( int[] e : flights){
            List<Integer> l = graph.get(e[0]);
            l.add(e[1]);
            weights[e[0]][e[1]] = e[2];
        }
    }
    
    class DistanceTable{
        int node;
        int comingFrom;
        int distance;
        int stops;
        
        public DistanceTable(int node,  int comingFrom, int distance, int stops){
            this.node = node;
            this.comingFrom = comingFrom;
            this.distance = distance;
            this.stops = stops;
        }
    }
	
	/******************************************************************************************************************************************/
	
	
	// DFS Approach : TLE
	  int min = Integer.MAX_VALUE;
	    public int findCheapestPriceBF(int n, int[][] flights, int src, int dst, int k) {
	        createGraph(flights);
	        dfs(src, dst, 0, k, new boolean[n][n]);
	        return min==Integer.MAX_VALUE ? -1 : min;
	    }
	    
	    public void dfs( int s, int d, int cost, int k, boolean[][] visited){
	        if(s == d && k >= -1) {
	            min = Math.min(min, cost);
	            return;
	        }
	        if(k <= -1) return;
	        
	        if(!map.containsKey(s)) return;
	        
	        visited[s][d] = true;
	        
	        for(int[] n : map.get(s)){
	            if(!visited[n[0]][d])
	                dfs(n[0], d, cost+n[1], k-1, visited);
	        } 
	        visited[s][d] = false;
	    }
	    
	    Map<Integer, List<int[]>> map;
	    public void createGraph(int[][] edges){
	    	map = new HashMap<>();
	        for( int[] e : edges){
	            List<int[]> ni = map.getOrDefault(e[0], new ArrayList<>());
	            ni.add(new int[]{e[1],e[2]});
	            map.put(e[0],ni);
	        }
	    }

}
