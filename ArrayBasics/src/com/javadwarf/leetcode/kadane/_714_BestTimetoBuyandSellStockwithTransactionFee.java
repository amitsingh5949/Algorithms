package com.javadwarf.leetcode.kadane;

public class _714_BestTimetoBuyandSellStockwithTransactionFee {

	public static void main(String[] args) {
		System.out.println(new _714_BestTimetoBuyandSellStockwithTransactionFee().maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
	}

	public int maxProfit(int[] prices, int fee) {
		int cash = 0;
		int hold = -1*prices[0];
		for(int i=1; i<prices.length; i++) {
			cash = Math.max(cash,  hold + prices[i] -fee);
			hold = Math.max(hold, cash - prices[i]);
		}
		return cash;
	}
	
	// wrong approach 
	public int maxProfit1(int[] prices, int fee) {

		int totalProfit = 0;
		int start = 0;
		int end = -1;
		int currProfit = 0;

		for(int i =1; i<prices.length; i++) {

			if(prices[start] < prices[i] && prices[i] - prices[start] > currProfit) {
				end = i;
				currProfit = prices[i] - prices[start];
			}
			else if(end ==-1 && prices[i] < prices[start]) {
				start = i;
			}
			else if(end !=-1 && prices[i] < prices[end]) {
				if(currProfit > fee) {
					start = i;
					end =-1;
					totalProfit = totalProfit + currProfit - fee;
					currProfit = 0;
				}
			}
		}

		if(currProfit > fee) {
			totalProfit = totalProfit + currProfit -fee;
		}

		return totalProfit;
	}
}
