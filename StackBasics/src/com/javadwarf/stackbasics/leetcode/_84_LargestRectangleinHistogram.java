package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _84_LargestRectangleinHistogram {

	public static void main(String[] args) {
		System.out.println(new _84_LargestRectangleinHistogram().largestRectangleArea(new int[] {6,2,5,4,5,1,6}));
	}

	public int largestRectangleArea(int[] heights) {

		if(heights == null || heights.length == 0) return 0;

		Stack<Integer> s = new Stack<>();
		s.push(0);

		int maxArea = 0;
		int area = 0;
		int i = 1;
		int top = 0;

		while(i < heights.length) {

			while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
				top = s.pop();
				if(s.isEmpty()) {
					area = heights[top] * i;
				}
				else {
					area =  heights[top]*(i-s.peek()-1);
				}
				maxArea = Integer.max(maxArea, area);
			}
			s.push(i);
			i++;
		}


		while(!s.isEmpty()) {
			top = s.pop();
			if(s.isEmpty()) {
				area = heights[top] * i;
			}
			else {
				area =  heights[top]*(i-s.peek()-1);
			}
			maxArea = Integer.max(maxArea, area);
		}
		
		return maxArea;
	}
}
