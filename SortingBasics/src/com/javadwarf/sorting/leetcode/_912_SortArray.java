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
