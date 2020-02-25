package com.java.binaryserach.leetcode;

public class _1060_MissingElementinSortedArray {

	public static void main(String[] args) {
		
		System.out.println(new _1060_MissingElementinSortedArray().missingElement(new int[] {4,7,9,10}, 1));
		System.out.println(new _1060_MissingElementinSortedArray().missingElement(new int[] {4,7,9,10}, 3));
		System.out.println(new _1060_MissingElementinSortedArray().missingElement(new int[] {1,2,4}, 3));
		System.out.println(new _1060_MissingElementinSortedArray().missingElement(new int[] {3,5,7,9,10}, 1));
		System.out.println(new _1060_MissingElementinSortedArray().missingElement(new int[] {3,5,7,9,10}, 2));

	}
	
	// idea is to find the number of missing elements left to the current index 

	public int missingElement(int[] nums, int k) {

		int totalNumberOfMissingElemnts = getMissingElement(nums.length-1, nums); // last element - first element + size of array -1

		if(k > totalNumberOfMissingElemnts) {
			return  nums[nums.length-1] + (k - totalNumberOfMissingElemnts);
		}

		int left = 0;
		int right = nums.length-1;

		int mid = (left+right)/2;

		while(left < right) {

			mid = (left+right)/2;

			int totalNumberOfMissingElemntsOnLeft = getMissingElement(mid, nums);

			if(totalNumberOfMissingElemntsOnLeft < k) {
				left = mid+1;
			}
			else {
				right = mid;
			}
		}
		return nums[left-1] + k - getMissingElement(left-1, nums);
	}

	public int getMissingElement(int index, int[] nums){
		return nums[index] - nums[0] - index;
	}

}
