package com.javadwarf.gfg;

import java.util.Arrays;
import java.util.Scanner;

public class WaveArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			waveArray(a);
			System.out.println();
		}
		s.close();
	}

	// Method 1 - O(nlogn)
	private static void waveArray(int[] a) {
		Arrays.sort(a);
		int i =0;
		while(i < a.length) {
			if(i+1 < a.length) {
				System.out.print(a[i+1] +" " + a[i] + " ");
			}else {
				System.out.print(a[i] + " ");
			}
			i = i+2;
		}
	}
	
	// Method 2 - O(n)
	/*if we make sure that all even positioned (at index 0, 2, 4, ..) elements are greater than their adjacent odd elements, we don’t need to worry about odd positioned element.
	1) Traverse all even positioned elements of input array, and do following.
	….a) If current element is smaller than previous odd element, swap previous and current.
	….b) If current element is smaller than next odd element, swap next and current.*/

}
