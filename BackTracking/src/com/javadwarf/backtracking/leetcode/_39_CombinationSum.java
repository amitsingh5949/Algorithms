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
}
