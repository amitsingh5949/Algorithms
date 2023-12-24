package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _46_Permutations {

	public static void main(String[] args) {
		System.out.println(permute(new int[] {1,2,3}));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>  list = new ArrayList<List<Integer>>();

		if(nums == null || nums.length == 0) return list;

		Arrays.parallelSort(nums);

		List<Integer> l = new ArrayList<>();

		for(int i :  nums) {
			l.add(i);
		}

		list = permute(l, 0, list);
		return list;
	}


	public static List<List<Integer>> permute(List<Integer> nums, int index, List<List<Integer>> list ) {

		if(nums.size() == index) {
			list.add(nums);
			return list;
		}

		for(int i=index; i <nums.size(); i++) {
			nums = swap(nums, i, index);
			list = permute(nums, (index + 1), list);
		}

		return list;
	}

	private static List<Integer> swap(List<Integer> nums, int i, int index) {
		List<Integer> output = new ArrayList<Integer>(nums);
		Collections.swap(output, i, index);
		return output;
	}
	
	// not sure about above approach, below is like dfs approach with visited array

	 List<List<Integer>> res;
	    
	    public List<List<Integer>> permuteDFS(int[] nums) {
	        res = new ArrayList<>();
	        helper(nums, 0, new boolean[nums.length], new ArrayList<>());
	        return res;
	    }
	    
	    public void helper( int[] nums, int i, boolean[] visited, List<Integer> l ){
	        if(i==nums.length){
	            res.add( new ArrayList<>(l));
	            return;
	        }
	        for( int j=0; j<nums.length;j++){
	            if(!visited[j]){
	                visited[j] = true;
	                l.add(nums[j]);
	                helper(nums, i+1, visited, l);
	                visited[j] = false;
	                l.remove(l.size()-1);
	            }
	        }
	    }

}

