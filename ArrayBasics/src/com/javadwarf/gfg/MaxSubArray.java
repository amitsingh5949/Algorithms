package com.javadwarf.gfg;

import java.util.Scanner;

public class MaxSubArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i=0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			maxSubArray(a);
			System.out.println();
		}
		s.close();
	}

	private static void  maxSubArray(int[] a) {
		
		int lastCount = 0 ;
		int currCount = 0;
		int start = 0;
		int end = 0;
		int begin = 0 ;
		
		for(int i=0; i<a.length; i++) {
			if(currCount < 0) {
				currCount = 0;
			}
			if(a[i] >= 0) {
				currCount += a[i];
			}
			if(a[i] < 0) {
				begin = i+1;
				currCount = -1;
			}
			if(currCount >= lastCount) {
				lastCount = currCount;
				start = begin;
				end = i;
			}
		}
		for(int i = start; i<= end; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void maxSubArraySum(int a[], int size) { 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,
        start = 0, 
        end = 0, begin = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += a[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = begin; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                begin = i + 1; 
            } 
        } 
    }
}
