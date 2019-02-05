package com.javadwarf.heap.leetcode;

import java.util.PriorityQueue;

public class _378_KthSmallestElemntInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
    int result = 0;
		PriorityQueue<Pos1> pq = new PriorityQueue<>();

		for(int j=0; j<matrix.length; j++) {
			pq.add(new Pos1(j,0, matrix[j][0]));
		}
		while(k>0 && !pq.isEmpty()) {
			Pos1 min = pq.poll();
			result = min.value;
			if(min.y != matrix[min.x].length-1) {
				pq.add(new Pos1(min.x, min.y+1, matrix[min.x][min.y+1]));
			}
			k--;
		}  
      return result;
}
}
class Pos1 implements Comparable<Pos1>{
	public int x,y, value;
	public Pos1(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value =value;
	}
	@Override
	public int compareTo(Pos1 o) {
		return Integer.compare(this.value, o.value);
	}
	@Override
	public String toString() {
		return value+"";
	}
}
