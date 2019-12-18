package com.javadwarf.leetcode.kadane;

public class _121_BuySellStockUnlimitedTransaction {

	public static void main(String[] args) {

		//System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));

		//System.out.println(maxProfit(new int[] {2,4,1}));

		//System.out.println(maxProfit(new int[] {1,2,3,4,5}));

		//System.out.println(maxProfit(new int[] {7,6,4,3,1}));
		
		System.out.println(maxProfit(new int[] {3,2,6,5,0,3}));

	}

	public static int maxProfit(int[] a) {

		if(a == null ||  a.length<2) return 0;

		int totalProfit = 0 ;

		int currProfit = 0;

		int start  = 0 ;

		int end = -1;

		for(int i=1; i<a.length; i++){

			if(a[start] < a[i] && a[i] - a[start] > currProfit) {
				end = i;
				currProfit = a[i] - a[start];
			}
			else if(end ==-1 && a[i] < a[start]) {
				start = i;
			}
			else if(end !=-1 && a[i] < a[end]) {
				start = i;
				end =-1;
				totalProfit += currProfit;
				currProfit = 0;
			}
		}
		totalProfit += currProfit;
		return totalProfit;
	}


}
