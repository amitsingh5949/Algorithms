package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class _417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		//int[][] matrix  = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] matrix  = {{1,2},{4,3}};
		System.out.println(new _417_PacificAtlanticWaterFlow().pacificAtlantic(matrix));

	}


	//Optimal Approach is to run BFS two times
	// 1. start BFS from all Atlantic cells and mark other cell true in Atlantic visited array which are reachable by Atlantic cells
	// 2. start BFS from all pacific cells and mark other cell true in pacific visited array which are reachable by pacific cells
	// take intersection of both true cells 


	List<List<Integer>> res;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        res = new ArrayList<>();
        
        Queue<Pair<Integer, Integer>> pq = new LinkedList<>();
        Queue<Pair<Integer, Integer>> aq = new LinkedList<>();
        boolean[][] pv = new boolean[heights.length][heights[0].length];
        boolean[][] av = new boolean[heights.length][heights[0].length];
        
        
        for(int i=0;i<heights[0].length;i++){
            pq.add(new Pair<>(0,i));
            pv[0][i] = true;
            aq.add(new Pair<>(heights.length-1,i));
            av[heights.length-1][i] = true;
        }
        
        for(int i=0;i<heights.length;i++){
            pq.add(new Pair<>(i,0));
            pv[i][0] = true;
            aq.add(new Pair<>(i, heights[0].length-1));
            av[i][heights[0].length-1] = true;
        }
        
        bfs(heights,pq,pv);
        bfs(heights,aq,av);
        
        for( int i=0;i<heights.length; i++){
            for( int j=0;j<heights[0].length; j++){
                if(pv[i][j] && av[i][j])
                    res.add(Arrays.stream(new int[]{i,j}).boxed().collect(Collectors.toList()));
            }
        }
        
        return res;
    }
    
    public void bfs(int[][] heights, Queue<Pair<Integer, Integer>> pq , boolean[][] pv){
        int[] xd = {-1,1,0,0};
        int[] yd = {0,0,-1,1};
        
        while(!pq.isEmpty()){
            int size = pq.size();
            for( int i=0; i<size; i++){
                Pair<Integer,Integer> curr = pq.poll();
                for(int k=0; k<xd.length; k++){
                    int xn = curr.getKey() + xd[k];
                    int yn = curr.getValue() + yd[k];
                    if(xn>=0 && xn<heights.length && yn >=0 && yn< heights[0].length && !pv[xn][yn] && heights[xn][yn] >= heights[curr.getKey()][curr.getValue()]){
                        pq.add(new Pair<>(xn, yn));
                        pv[xn][yn] = true;
                    }
                }
            }
        }
    }

}

