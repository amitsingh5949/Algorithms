package com.javadwarf.stackbasics.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_NextGreaterElementI {

	public static void main(String[] args) {

	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<>();

		Stack<Integer> s = new Stack<>();
		s.add(0);

		for(int i = 1; i<nums2.length; i++) {
			while(!s.isEmpty() && nums2[i] > nums2[s.peek()]) {
				map.put(nums2[s.pop()], nums2[i]);
			}
			s.push(i);
		}
		
		for(int j= 0; j<nums1.length; j++) {
			nums1[j] = (map.get(nums1[j])!=null) ? map.get(nums1[j]) : -1;
		}
		return nums1;
	}

}
