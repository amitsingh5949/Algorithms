package com.javadwarf.leetcode.subarray;

import java.util.HashMap;
import java.util.Map;

public class _325_MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {

		int[] arr = {1, -1, 5, -2, 3};
		System.out.println(new _325_MaximumSizeSubarraySumEqualsk().maxSubArrayLen(arr, 3));
	}

	public int maxSubArrayLen(int[] nums, int k) {
		
		if (nums==null || nums.length == 0) return 0;
		
		int result = 0 ;
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,-1);// very important step to take care of subarray starting at index 0
		int sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
			map.putIfAbsent(sum, i);// we want to be as left as possible 
			if(map.containsKey(sum-k)) {
				result = Math.max(result, i-map.get(sum-k));
			}
		}
		return result;

	}

}
	