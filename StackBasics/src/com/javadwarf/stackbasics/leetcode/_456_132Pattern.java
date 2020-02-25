package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _456_132Pattern {

	public static void main(String[] args) {
		System.out.println(new _456_132Pattern().find132pattern(new int[] {1, 2, 3, 4}));
		System.out.println(new _456_132Pattern().find132pattern(new int[] {3, 1, 4, 2}));
		System.out.println(new _456_132Pattern().find132pattern(new int[] {-1, 3, 2, 0}));
	}
	
	public boolean find132pattern(int[] nums) {
		
		if(nums == null || nums.length < 3) return false;
		
		int[] min = new int[nums.length];
		min[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			min[i] = Math.min(min[i-1], nums[i]);
		}
		
		Stack<Integer> s = new Stack<>();
		
		for(int i=nums.length-1; i>=0; i--) {
			
			if(nums[i] > min[i]) {
				
				while(!s.isEmpty() && min[i] >= s.peek()) {
					s.pop();
				}
				
				if(!s.isEmpty() && nums[i] > s.peek()) {
					return true;
				}
				s.push(nums[i]);
			}
		}
		return false;
	}

	// Wrong approach fails for test case [3,5,0,3,4]
	public boolean find132pattern1(int[] nums) {

		if(nums == null || nums.length < 3) return false;

		int min = nums[0];
		int max = nums[0];


		for(int i=1; i<nums.length; i++) {

			if(nums[i] <= min) {
				min = nums[i];
				max = nums[i];
			}
			else if(nums[i] > max) {
				max = nums[i];
			}
			else if(nums[i] > min && nums[i]< max) {
				return true;
			}

		}
		return false;

	}

}
