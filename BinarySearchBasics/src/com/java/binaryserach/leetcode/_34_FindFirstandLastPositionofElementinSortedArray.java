package com.java.binaryserach.leetcode;

public class _34_FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		int[] arr = searchRange(new int[] {5,7,7,8,8,10}, 8);

		//int[] arr = searchRange(new int[] {1}, 1);
		System.out.println(arr[0] +" "+ arr[1]);
	}


	

	/**********************************************************************************************************************************************/
	// Below approach also works in o(logn) , try reading the code

	public static int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		int start = 0;
		int end = nums.length -1;
		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start +end)/2;

			if(nums[mid] == target) {
				result[0] = findStart(nums, start, mid, target);
				result[1] = findEnd(nums, mid, end, target);
				break;
			}
			else if(target < nums[mid]) {
				end = mid - 1;
			}
			else if(target > nums[mid]) {
				start = mid + 1;
			}
		}

		return result;

	}

	// first occurrence will be found when arr[start] == target
	public static int findStart(int[] nums, int start, int end, int target) {
		int result = end;

		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start + end)/2;

			if(nums[start] == target) {
				result = start;
				break;
			}

			if(nums[mid] == target) {
				end = mid -1;
			}
			else if(target > nums[mid]) {
				start = mid + 1;
			}
		}

		return result;

	}

	// first occurrence will be found when arr[start] == target
	public static int findEnd(int[] nums, int start, int end, int target) {
		int result = start;

		int mid = (start +end)/2;

		while(start<=end) {

			mid = (start + end)/2;

			if(nums[end] == target) {
				result = end;
				break;
			}

			if(nums[mid] == target) {
				start = mid+1;
			}
			else if(target < nums[mid]) {
				end = mid - 1;
			}
		}

		return result;
	}

	/**********************************************************************************************************************************************/
	//Linear scan aaproach :  O(n)

	public static int[] search(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		for(int i=0; i<nums.length; i++) {
			if(nums[i]==target) {
				result[0]  = i;
				result[1]  = i;
				while(i<nums.length && nums[i]==target) {
					result[1]  = i;
					i++;
				}
				break;
			}
		}
		return result;
	}
}
