package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class _733_FloodFill {

	public static void main(String[] args) {

	}
	
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int original = image[sr][sc];
        int[] xArr = {-1,1,0,0};
        int[] yArr = {0,0,-1,1};
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(sr,sc));
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.poll();
            sr = curr.getKey();
            sc = curr.getValue();
            image[sr][sc] = color;
            for(int i=0; i<xArr.length; i++){
                int newX = sr + xArr[i];
                int newY = sc + yArr[i];
                if( newX>=0 && newX<image.length && newY>=0 && newY<image[0].length 
                   && image[newX][newY] == original){
                    q.add( new Pair<>(newX, newY));
                }
            }
        }
        
        return image;
    }

}
