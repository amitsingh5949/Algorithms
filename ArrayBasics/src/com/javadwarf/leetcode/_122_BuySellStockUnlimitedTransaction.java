package com.javadwarf.leetcode;

public class _122_BuySellStockUnlimitedTransaction {

	public static void main(String[] args) {

		System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));

		System.out.println(maxProfit(new int[] {2,4,1}));

	}

	public static int maxProfit(int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int profit = 0;

		int start  = 0 ;

		for(int i=1; i<prices.length; i++){

			if(prices[i] > prices[start] ) {

				if(prices[i]-prices[start] > profit) { // actually above if is not needed, see code below
					profit = prices[i]-prices[start];
					continue;
				}
			}
			else if(prices[i] < prices[start] ) {
				start = i;
			}
		}
		return profit;
	}

	public static int maxProfit1(int[] prices) {

		if(prices == null ||  prices.length<2) return 0;

		int profit = 0;

		int start  = 0 ;

		for(int i=1; i<prices.length; i++){

			if(prices[i]-prices[start] > profit ) {
				profit = prices[i]-prices[start];
			}
			else if(prices[i] < prices[start] ) {
				start = i;
			}
		}
		return profit;
	}
}
