package com.javadwarf.matrix.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _73_SetMatrixZeroes {
	
	// store row and column id's in respective sets for all cells with value 0
	//iterate again if i or j is present in sets then mark that cell with value 0;
	 public void setZeroes(int[][] matrix) {
	        
	        Set<Integer> row = new HashSet<>();
	        Set<Integer> col = new HashSet<>();
	        
	        for(int i=0; i<matrix.length; i++){
				for(int j=0; j<matrix[0].length; j++){
					if(matrix[i][j] == 0){
						row.add(i);
	                    col.add(j);
					}
				}
			}
	        
	        for(int i=0; i<matrix.length; i++){
				for(int j=0; j<matrix[0].length; j++){
	                if(row.contains(i) || col.contains(j)) matrix[i][j] = 0;
	            }
	        }
	    }

	public void setZeroes1(int[][] matrix) {

		boolean hasZeroFirstRow = false;
		boolean hasZeroFirstcolumn = false;

		//check if fist row has any cell with value 0  and set the flag true
		for(int j=0; j<matrix[0].length; j++){
			if(matrix[0][j] == 0) hasZeroFirstRow = true;
		}

		//check if fist column has any cell with value 0 and set the flag true
		for(int i=0; i<matrix.length; i++){
			if(matrix[i][0] == 0) hasZeroFirstcolumn = true;
		}

			
		// now start from index 1 and 1 and use first row and column cells as markers instead of using set as place to store maker 
		//if cell value is 0 then its row's first cell and colums's first cell should be marked 0.
		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//based on the markers in first row and first column, fill the appropriate row and column with 0
		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
		}

		//Now, finally based on the flags , fill first row and column with 0 
		if(hasZeroFirstRow) Arrays.fill(matrix[0], 0);

		if(hasZeroFirstcolumn){
			for(int i=0; i<matrix.length; i++) 
				matrix[i][0] = 0;
		}

	}

}
