package com.javadwarf.heap.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _973_KClosestPointstoOrigin {

	public static void main(String[] args) {

	}
	//using max heap
	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> q = new PriorityQueue<>((b,a) -> Double.compare( Math.sqrt( Math.pow(a[0],2)+Math.pow(a[1],2)), Math.sqrt(Math.pow(b[0],2)+Math.pow(b[1],2)) )) ;
		for(int[] arr : points){
			q.add(arr);
			if(q.size() > k) q.poll();
		}
		int[][] res = new int[k][2];
		int i=0;
		while(!q.isEmpty()) res[i++] = q.poll();
		return res;
	}

	//Divide and Conquer Approach is o(n) + o(n) -- using quick select, divide the array at a pivot point such that all coordinates
	// left to pivot are closer to origin and all on right are farther from origin
	// we need to find pivot at index k and return all elements left to it since order is not important, we don't need to sort these elements.

}
