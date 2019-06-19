package com.java.binaryserach.leetcode;

public class _153_FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		/*System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {4,5,6,7,0,1,2}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {3,4,5,1,2}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {0}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {1,2,3,4}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {2,1}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {2,2,2,0,1}));*/
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {3,3,3,3,3,3,1,3,3}));
		System.out.println(new _153_FindMinimuminRotatedSortedArray().findMin(new int[] {3,3,1,3,3,3,3,3,3}));
		
	}

	// idea is to compare mid with start(we consider start as smallest , hence call it result) and 
	//now decide which direction to move, if mid > result then move right i.e start = mid +1 
	//if  mid < result then then make mid new result(smallest encountered so far) and move left i.e end = mid -1
	// if mid equals result then break and return result
	public int findMin(int[] nums) {

		if(nums==null || nums.length==0) return 0;
		else if(nums.length==1) return nums[0];
		else if(nums.length==2) return Integer.min(nums[1], nums[0]);

		int result = 0;

		int start = 0 ;
		int end = nums.length-1;
		int mid = start + (end- start)/2;

		while(start <= end) {
			mid = start + (end- start)/2;
			if(nums[mid] == nums[result]) {
				result = mid;
				break;
			}
			else if(nums[mid] > nums[result]){
				start = mid + 1;
			}
			else if(nums[mid] < nums[result]) {
				end = mid - 1;
				result = mid;
			}
		}
		return nums[result];
	}

}
