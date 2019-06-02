package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _47_Permutations {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] {1,1,2}));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>>  list = new ArrayList<List<Integer>>();

		if(nums == null || nums.length == 0) return list;

		Arrays.parallelSort(nums);

		List<Integer> l = new ArrayList<>();
		List<Integer> uniqueNums = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		LinkedList<Integer> currList = new LinkedList<Integer>();

		for(int i :  nums) {
			l.add(i);
			if(map.containsKey(i)){
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
				uniqueNums.add(i);
			}
		}
		
		list = permuteUnique(l, uniqueNums, currList, map, list);

		return list;
	}
	
	public static List<List<Integer>> permuteUnique(List<Integer> nums, List<Integer> uniqueNums, LinkedList<Integer> currList, Map<Integer, Integer> map, List<List<Integer>>  list ) {
		
		if(nums.size() == currList.size()) {
			list.add(new ArrayList<>(currList));
			return list;
		}
		
		for(int i : uniqueNums) {
			if(map.get(i) > 0) {
				currList.addLast(i);
				map.put(i, map.get(i) - 1);
				list = permuteUnique(nums,uniqueNums, currList, map, list);
				map.put(i, map.get(i) + 1);
				currList.removeLast();
			}
		}
		return list;
	}


	


}
