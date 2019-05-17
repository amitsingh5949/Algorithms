package com.javadwarf.gfg;

import java.util.Scanner;

public class MaximumIndexDistanceJ_I {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i=0; i<tests; i++) {
			int size = s.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++) {
				arr[j] = s.nextInt();
			}
			System.out.println(maxIndex(arr));
		}
		s.close();
	}

	public static int maxIndex(int[] a) {

		int result = -1;

		int[] leftMin = new int[a.length];
		int[] rightMax = new int[a.length];

		leftMin[0] = a[0];
		for(int i=1; i<a.length; i++) {
			if(a[i] < a[leftMin[i-1]]) {
				leftMin[i] = i;
			}
			else {
				leftMin[i] = i-1;
			}
		}

		rightMax[a.length-1] = a[a.length-1];
		for(int i=a.length-2; i>=0; i--){
			if(a[i] < a[rightMax[i+1]]) {
				rightMax[i] = i;
			}
			else {
				rightMax[i] = i+1;
			}
		}

		int i = 0;
		int j = 0;
		int diff = -1;

		while(i!=a.length-1 || j==a.length-1) {

			while(a[leftMin[i]] > a[rightMax[j]]) {
				
			}

			while(a[rightMax[j]] > a[leftMin[i]]) {

			}

		}

		return result;

	}

}
