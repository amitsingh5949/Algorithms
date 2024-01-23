package com.javadwarf.dynamicprogramming.leetcode.fibonacci;

public class _746_MinCostClimbingStairs {

	public static void main(String[] args) {

	}

	// top-down
	public int minCostClimbingStairs(int[] cost) {
		return minCostClimbingStairs(cost.length, cost, new Integer[cost.length+1]);
	}

	public int minCostClimbingStairs(int n, int[] cost, Integer[] memo) {
		if(n == 0 || n == 1) return 0;// starting point
		if(memo[n] != null) return memo[n];

		memo[n] = Integer.min(cost[n-1] + minCostClimbingStairs(n-1, cost, memo) , cost[n-2] + minCostClimbingStairs(n-2, cost, memo));
		return memo[n];
	}

	//bottom-up approach

	//dp[i] is the cost needed to reach the ith index
	//cost to reach 0th and 1st index is 0 as they are starting point
	//cost to start from ith index = cost to reach there (dp[i])+ cost to take off (cost[i])
	
	public int minCostClimbingStairsBU(int[] cost) {
		int[] dp = new int[cost.length+1];
		for( int i=2; i<dp.length; i++){
			dp[i] =  Math.min( cost[i-1] + dp[i-1], cost[i-2] + dp[i-2] );
		}
		return dp[dp.length-1];
	}

}


