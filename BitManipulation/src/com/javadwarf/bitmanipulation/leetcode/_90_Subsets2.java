package com.javadwarf.bitmanipulation.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _90_Subsets2 {

	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,2}));//[[], [1], [2], [1, 2], [2], [1, 2], [2, 2], [1, 2, 2]] - 
															//not working as we can  see we have duplicate lists
	}

	public static List<List<Integer>> subsets(int[] nums) {
		
		Arrays.sort(nums);

		Set<List<Integer>>  list = new HashSet<List<Integer>>();

		if(nums == null || nums.length == 0) return null;

		int count = (int)Math.pow(2.0, nums.length*1.0) -1;

		for(int i=0; i<=count; i++) {

			List<Integer> l = new ArrayList<Integer>();

			for(int j=0; j<nums.length; j++) {

				if((i & (1 << j)) !=0) {
					l.add(nums[j]); 
				}
			}
			list.add(l);
		}

		return new ArrayList<List<Integer>>(list);

	}

}
