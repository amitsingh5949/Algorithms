package com.javadwarf.stackbasics.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _503_NextGreaterElementII {

	public static void main(String[] args) {

	}

	public int[] nextGreaterElements(int[] nums) {

		if(nums==null || nums.length==0) return nums;

		Map<Integer, Integer> map = new HashMap<>();

		Stack<Integer> s = new Stack<>();

		for(int i= 0; i<nums.length; i++) {

			while(!s.isEmpty() && nums[i] > nums[s.peek()]) {
				map.put(s.pop(), nums[i]);
			}
			s.push(i);
		}

		for(int i= 0; i<nums.length; i++) {

			while(!s.isEmpty() && nums[i] > nums[s.peek()]) {
				int top = s.pop();
				if(!map.containsKey(top)) {
					map.put(top, nums[i]);
				}
			}
			s.push(i);
		}

		for(int i= 0; i<nums.length; i++) {
			nums[i] = map.containsKey(i)?map.get(i):-1; 
		}

		return nums ;
	}

}
