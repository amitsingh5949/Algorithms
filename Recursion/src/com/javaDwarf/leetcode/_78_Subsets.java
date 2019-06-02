package com.javaDwarf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

	public static void main(String[] args) {
		//System.out.println(subsets(new int[] {1,2,3}));//[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
		//	System.out.println(subsets(new int[] {1,2,2}));//[[], [1], [2], [1, 2], [2], [1, 2], [2, 2], [1, 2, 2]] - 
		//not working as we can  see we have duplicate lists

		System.out.println(permutation(new int[] {1, 2, 3}));//[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
	}

	// creating power set using recursion
	public static List<List<Integer>> permutation(int[] nums ) {

		List<List<Integer>>  list = new ArrayList<List<Integer>>();

		if(nums == null || nums.length == 0) return list;

		for(int i= 0; i <=nums.length; i++) {
			list = permutation(nums, i,  0, new ArrayList(), list);
		}
		return list;

	}

	public static List<List<Integer>> permutation(int[] nums, int len, int index, List<Integer> l, List<List<Integer>> list) {
		if(len == l.size()) {
			list.add(l);
			return list;
		}

		if(nums.length == index) 
			return list ;


		ArrayList<Integer> l1 = new ArrayList<>(l);
		l1.add(nums[index]);
		list = permutation(nums, len, index+1, l1, list);
		list = permutation(nums, len, index+1, l, list);

		return list;
	}

}
