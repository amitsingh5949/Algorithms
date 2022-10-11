package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {

	public static void main(String[] args) {
		System.out.println(new _39_CombinationSum().
				combinationSum(new int[] {2,3,6,7}, 7));
	}

	// all numbers that sum to targte
	// can use number more than once 
	List<List<Integer>> result = null;
	public List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		result = new ArrayList<List<Integer>>();
		combinationSum(0, 0, candidates, 
				target, new ArrayList<Integer>());
		return result;
	}

	public void combinationSum(int pos, int currSum, 
			int[] candidates, int target, List<Integer> temp ) {

		if(currSum == target) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		else if(currSum > target) {
			return;
		}

		for(int i=pos; i<candidates.length; i++) {
			currSum += candidates[i];
			temp.add(candidates[i]);
			combinationSum(i, currSum, candidates, target, temp);
			int x  = temp.remove(temp.size()-1);
			currSum -= x;
		}
	}
	
	//same as above but more cleaner
	
	 List<List<Integer>> res;
	    public List<List<Integer>> combinationSumCleaner(int[] candidates, int target) {
	        res = new ArrayList<>();
	        helper(candidates, target, 0, new ArrayList<>());
	        return res;
	    }
	    
	    public void helper(int[] candidates, int target, int index, List<Integer> l){
	        if(target < 0) return;
	        if(target == 0){
	            res.add(new ArrayList<>(l));
	            return;
	        }
	        
	        for(int i=index; i<candidates.length; i++){
	            l.add(candidates[i]);
	            helper(candidates, target-candidates[i], i, l);
	            l.remove(l.size()-1);
	        }
	    }
	
	// choose not choose method
	class Solution {
	    List<List<Integer>> res;
	    
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        res = new ArrayList<>();
	        helper(candidates, target, 0, new ArrayList<>());
	        return res;
	    }
	    
	    public void helper(int[] candidates, int target, int index, List<Integer> l){
	        if(target<0 || index >= candidates.length) return;
	        
	        if(target == 0){
	         res.add(new ArrayList<>(l));
	         return;
	        }
	        
	        
	        helper(candidates, target, index+1, l);
	        
	        l.add(candidates[index]);
	        helper(candidates, target-candidates[index], index, l);
	        l.remove(l.size()-1);
	        
	    }
	}
	
}


