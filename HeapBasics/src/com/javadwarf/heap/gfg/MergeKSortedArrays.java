package com.javadwarf.heap.gfg;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int row = s.nextInt();
			int col = row;
			int[][] matrix = new int[row][col];
			for(int x=0; x<row; x++) {
				for(int y=0; y<col; y++) {
					matrix[x][y] = s.nextInt();
				}
			}
			int k = s.nextInt();
			System.out.println(mergeKArrays(matrix, row));
		}
		s.close();
	}
	
	 public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k){
		 return null;
     }

}
