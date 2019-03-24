package com.javadwarf.gfg;

import java.util.Scanner;

public class MaxSumSubArrayWithAtleastKNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		for(int i=0; i<tests; i++) {
			int size = s.nextInt();
			int[] arr = new int[size];
			for(int j=0; j<size; j++) {
				arr[j] = s.nextInt();
			}
			int k = s.nextInt();
			System.out.println(maxSumSubArrayWithAtleastKNumbers(arr, k));
		}
		s.close();
	}
	//TODO: not implemented yet
	public static int maxSumSubArrayWithAtleastKNumbers(int[] a , int k) {
		int result = 0;
		
		int sum = 0 ;
		for(int i=0; i<k; i++) {
			sum += a[i];
		}
		result = sum;
		int start = 0;
		for(int i=k; i<a.length;i++) {
			sum = sum + a[i] - a[start];
		}
		
		return result;
	}

}
