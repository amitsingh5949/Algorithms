package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _354_RussianDollEnvelopes {

	public static void main(String[] args) {

	}

	//Sort the array. Ascend on width and descend on height if width are same.
	//Find the LIS based on height.
	public int maxEnvelopes(int[][] envelopes) {
		
		if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
		
		Arrays.parallelSort(envelopes, (a,b) -> {
			int temp = Integer.compare(a[0], b[0]);
			if(temp == 0) {
				return Integer.compare(b[1], a[1]);
			}
			return temp;
		});
		
		int last = 0;
		int[] output = new int[envelopes.length];
		output[0] = envelopes[0][1];

		for(int i=1; i<envelopes.length; i++) {

			if(output[last] < envelopes[i][1]) {
				output[++last] = envelopes[i][1];
			}
			else {
				int start = 0;
				int end = last;
				int mid = (start + end)/2;
				 
				while(start <= end) {
					mid = (start + end)/2;
                    if(output[mid] == envelopes[i][1]){
                    	start = mid;
                        break ;
                    }
					else if(output[mid] > envelopes[i][1]) {
						end = mid-1;
					}
					else {
						start = mid+1;
					}
				}
				output[start] = envelopes[i][1];
			}
		}
		return last+1;
	}
}
