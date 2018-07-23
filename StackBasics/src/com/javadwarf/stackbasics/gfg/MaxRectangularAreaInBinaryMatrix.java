package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangularAreaInBinaryMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] arr = new int[n][m];
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					arr[j][k] = in.nextInt();
				}
			}
			System.out.println(maxArea(arr,n,m));
		}
		in.close();
	}

	public static int maxArea(int a[][],int n,int m){
		int[] arr = new int[m];
		int area = -1;

		for(int j=0; j<n; j++) {
			for(int k=0; k<m; k++) {
				if(a[j][k]==1) {
					arr[k] = arr[k] + 1;
				}
				else if(a[j][k]==0) {
					arr[k] = 0;
				}
			}
			int temp = maxRecAreaHisto(arr);
			if(temp > area) {
				area = temp;
			}
		}
		return area;
	}

	private static int maxRecAreaHisto(int[] arr) {
		if(arr.length==0) return 0;

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
