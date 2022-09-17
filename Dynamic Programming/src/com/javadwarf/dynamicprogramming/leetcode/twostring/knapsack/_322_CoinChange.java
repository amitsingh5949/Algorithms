package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Map;
import java.util.TreeMap;

public class _322_CoinChange {

	public static void main(String[] args) {
		//System.out.println(new _322_CoinChange().coinChange(new int[]{1,2,5}, 11));
		//System.out.println(new _322_CoinChange().coinChange(new int[]{3}, 4));
		
		System.out.println(new _322_CoinChange().minimumCoinBottomUp(11, new int[]{1,2,5}));
	}
	
	//top to down approach, using recursion and memoization
	int[][] dp;
    public int coinChangeTopDown(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        if(amount == 0) return 0;
        if(coins == null || coins.length ==0) return -1;
        int res =  coinChange(coins, amount, 0);
        return  (res == Integer.MAX_VALUE-1) ? -1 : res;
    }
    
    public int coinChange(int[] coins, int amount, int index) {
        
        if(amount == 0) return 0;
        if(amount < 0 ) return Integer.MAX_VALUE-1;
        if(index >= coins.length) return Integer.MAX_VALUE-1;    
        if(dp[index][amount] != 0) return dp[index][amount];
        
        int excludeCurrCoin =  coinChange(coins, amount, index+1);
        int includeCurrCoin =  1 + coinChange(coins, amount-coins[index], index);
    
        dp[index][amount] = Math.min(excludeCurrCoin,includeCurrCoin);
        return  dp[index][amount];
    }
    
    //optimized top down where we do not choose or unchoose a coin, logic is to choose all the coins one by one
    class Solution {
        
        int[] dp;
        
        public int coinChange(int[] coins, int amount) {
            dp = new int[amount+1];
            dp[amount] = helper(coins,amount);
            return  dp[amount] == Integer.MAX_VALUE ? -1:   dp[amount];
        }
        
        public int helper(int[] coins, int amount){
            
            if( amount == 0 ) return 0;
            if(amount < 0) return Integer.MAX_VALUE;
            if(dp[amount] != 0) return dp[amount];
            
            int min = Integer.MAX_VALUE;
            for(int i=0;i<coins.length; i++){
                int temp = helper(coins, amount-coins[i]);
                if(temp != Integer.MAX_VALUE)
                    min = Integer.min(min, 1+temp);
            }
            
            dp[amount] = min;
            return dp[amount];
        }
    }

    // bottom up approach using iteration and memoization
	public int coinChange(int[] coins, int amount) {
		
		if(amount < 1) return 0;
		
		int[][] matrix = new int[coins.length+1][amount+1];

		for(int i=0; i<matrix.length; i++) {

			for(int j=0; j<matrix[i].length; j++) {

				if(i==0 || j==0) {
					matrix[i][j] = Integer.MAX_VALUE-1; // have to subtract 1 so to avoid integer overflow
				}
				else if(coins[i-1] == j ) {
					matrix[i][j] = 1;
				}
				else if(coins[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else {
					matrix[i][j] = Integer.min(matrix[i-1][j], 1 + matrix[i][j-coins[i-1]]);
				}
			}
		}
		return matrix[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : matrix[coins.length][amount];
	}

	//***** Advance bottom up
	
	public int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
    }

    private static Map<Integer, Integer>  printCoinCombination(int R[], int coins[]) {
       
    	 Map<Integer, Integer> map = new TreeMap<>();
    	
    	if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return map;
        }
        
       
        int start = R.length - 1;
        while ( start != 0 ) {
            int j = R[start];
            
        	
            System.out.print(coins[j] + " ");
            int count1 = map.getOrDefault(coins[j], 0);
            map.put(coins[j], count1+1);
            start = start - coins[j];
        }
        
        return map;
    }
}
