package com.javadwarf.gfg;

import java.util.Scanner;

public class FrequencyOfArrayElements {

	//Method - 1 
	/*public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[s.nextInt()-1]++;
			}
			for(int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		s.close();
	}*/

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size1 = s.nextInt();
			int[] a = new int[size1];
			for(int x=0; x<size1; x++) {
				a[x]= s.nextInt();
			}
			frequency4(a);
			System.out.println();
		}
		s.close();

	}

	// Method 2
	private static void frequency(int[] a) {
		int[]  b = new int[a.length];

		for(int x : a) {
			b[x-1]++;
		}
		for(int x : b) {
			System.out.print(x + " ");
		}
	}

	//method 3
	private static void frequency3(int[] a) {
		int i = 0 ;
		while(i < a.length) {

			if(a[i] <= 0) {
				i++;
				continue;
			}

			int temp = a[i];
			int x = a[temp-1] ;
			if(x > 0) {
				a[temp-1] = -1;
				if(x != temp) {
					a[i] = x;
				}
			}
			else {
				a[temp-1]--;
				a[i] = 0;
			}
		}

		for(int x : a) {
			System.out.print(Math.abs(x) + " ");
		}
	}

	//method 4
	private static void frequency4(int[] a) {
		int n = a.length;

		for (int j = 0; j < n; j++) {
			a[j] = a[j] - 1;
		}
		
		for(int i=0; i<a.length; i++) {
			a[a[i] %n] = a[a[i] % n] + n;
		}

		for(int x : a) {
			System.out.print(x/n + " ");
		}
	}
}
