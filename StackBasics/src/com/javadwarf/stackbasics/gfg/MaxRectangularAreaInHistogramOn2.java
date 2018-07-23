package com.javadwarf.stackbasics.gfg;

import java.util.Scanner;

public class MaxRectangularAreaInHistogramOn2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			int size = in.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++) {
				arr[j] = in.nextInt();
			}
			System.out.println(maxRecAreaHisto(arr));
		}
		in.close();
	}

	private static int maxRecAreaHisto(int[] arr) {
		int area = 0;
		for(int j=0; j<arr.length; j++) {
			int temp = maxRecAreaHisto(arr, j);
			if(temp > area) {
				area = temp;
			}
		}
		return area;
	}

	private static int maxRecAreaHisto(int[] arr, int index) {
		int area = arr[index];

		for(int j=index+1; j<arr.length; j++) {
			if(arr[j] < arr[index]) 
				break;
			area = area + arr[index];
		}
		for(int k = index-1; k>=0; k--) {
			if(arr[k] < arr[index])
				break;
			area = area + arr[index];
		}
		return area;
	}
}
