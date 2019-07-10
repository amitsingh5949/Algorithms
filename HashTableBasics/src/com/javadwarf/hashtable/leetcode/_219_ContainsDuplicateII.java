package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicateII {

	public static void main(String[] args) {

	}
	// idea is to replace the indexes of number in map if found or not as go right in array 
	// because later index will give more chances of  i -j <= k
	
	// we can use set also, we have to ensure to remove the elements which can never give difference atmost k
	//if (set.size() > k) {
    //     set.remove(nums[i - k]);
    //}
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		for(int i =0; i<nums.length ;i++) {
			if(map.containsKey(nums[i]) && (i-map.get(nums[i])) <= k) 
				return true;
			map.put(nums[i], i);
		}

		return false;

	}

}
