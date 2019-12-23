package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {

	public static void main(String[] args) {
		System.out.println(new _90_SubsetsII().subsetsWithDup(new int[] {1,2,2}));
	}
	
	List<List<Integer>> res = null;
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		res = new ArrayList<List<Integer>>();
		Arrays.parallelSort(nums);
		subsets(0,nums,new ArrayList<Integer>());
		return res;
	}

	public void subsets(int pos, int[] nums, List<Integer> temp) {

		res.add(new ArrayList<>(temp));

		for(int i=pos; i<nums.length; i++) {
			if(i!=pos && nums[i-1] == nums[i]) continue; // skip duplicates 
			temp.add(nums[i]);
			subsets(i+1, nums, temp);
			temp.remove(temp.size()-1);
		}

	}
}
