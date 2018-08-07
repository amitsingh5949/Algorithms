package com.javadwarf.gfg;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {

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
			kthSmallest(matrix, row, k);
		}
		s.close();
	}

	public static void kthSmallest(int[][] matrix,int n,int k){
		int result = 0;
		PriorityQueue<Pos> pq = new PriorityQueue<>(n);

		for(int j=0; j<n; j++) {
			pq.add(new Pos(j,0, matrix[j][0]));
		}
		while(k>0 && !pq.isEmpty()) {
			Pos min = pq.poll();
			result = min.value;
			if(min.y != matrix[min.x].length-1) {
				pq.add(new Pos(min.x, min.y+1, matrix[min.x][min.y+1]));
			}
			k--;
		}
		System.out.println(result);
	}
}
