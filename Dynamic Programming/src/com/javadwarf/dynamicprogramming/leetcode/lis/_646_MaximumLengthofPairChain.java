package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _646_MaximumLengthofPairChain {

	public static void main(String[] args) {
		System.out.println(new _646_MaximumLengthofPairChain()
				//.findLongestChain(new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}}));
				  .findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
	}

	public int findLongestChainDP(int[][] pairs) {
		//pairs = sortPairs(pairs);
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int max = 1;
		int[] output = new int[pairs.length];
		for(int i=0; i<pairs.length;i++) {
			output[i] = 1;
			for(int j=i-1; j>=0;j--) {
				if(pairs[i][0] > pairs[j][1]) {

					output[i] = Integer.max(output[i], output[j]+1);
					max = Integer.max(max,output[i]);
				}
			}
		}
		return max;
	}

	public static int[][] sortPairs(int[][] a){
		for(int i=0; i<a.length; i++){
			for(int j=0;j<a.length-1-i;j++){
				int[] temp = null;
				if(a[j][0]>a[j+1][0]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					temp=null;
				}
			}
		}
		return a;
	}
	
	// Greedy Solution O(nlogn) and O(n)
	// Sort them by ending element of pair -- same as activity selection
	public int findLongestChain(int[][] pairs) {
		Arrays.parallelSort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
		int max = 1;
		int curr = pairs[0][1];
		for(int i=0; i<pairs.length;i++) {
			if(pairs[i][0] > curr) {
				max++;
				curr = pairs[i][1];
			}
		}
		return max;
	}
}
