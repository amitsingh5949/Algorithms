package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _85_MaximalRectangle {

	public static void main(String[] args) {

	}

	// my method
	public int maximalRectangle1(char[][] matrix) {

		int result = 0;

		if(matrix==null || matrix.length==0 || matrix[0].length==0) return result;

		int[] histogram = new int[matrix[0].length];

		for(int rowNum =0 ; rowNum<matrix.length; rowNum++) {

			for(int j= 0; j<matrix[0].length; j++) {

				int oneCount = 0;

				for(int i=rowNum; i<matrix.length; i++) {
					if(matrix[i][j]=='0') break;
					oneCount++;
				}
				histogram[j] = oneCount;
			}

			result = Integer.max(result,largestRectangleArea(histogram));

		}

		return result;

	}

	public int maximalRectangle(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
		return maxArea(matrix, matrix.length, matrix[0].length);
	}

	public  int maxArea(char a[][],int n,int m){

		int[] arr = new int[m];
		int area = -1;

		for(int j=0; j<n; j++) {
			for(int k=0; k<m; k++) {
				if(a[j][k]=='1') {
					arr[k] = arr[k] + 1;
				}
				else if(a[j][k]=='0') {
					arr[k] = 0;
				}
			}
			int temp = largestRectangleArea(arr);
			if(temp > area) {
				area = temp;
			}
		}
		return area;

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
