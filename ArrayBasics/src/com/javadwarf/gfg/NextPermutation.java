package com.javadwarf.gfg;

import java.util.Scanner;

public class NextPermutation {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size1 = s.nextInt();
			int[] a = new int[size1];
			for(int x=0; x<size1; x++) {
				a[x]= s.nextInt();
			}
			nextGreaterNumber(a);
			System.out.println();
		}
		s.close();
	}

	private static void nextGreaterNumber(int[] a) {

		int swapIndex = -1;

		for(int i = a.length-1; i>0; i--) {
			if(a[i] > a[i-1]) {
				swapIndex = i-1;
				break;
			}
		}

		if(swapIndex == -1) {
			for(int i = a.length-1; i>=0; i--) {
				System.out.print(a[i] + " ");
			}
		}
		else if(swapIndex == a.length-2) {
			int temp = a[a.length-1];
			a[a.length-1] = a[a.length-2];
			a[a.length-2] = temp;
			for(int x=0; x<a.length; x++) {
				System.out.print(a[x] + " ");
			}
		}
		else {
			int swapWith  = swapIndex + 1;

			for(int x=swapIndex+2; x<a.length; x++) {
				if(a[x] > a[swapIndex] && a[x] < a[swapWith]) {
					swapWith  = x;
				}
			}

			int temp = a[swapIndex];
			a[swapIndex] = a[swapWith];
			a[swapWith] = temp;

			for(int x=0; x<=swapIndex; x++) {
				System.out.print(a[x] + " ");
			}
			
			boolean anomolyPrinted = false;
			for(int y=a.length-2; y > swapIndex; y--) {
				if(a[y] > a[a.length-1] && !anomolyPrinted) {
					System.out.print(a[a.length-1]+  " "); 
					anomolyPrinted = true;
				}
				System.out.print(a[y] + " ");
			}
		}
	}
}
