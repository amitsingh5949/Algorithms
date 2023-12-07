package com.javadwarf.sorting.leetcode;

public class _912_SortArray {


	public int[] sortArray(int[] nums) {
		sort(nums, 0, nums.length-1);
		return nums;
	}

	void sort(int arr[], int low, int high){
		if(low >= high) return;
		int pivot = partition(arr, low, high);
		sort(arr, low, pivot-1);
		sort(arr, pivot+1, high);
	}


	int partition(int arr[], int low, int high){

		int random = (int)Math.floor(Math.random()*(high-low+1)+low);

		//int random = low + (high -low)/2;
		swap(arr, random, high);


		int pivot = high; 
		int i = low;
		int j = high;    
		while(i != j){
			while(i<high && arr[i] <= arr[pivot]){
				i++;
			}
			while(j>i && arr[j] >= arr[pivot]){
				j--;
			}
			if(i == j){
				swap(arr, i, pivot);
			}
			else{
				swap(arr, i, j);
			}
		}
		return i;
	}

	//above partition can be implemented below, same logic but without using for loop
	// once we move pivot to end, we have array of size (start, end-1) , end is pivot fixed, would swap in end when its true position is determined
	// two pointer approach, end -1 pointer will swap with start pointer for all smaller elements in the process, bigger elements will directly come to end

	public int findPivotPosition(int[] nums, int b, int e){
		int p = (int)Math.random()*((e-b)+1)+b;
		swap(nums, p,e);

		int i=b, j=e-1;
		while(i <= j){
			if(nums[j] <= nums[e]) {
				swap(nums, i,j);
				i++;
			}
			else j--;
		}

		swap(nums, i, e);
		return i;
	}

	void swap(int arr[],int i,int j){
		//Your code here
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}


}

//Same as above but different helper function

class Solution {
	public int[] sortArray(int[] nums) {
		return quicksort(nums, 0, nums.length-1);
	}

	public int[] quicksort(int[] nums, int start, int end){
		if(start >= end) return nums;
		//int pivot = start + (end-start)/2;
		int pivot = (int)(Math.random() * (end-start+1)) + start; 
		swap(nums, pivot, end);
		int pos = helper(nums, start, end);
		quicksort(nums, start, pos-1);
		quicksort(nums, pos+1, end);
		return nums;
	}

	// move left if left smaller or equal than pivot 
	//  else swap left and right and move right
	public int helper(int[] nums, int start, int end){
		int pivot = end;
		int left = start;
		int right = end-1;

		while(left <= right){
			if(nums[left] < nums[pivot]){
				left++;
			}
			else{
				swap(nums, left, right);
				right--;
			}
		}
		swap(nums, left, pivot);
		return left;
	}

	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
