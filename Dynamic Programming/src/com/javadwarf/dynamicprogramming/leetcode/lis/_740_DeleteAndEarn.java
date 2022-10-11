package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.Arrays;

public class _740_DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// top dowm , no sorting required, find max element and find the amount earned by max 
	
	




	//Bottom up approach -  time : nlogn + n*n
	public int deleteAndEarn(int[] nums) {

		Arrays.sort(nums);

		int[] ans = new int[nums.length];

		for(int i=0; i< nums.length; i++){

			int num = nums[i];

			if(i==0){
				ans[i] = nums[i];
			}
			else{

				int notChoose =  ans[i-1];
				int choose = 0;

				int j = i;
				while( j >= 0 && ( nums[j] == num || nums[j] == num -1)){
					if(nums[j] == num){
						choose += num;
					}
					j--;
				}

				if(j >= 0){
					choose += ans[j];
				}

				ans[i] = Integer.max(choose, notChoose);
			}
		}
		return ans[nums.length-1];
	}

}
