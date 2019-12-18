package com.javadwarf.leetcode.kadane;

public class _560_SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		int[] arr1 = {-1,-1,1};
		int[] arr2 = {28,54,7,-70,22,65,-6};

		System.out.println(new _560_SubarraySumEqualsK().subarraySum(arr, 2));
		//System.out.println(new _560_SubarraySumEqualsK().subarraySum(arr1, 0));
		//System.out.println(new _560_SubarraySumEqualsK().subarraySum(arr2, 100));

	}
	
	//o(n) and o(n)
	public int subarraySum(int[] nums, int k) {
		
		int count = 0 ;
		
		for(int i=0; i<nums.length; i++){
			
			int sum = 0;
			
			for(int j=i; j<nums.length; j++) {
				sum += nums[j];
				if(sum == k) {
					count++;
				}
			}
		}
		return count;
	}
	
	// brute force - o(n^2)
	public int subarraySum2(int[] nums, int k) {
		
		int count = 0 ;
		
		for(int i=0; i<nums.length;i++) {
			
			int sum = 0;
			
			for(int j =i; j<nums.length; j++) {
				sum += nums[j];
				if(sum == k) {
					count++;
				}
			}
		}
		return count;
	}

	
	//tried sliding window wont work 
	public int subarraySum_SW(int[] nums, int k) {

		int start = 0;
		int end = 0;

		int count  = 0;
		int curr = 0;

		while(end < nums.length) {
			curr  += nums[end];
			while((end == nums.length-1 || curr >= k) && start < nums.length) {
				if(curr == k) {
					count++;
				}
				curr -= nums[start];
				start++;
			}
			end++;
		}

		return count;

	}

}
