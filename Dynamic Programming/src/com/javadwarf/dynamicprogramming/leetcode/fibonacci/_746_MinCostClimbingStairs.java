package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _746_MinCostClimbingStairs {

	public static void main(String[] args) {

	}

	// below soln is not correct as per leetcode
	public int minCostClimbingStairs(int[] cost) {
		return minCostClimbingStairs(cost.length,cost, new int[cost.length+1]);
	}

	public int minCostClimbingStairs(int n, int[] cost, int[] memo) {
		
		if(n == 1) return cost[0];
		else if(n == 2) return cost[1];
		
		if(memo[n] != 0) return memo[n];
		
		memo[n] = Integer.min(minCostClimbingStairs(n-1, cost, memo) , minCostClimbingStairs(n-2, cost, memo));
		return memo[n];
	}

}
