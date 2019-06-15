package com.javadwarf.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _350_IntersectionofTwoArraysII {

	public static void main(String[] args) {

		intersect(new int[] {1,2,2,1}, new int[] {2,2});
		System.out.println();
		intersect(new int[] {1,2,2,1}, new int[] {2});
		
	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> l = new ArrayList<>();

		if(nums1 == null || nums2== null || nums1.length==0 || nums2.length ==0 ) return new int[] {};

		Arrays.parallelSort(nums1);
		Arrays.parallelSort(nums2);

		int x = 0;
		int y = 0;


		while(x<nums1.length && y<nums2.length ) {
			if(nums2[y] == nums1[x]) {
				l.add(nums2[y]);
				x++;
				y++;
			}
			else if(nums2[y] < nums1[x]) {
				y++;
			}
			else {
				x++;
			}
		}


		int[] result = new int[l.size()];
		for(int i=0; i< result.length; i++) {
			result[i] = l.get(i);
			System.out.print(result[i] + " ");
		}
		return result;

	}

}
