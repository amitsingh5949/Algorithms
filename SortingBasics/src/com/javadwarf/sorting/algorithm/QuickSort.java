package com.javadwarf.sorting.algorithm;

class QuickSort {

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

	// 1. based on the pivot selection strategy, select a pivot and swap it with end index
	// 2. move left from pivot to index 0 and find the smaller element than pivot
	// 3. move from 0 towards pivot, find element which is greater than pivot
	// 4. swap (i,j) or swap(i, pivot) based on left and right have met or not
	
	int partition(int arr[], int low, int high){
		//different strategies to select pivot
		//int random = low + (high -low)/2;
		//int random = high;
		int random = (int)Math.floor(Math.random()*(high-low+1)+low);
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
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void printArray(int arr[]){
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}


}
