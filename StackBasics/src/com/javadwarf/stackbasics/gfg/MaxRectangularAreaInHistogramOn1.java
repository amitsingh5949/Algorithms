package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

import com.javadwarf.stackbasics.leetcode._84_LargestRectangleinHistogram;

public class MaxRectangularAreaInHistogramOn1 {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in); 
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++) {
				arr[j] = in.nextInt();
			}
			System.out.println(maxRecAreaHisto(arr));
		}
		in.close();*/
		
		System.out.println(new MaxRectangularAreaInHistogramOn1().maxRecAreaHisto(new int[] {6,2,5,4,5,1,6}));
	}

	private static int maxRecAreaHisto(int[] arr) {
		
		int maxArea = -1 ;
		int i = 1;
		int top = 0;
		int area = -1;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.valueOf(0));

		while(i < arr.length) {
			
			if(arr[stack.peek()] <= arr[i]) {
				stack.push(Integer.valueOf(i));
			}
			else {
				while(!stack.isEmpty() && arr[stack.peek()] >  arr[i]) {
					top = stack.pop();
					if(stack.isEmpty()) {
						area = arr[top] * (i);
					}
					else {
						area = arr[top] * (i-stack.peek()-1);
					}
					if(area > maxArea) {
						maxArea = area;
					}
				}
				stack.push(Integer.valueOf(i));
			}
			i++;
		}
		
		while(!stack.isEmpty()) {
			top = stack.pop();
			if(stack.isEmpty()) {
				area = arr[top] * (i);
			}
			else {
				area = arr[top] * (i-stack.peek()-1);
			}
			if(area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
}
