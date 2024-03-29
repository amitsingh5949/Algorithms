package com.java.binaryserach.leetcode;

public class _154_FindMinimuminRotatedSortedArrayII {
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

	//same logic as 153 ,just extra == condition for when mind equals end(at this point we don't know where to go, move end by 1 )
	//complexity o(N) and o(1)
	public int findMin(int[] nums) {

		if(nums == null || nums.length == 0 ) return 0;

		int start = 0;
		int end = nums.length -1;
		int mid = start + (end- start)/2;

		while(start < end){

			mid = start + (end - start)/2;

			if(start == mid) return Integer.min(nums[start], nums[end]);

			if( nums[mid] < nums[end]){
				end = mid;
			}
			else if(nums[mid] > nums[end]){
				start = mid;
			}
			else if( nums[mid] == nums[end]){
				end = end-1;
			}

		}
		return nums[start];

	}

	//below solutions doesn't work

	// basically find the pivot, same as finding pivot in search in rotated sorted array question using logic  if(nums[mid] > nums[mid+1]) result = mid+1;

	public int findMin11(int[] nums) {

		if(nums==null || nums.length==0) return 0;

		if(nums[0]<=nums[nums.length-1]) return nums[0];


		int result = 0;

		int start = 0 ;
		int end = nums.length-1;
		int mid = start + (end- start)/2;

		while(start <= end) {
			mid = start + (end- start)/2;
			if(nums[mid] > nums[mid+1]) { // magic line this is what we need to remember to find pivots
				result = mid+1;
				break;
			}
			else if(nums[start] <= nums[mid]){
				start = mid + 1;
			}
			else if(nums[start] > nums[mid]) {
				end = mid - 1;
			}
		}
		return nums[result];

	}



	public int findMin1(int[] nums) {

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
				start++;
				end--;
			}
			else if(nums[mid] > nums[result]){
				start = mid +1;
			}
			else if(nums[mid] < nums[result]) {
				end = mid -1;
				result = mid;
			}
		}
		return nums[result];
	}

}
