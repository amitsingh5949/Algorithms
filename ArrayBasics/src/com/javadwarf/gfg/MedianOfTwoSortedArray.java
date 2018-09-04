package com.javadwarf.gfg;

import java.util.Scanner;

public class MedianOfTwoSortedArray {

	public static void main (String[] args){
		/*Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size1 = s.nextInt();
			int[] a = new int[size1];
			for(int x=0; x<size1; x++) {
					a[x]= s.nextInt();
			}
			int size2 = s.nextInt();
			int[] b = new int[size2];
			for(int x=0; x<size2; x++) {
					b[x]= s.nextInt();
			}
			System.out.println(median(a, b));
		}
		s.close();*/
		
		System.out.println(median(new int[] {1,12,15,26,38},new int[] {2,13,17,30,45}));
		
		
		
	}
//Method 1 - o(n)
	public static int median(int[] a, int[] b) {
		int result = -1;

		int x = 0;
		int y = 0;

		int count = 0;

		while(true) {
			if(count==a.length-1) {
				result =  Math.addExact(a[x],b[y])/2;
				break;
			}
			if(a[x]<=b[y]) {
				x++;
			}
			else{
				y++;
			}
			count++;
		}
		return result;
	}
	
	//Method 2 - o(logn)
}
