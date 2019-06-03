package com.javadwarf.gfg;

import java.util.Scanner;

public class MissingAndRepeatingNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			missRepeat1(a);
			missRepeat2(a);
		}
		s.close();
	}

	// method 1 - extra space o(n) and time o(n)
	private static void missRepeat1(int[] a) {
		int miss = -1;
		int repeat = -1;
		int[] b = new int[a.length];
		
		for(int x : a) {
			if(b[x-1] != 0) {
				repeat = x;
			}
			b[x-1]++;
		}
		
		for(int i=0; i<b.length; i++) {
			if(b[i]==0) {
				miss = i+1;
				break;
			}
		}
		System.out.println(repeat + " " + miss);
	}
	
	// method 2 - extra space o(1) and time o(n)
	private static void missRepeat2(int[] a) {
		int miss = -1;
		int repeat = -1;
		
		for(int x : a) {
			if(a[Math.abs(x)-1] > 0) {
				a[Math.abs(x)-1] = - a[Math.abs(x)-1];
			}
			else if (a[Math.abs(x)-1] < 0){
				repeat =  Math.abs(x);
			}
		}
		
		for(int i=0; i<a.length; i++) {
			if(a[i]>0) {
				miss = i+1;
				break;
			}
		}
		System.out.println(repeat + " " + miss);
	}
	
	// method 3-  if we xor a and all elements from 1 ton n , we get xor of mis and rept, 
	//it becomes the same problem as 2 unique numbers and all other numbers repeating twice, use xor logic 

}
