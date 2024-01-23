package com.javadwarf.leetcode.kadane;

public class _309_BestTimetoBuyandSellStockwithCooldown {

	public static void main(String[] args) {

	}

	// brute force recursion
	public int maxProfit(int[] prices) {
        return helper(prices, 0, -1);
    }
    
    public int helper(int[] prices, int curr, int prev){
        
        if(curr>= prices.length) return 0;
        
        int x1=0,x2=0,x3=0,x4=0;
        
        if( prev == -1){
            x1 = helper(prices, curr+1, curr);//buy
            x2 = helper(prices, curr+1, prev);// not buy
        }
        else{
            x3 = prices[curr] - prices[prev] + helper(prices, curr+2, -1);//sell
            x4 = helper(prices, curr+1, prev);// not sell
        }
        
        return Math.max(Math.max(x1,x2), Math.max(x3,x4));
    }
    
    
    //top-down recursion
    public int maxProfitTD(int[] prices) {
        return helper(prices, 0, prices.length, new Integer[prices.length][prices.length+1]);
    }
    
    public int helper(int[] prices, int curr, int prev, Integer[][] dp){
        
        if(curr>= prices.length) return 0;
        if(dp[curr][prev] != null) return dp[curr][prev];
        
        int x1=0,x2=0,x3=0,x4=0;
        
        if( prev == prices.length){
            x1 = helper(prices, curr+1, curr, dp);//buy
            x2 = helper(prices, curr+1, prev, dp);// not buy
        }
        else{
            x3 = prices[curr] - prices[prev] + helper(prices, curr+2, prices.length, dp);//sell
            x4 = helper(prices, curr+1, prev, dp);// not sell
        }
        
        dp[curr][prev] = Math.max(Math.max(x1,x2), Math.max(x3,x4));
        return dp[curr][prev];
    }
    
    //Bottom-up



}
