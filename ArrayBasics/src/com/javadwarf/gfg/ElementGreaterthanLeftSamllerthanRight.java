package com.javadwarf.gfg;

import java.util.Scanner;

public class ElementGreaterthanLeftSamllerthanRight {

	public static void main(String[] args) {
		/*Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i=0; i<tests; i++) {
			int size = s.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++) {
				arr[j] = s.nextInt();
			}
			System.out.println(findElementGreaterthanLeftSamllerthanRight(arr));
		}
		s.close();*/
		
		System.out.println(findElementGreaterthanLeftSamllerthanRight(new int[] {7, 13, 10, 2 ,3 ,8 ,11, 12, 17, 18, 19, 20}));
	}

	
	public static int findElementGreaterthanLeftSamllerthanRight(int[] a) {
		int result = -1;
		
		int[] leftMax = new int[a.length];
		int[] rightMin = new int[a.length];
		
		leftMax[0] = a[0];
		for(int i=1; i<a.length; i++) {
			if(a[i] > leftMax[i-1]) {
				leftMax[i] = a[i];
			}
			else {
				leftMax[i] = leftMax[i-1];
			}
		}
		
		rightMin[a.length-1] = a[a.length-1];
		for(int i=a.length-2; i>=0; i--) {
			if(a[i] < rightMin[i+1]) {
				rightMin[i] = a[i];
			}
			else {
				rightMin[i] = rightMin[i+1];
			}
		}
		
		for(int i=1; i<a.length-1; i++) {
			if(leftMax[i] == rightMin[i]) {
				result = leftMax[i];
				break;
			}
		}
		
		
		return result;
		
	}
	
}
