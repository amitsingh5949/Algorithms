package com.javadwarf.greedy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _406_QueueReconstructionbyHeight {

	public static void main(String[] args) {
		int[][] arr = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(new _406_QueueReconstructionbyHeight().reconstructQueue(arr));
		//o/p : [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] output should be such that at
		       // each index there must arr[1] number of people with height greater
		// than arr[0]
	}
	
	// Trick is to sort the people based on decreasing height and increasing num of people in front
	//Take list and add person based out of its index location
	

	public int[][] reconstructQueue(int[][] people) {
		
		Arrays.sort(people, (a,b) -> {
			int x = Integer.compare(b[0], a[0]);
			if(x == 0) {
				return Integer.compare(b[1], a[1]);
			}
			return x;
		});
		// above or
		//Arrays.sort(people, (a,b) -> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
		
		List<int[]> ll = new LinkedList<>();
		
		for(int[] person : people) {
			ll.add(person[1], person);
		}
		return ll.toArray(new int[people.length][2]);
	}
}