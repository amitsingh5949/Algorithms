package com.javadwarf.greedy.leetcode;

public class Wateringplant {

	public int solution(int[] plants, int capacity1, int capacity2) {
		// write your code in Java SE 8

		int min = 0;

		int start = 0;
		int end = plants.length-1;

		int leftWaterStart = 0;
		int leftWaterEnd = 0;

		while(start <= end) {

			if(start == end) {
				if(leftWaterStart + leftWaterEnd < plants[start]) {
					min++;
				}
				break;
			}

			if(leftWaterStart < plants[start]) {
				min++;
				leftWaterStart = capacity1;
			}
			
			leftWaterStart = leftWaterStart - plants[start];
			
			if(leftWaterEnd < plants[end]) {
				min++;
				leftWaterEnd = capacity2;
			}
			
			leftWaterEnd = leftWaterEnd - plants[end];
			
			start++;
			end--;

		}
		return min;
	}
}
