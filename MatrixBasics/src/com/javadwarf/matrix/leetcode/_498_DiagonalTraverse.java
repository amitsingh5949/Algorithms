package com.javadwarf.matrix.leetcode;

import java.util.LinkedList;

public class _498_DiagonalTraverse {

	
	//TODO : not working as of now , fix it
	public int[] findDiagonalOrder(int[][] matrix) {
		int[] res = new int[matrix.length*matrix[0].length];
		
		int row = 0;
		int col = 0;
		
		int direction = 1;
		int i = 0;
		
		while(row<matrix.length && col< matrix[0].length) {
			
			int newRow = (direction == 1) ? row-1 : row+1;
			int newCol = (direction == 1) ? col+1 : col-1;
			
			if(newRow<0 || newRow>= matrix.length || newCol<0  || newCol>=matrix[0].length) {
				if(newRow<0 && newCol < matrix[0].length) {
					col = col + 1;
				}
				else if(newRow<0 && newCol >= matrix[0].length) {
					row = row -1;
				}
				else if(newCol<0 && newRow<matrix.length) {
					row = row +1;
				}
				else if(newCol<0 && newRow>=matrix.length) {
					col = col +1;
				}
				
			}
			else {
				row = newRow;
				col = newCol;
			}
			res[i++] = matrix[row][col];
			direction = 1 - direction;
			
		}
		
		return res;

		
	}

	//Logic : diagonal elements will have same sum of row and column index
	//time : o(m*n) and space o(m+n)

	public int[] findDiagonalOrder1(int[][] matrix) {

		if(matrix == null || matrix.length == 0 ) return new int[0];

		LinkedList<Integer>[] arr = new LinkedList[matrix.length+matrix[0].length-1];
		for(int i=0; i<arr.length;i++) 
			arr[i] = new LinkedList<Integer>();

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if( (i+j) %2 == 0)
					arr[i+j].addFirst(matrix[i][j]);
				else
					arr[i+j].addLast(matrix[i][j]);         
			}
		}

		int[] res = new int[matrix.length*matrix[0].length];
		for(int i=0,x=0; i<arr.length; i++){
			for(int curr : arr[i])
				res[x++] = curr; 
		}
		return res;
	}
	
	// o(n*m) and o(1)
	int[] res;
    int n;
    int m;
    int index ;
    
    public int[] findDiagonalOrderOptimised(int[][] mat) {
        
        n = mat.length;
        m = mat[0].length;
        res = new int[n*m];
        index = 0;
        
        boolean up = true;
        
        int x = 0;
        int y = 0;
        
        while(index < m*n){
            
            if(up){
                up = false;
                int[] arr = moveUp(mat, x,y);
                
                if(arr[0] == 0 && arr[1] < m-1){
                    x = arr[0];
                    y = arr[1] +1;
                }
                else{
                    x = arr[0] +1;
                    y = arr[1];
                }
            }
            else{
               up = true;
               int[] arr = moveDown(mat, x,y);
                if(arr[0] < n-1 && arr[1] == 0){
                    x = arr[0]+1;
                    y = arr[1] ;
                }
                else{
                    x = arr[0];
                    y = arr[1] + 1;
                }
              
            }
        }
        
        return res;
    }
    
    
    public int[] moveUp(int[][] mat, int x, int y){
        while(x>=0 && y>=0 && x<n && y<m){
            res[index++] = mat[x][y];
            x--;
            y++;
        }
        return new int[]{++x, --y };
    }
    
    public int[] moveDown(int[][] mat, int x, int y){
        while(x>=0 && y>=0 && x<n && y<m){
            res[index++] = mat[x][y];
            x++;
            y--;
        }
        return new int[]{--x, ++y };
    }

}
