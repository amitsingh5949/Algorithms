package com.javadwarf.dynamicprogramming.leetcode.twostring.knapsack;

import java.util.Arrays;

public class _518_CoinChange2 {

	public static void main(String[] args) {
		System.out.println(new _518_CoinChange2().change(5, new int[]{1,2,5}));
	}
	//Top-down
	
	int[][] dp;
    
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(coins, amount, 0);
    }
    
    public int helper(int[] coins, int amount, int index){
        if(amount == 0 ) return 1;
        if(amount < 0 || index == coins.length) return 0;
        if(dp[index][amount] != -1) return dp[index][amount];
        
        int choose = helper(coins, amount - coins[index], index);
        int notChoose = helper(coins, amount, index+1);
        
        dp[index][amount] = choose + notChoose;
        return dp[index][amount];
    }
    
    
    //	//bottom up

	public int changeBottomUp(int amount, int[] coins) {
		
		if(amount == 0) return 1;
		
		int[][] matrix = new int[coins.length+1][amount+1];
		
		for(int i=0; i<matrix.length; i++) {
			
			for(int j =0; j<matrix[i].length; j++) {
			
				if(i ==0 || j==0) {
					matrix[i][j] = 0;
				}
				else if(coins[i-1] > j) {
					matrix[i][j] = matrix[i-1][j];
				}
				else if(coins[i-1] == j) {
					matrix[i][j] = matrix[i-1][j] + 1;
				}
				else {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j- coins[i-1]];
				}
			}
		}
		return matrix[coins.length][amount];
	}
	
	
}
