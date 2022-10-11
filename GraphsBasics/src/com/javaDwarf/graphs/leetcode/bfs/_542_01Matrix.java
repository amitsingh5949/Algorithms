package com.javaDwarf.graphs.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class _542_01Matrix {

	// bfs time and space o(n*m)
	//important point for bfs is to be update the visited matrix when the element gets added to the queue
public int[][] updateMatrix(int[][] matrix) {
        
        int count = 1;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
       
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int k=0; k<size; k++){
                int[] curr = q.poll();
                
                for(int i=0; i<dirs.length; i++){
                    int xNew = curr[0] + dirs[i][0];
                    int yNew = curr[1] + dirs[i][1];
                    if(xNew >=0 && xNew<matrix.length && yNew >=0 && yNew<matrix[0].length
                       && !visited[xNew][yNew] && matrix[xNew][yNew] == 1){
                        matrix[xNew][yNew] = count;
                        q.add(new int[]{xNew, yNew});
                        visited[xNew][yNew] = true;
                    }
                }
            }
            count++;
        }
        return matrix;
    }

// same as without the use of visited matrix
public int[][] updateMatrixNoVisited(int[][] mat) {
    
    Queue<Pair> q = new LinkedList<>();
    for(int i=0; i< mat.length; i++){
        for(int j =0;  j<mat[0].length; j++){
            if(mat[i][j] == 0){
                q.add( new Pair<>(i,j));
            }
        }
    }
    
    int[] xArr = {-1,1,0,0};
    int[] yArr = {0,0,-1,1};
    
    int count = -1;
    
    while(!q.isEmpty()){
        
        int size = q.size();
        
        for(int p =0; p<size; p++){
        
            Pair<Integer, Integer> curr = q.poll();
            int x = curr.getKey();
            int y = curr.getValue();

            for(int i=0; i<xArr.length; i++){
                int xNew = x + xArr[i];
                int yNew = y + yArr[i];
                if(xNew >=0 && xNew<mat.length && yNew >= 0 && yNew >= 0 &&
                    yNew < mat[0].length && mat[xNew][yNew] == 1){
                    mat[xNew][yNew] = count;
                    q.add(new Pair<>(xNew, yNew));
                }
            }
        }
        count--;
    }
    for(int i=0; i< mat.length; i++){
        for(int j =0;  j<mat[0].length; j++){
            mat[i][j] = Math.abs(mat[i][j]);
        }
    }
    return mat;
}

}
