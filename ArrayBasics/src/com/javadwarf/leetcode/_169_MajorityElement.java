package com.javadwarf.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _169_MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3,2,1}));
		System.out.println(majorityElement(new int[] {3,2,3}));
	}

	//Boyer Moore Algorithm -- O(n) O(1)
	
	/*
	 * logic is to select majority candidate , we select our candidate as first element of array
	 * if next element is same as candidate then increment the candidate count or else decrement
	 * if candidate count ==0 then set current array element as new candidate 
	 */
	public static  int majorityElement(int[] nums) {

		int result = -1;
		int candidate = nums[0];
		int candidateCount = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			if(candidateCount==0) {
				candidate = nums[i];
				candidateCount = 0;
			}
			
			if(nums[i]==candidate) {
				candidateCount++;
			}
			else {
				candidateCount--;
			}
		}

		candidateCount = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == candidate){
				candidateCount++;
			}
		}
		
		if(candidateCount > nums.length/2) {
			result = candidate;
		}
		
		return result;
	}



	// using sorting
	public static  int majorityElement2(int[] nums) {
		Arrays.sort(nums);

		int maxKey = nums[0];
		int maxVal = 1;
		int key = nums[0];
		int currVal = 1;

		for(int i = 1; i<nums.length; i++) {

			if(nums[i] == key) {
				currVal++;
			}
			else {
				if(currVal>maxVal) {
					maxVal = currVal;
					maxKey = key;
				}
				currVal = 1 ;
				key = nums[i];
			}
		}
		if(currVal>maxVal) {
			maxVal = currVal;
			maxKey = key;
		}
		return maxKey;

		/*
		 * or After sorting, we can simply do : return nums[nums.length/2]; 
		 */
	}

	// using hash map - works but stupid 
	public int majorityElement1(int[] nums) {
		int result = Integer.MIN_VALUE;
		int val = Integer.MIN_VALUE;

		HashMap<Integer, Integer> map = new  HashMap<>();

		for(int i = 0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
			else {
				map.put(nums[i], 1);
			}
			if(map.get(nums[i])>val) {
				val = map.get(nums[i]);
				result = nums[i];
			}
		}
		return result;
	}

}
