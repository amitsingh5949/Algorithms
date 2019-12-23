package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//one number can be used only once
public class _40_CombinationSumII {

	public static void main(String[] args) {
		System.out.println(new _40_CombinationSumII().
				combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
	}

	List<List<Integer>> result = null;
	public List<List<Integer>> combinationSum2(int[] candidates, 
			int target) {
		result = new ArrayList<List<Integer>>();
		Arrays.parallelSort(candidates);
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
			if(i!=pos && candidates[i-1]==candidates[i]) continue;
			currSum += candidates[i];
			temp.add(candidates[i]);
			combinationSum(i+1, currSum, candidates, target, temp);
			int x  = temp.remove(temp.size()-1);
			currSum -= x;
		}
	}

}
