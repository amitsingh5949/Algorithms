package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

	public static void main(String[] args) {
		System.out.println(new _78_Subsets().subsets(new int[] {1,2,3}));
	}

	
	// for loop method with backtracking
	List<List<Integer>> res = null;

	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<List<Integer>>();
		subsets(0,nums,new ArrayList<Integer>());
		return res;
	}

	public void subsets(int pos, int[] nums, List<Integer> temp) {

		res.add(new ArrayList<>(temp));

		for(int i=pos; i<nums.length; i++) {
			temp.add(nums[i]);
			subsets(i+1, nums, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	//choose , not choose method
	class Solution {
	    List<List<Integer>>  res;
	    public List<List<Integer>> subsets(int[] nums) {
	        res = new ArrayList<>();
	        res.add(new ArrayList<>());
	        helper(nums,0, new ArrayList<>());
	        return res;
	    }
	    
	    public void helper(int[] nums, int index, List<Integer> l){
	        if(index >= nums.length) return;
	        
	        // choose case
	        l.add(nums[index]);
	        res.add(new ArrayList<>(l));
	        helper(nums, index+1, l);
	        l.remove(l.size()-1);
	        
	        //not choose case
	        helper(nums, index+1, l);
	        
	    }
	    
	}
	
	//iterative solution, if we have answer for [1,2] and we need answer for [1,2,3] then add 3 in all list of [1,2]
	public List<List<Integer>> subsetsItr(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add( new ArrayList<>());

        for(int i=0; i<nums.length; i++){
            int size = res.size();
            for(int j=0; j<size; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        
        return res;
    }
	
	// bit manipulation method
}
