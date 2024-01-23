package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.ArrayList;
import java.util.List;

public class _300_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		//System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLISBS(new int[] {1,3,6,7,9,4,10,5,6}));
		System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLIS(new int[] {3,5,6,2,5,4,19,5,6,7,12}));
		System.out.println(new _300_LongestIncreasingSubsequence().lengthOfLISBS(new int[] {3,5,6,2,5,4,19,5,6,7,12}));
	}


	
	// DP based solution - O(n^2) and O(n)
	public int lengthOfLIS(int[] nums) {

		if(nums == null || nums.length == 0) return 0;

		int result = 1;

		int[] output = new int[nums.length];

		for(int i=0; i<nums.length; i++) {

			output[i] = 1;

			for(int j=i-1; j>=0; j--) {
				if(nums[j] < nums[i]) {
					output[i] = Integer.max(output[i], output[j] + 1);
					result = Integer.max(result, output[i]);
				}
			}
		}
		return result;
	}
	//same as above but different style of writing  - O(n^2) and O(n)
	public int lengthOfLISAgainWithDP(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for( int i=1; i<nums.length;i++){
            int temp = 0;
            for(int j =0; j<i; j++){
                if(nums[j] < nums[i]){
                    temp = Math.max(temp, dp[j]);    
                }
            }
            dp[i] = 1 + temp;
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }


	// Binary Search based solution - O(nlogn) and o(n)
	
	/*
	 * Algorithm

		Initialize an array sub which contains the first element of nums.
		
		Iterate through the input, starting from the second element. For each element num:
		
		a.)If num is greater than largest or last element in sub, then add num to sub.
		b.)Otherwise, iterate through sub and find the first element that is greater than or equal to num. Replace that element with num.
		
		Return the length of sub.
	 */
	public int lengthOfLISBS(int[] nums) {

		if(nums == null || nums.length == 0) return 0;

		int last = 0;
		int[] output = new int[nums.length];
		output[0] = nums[0];

		for(int i=1; i<nums.length; i++) {

			if(output[last] < nums[i]) {
				output[++last] = nums[i];
			}
			else {
				// apply binary search in output array to find place where we need to replace
				int start = 0;
				int end = last;
				int mid = (start + end)/2;

				while(start <= end) {
					mid = (start + end)/2;
					if(output[mid] == nums[i]){
						start = mid;
						break ;
					}
					else if(output[mid] > nums[i]) {
						end = mid-1;
					}
					else {
						start = mid+1;
					}
				}
				output[start] = nums[i];
			}
		}
		return last+1;
	}
	
	// Same binary search solution as above but bit modular
	
	public int lengthOfLISBModular(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        
        for( int i=1; i<nums.length; i++){
            if(nums[i] > lis.get(lis.size()-1)){
                lis.add(nums[i]);
            }            
            else{
                int index = binarySearch(lis, nums[i], 0, lis.size()-1);
                lis.set(index, nums[i]);
            }
        }
        return lis.size();
    }
    
    public int binarySearch(List<Integer> lis, int num, int start, int end){
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(start == mid){
                return lis.get(mid) >= num ? start : end;
            }
            
            if(lis.get(mid) < num){
                start = mid+1;
            }
            else if(lis.get(mid) >= num){
                end = mid;
            }
        }
        return start;
    }
	
	// This won't work as what if we select a bigger number and there are less bigger number that wjat already selected
	// 3,19,4, 5 answer should be 3
	public int lengthOfLIS1(int[] nums) {

		int max = 1;
		int count = 1;
		int val = 0;

		for(int i=0; i<nums.length; i++) {

			count = 1;
			val = nums[i];

			for(int j=i+1; j<nums.length; j++) {

				if(nums[j] >= val) {
					val = nums[j];
					count++;
				}
			}
			max = Integer.max(max, count);
		}
		return max;
	}
}
