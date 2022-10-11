package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _1043_PartitionArrayforMaximumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4})));
		List<int[]> l = Arrays.asList(new int[]{1,2,3,4});
		System.out.println(new ArrayList<Integer>(Arrays.stream(new int[]{1,2,3,4,5}).boxed().collect(Collectors.toList())));
		
		List<Integer> l1 = new ArrayList<>();
		Collections.addAll(l1, new Integer[]{1,2,3,4,5});
		String s =  Integer.toString(2);
		
	}

	// top-down
	int[] dp;
	public int maxSumAfterPartitioningTopDown(int[] arr, int k) {
		dp = new int[arr.length];
		Arrays.fill(dp,-1);
		return helper(arr,k,0);
	}

	public int helper(int[] arr, int k , int index){

		if(index >= arr.length ) return 0;

		if(dp[index] != -1) return dp[index];

		int max = Integer.MIN_VALUE;
		for( int i=0;  i<k && i+index < arr.length; i++){
			max = Math.max(max, arr[index+i]);
			dp[index] = Math.max(dp[index], max*(i+1) + helper(arr, k, index+i+1));
		}

		return dp[index];
	}

	//bottom - up
	public int maxSumAfterPartitioning(int[] arr, int k) {

		int[] dp = new int[arr.length];

		int maxSoFar = Integer.MIN_VALUE;
		for(int i=0; i<k; i++){
			maxSoFar = Math.max(maxSoFar, arr[i]);
			dp[i] = maxSoFar*(i+1);
		}

		for(int i=k; i<arr.length; i++){

			maxSoFar = Integer.MIN_VALUE;
			int sum = 0;
			int count = 0;

			while(count < k){
				maxSoFar = Math.max(maxSoFar, arr[i-count]);
				sum = maxSoFar * (count+1);
				dp[i] = Math.max(dp[i], sum + dp[i-count-1]);
				count++;
			}
		}
		return dp[arr.length-1];
	}

}

