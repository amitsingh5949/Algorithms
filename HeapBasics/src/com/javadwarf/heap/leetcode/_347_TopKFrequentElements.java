package com.javadwarf.heap.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * For Kth largest element:
 * 
 * 1. If the question gives the array and ask for kth largest, then perform heapify operation on array 
 *       in-place and convert unsorted array in max heap , then remove k elements.
 *    No extra space needed T(O(nlog(n)))
 *       
 * 2. If in the question, input is a stream of unsorted numbers and Kth Largest number is asked then
 *    create min heap of k length (Kth largest on 0, K+1 largest on 1,... largest number on Kth index)
 *    a. initially, array would be empty so insert into array by siftup(last) until array is filled
 *       Now we will have min heap of k elements, arr[0] will give the kth largest element
 *    b. Now if next number in stream is smaller or equal than arr[0] then discard it because
 *       we already have K largest numbers so far in stream and smaller number
 *       is not will not affect that.
 *    c. If number is greater than arr[0], then replace arr[0] with new number and percolatedown(0)
 *    
 *  3. There is Avg. O(n) time efficient solution available using quick sort, not implemented yet
 *          
 */

public class _347_TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(new _347_TopKFrequentElements().findKthLargest(new int[] {3,2,3,1,2,4,5,5,6},4));
	}

	//*******methhod 3
	public int findKthLargest3(int[] nums, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for(int i=0; i<nums.length; i++) {
			if(i<k) {
				minHeap.add(nums[i]);
			}
			else {
                if(!(nums[i]<minHeap.peek())) {
                	minHeap.poll();
                	minHeap.add(nums[i]);
                }
			}
		}
		return minHeap.poll().intValue();
	}

	//***************method 2 *****************************

	public int findKthLargest(int[] nums, int k) {
		int[] minHeap = new int[k];

		for(int i=0; i<nums.length ;i++) {
			if(i < k) {
				minHeap[i] = nums[i];
				siftUp(minHeap,i);
			}
			else if(i>=k && nums[i]>minHeap[0]){
				minHeap[0] = nums[i];
				siftDown(minHeap, 0, minHeap.length-1);
			}
		}
		return minHeap[0];
	}

	private void siftUp(int[] heap, int i) {
		int p = (i-1)/2;
		if(p>=0 && heap[p] > heap[i]) {
			int t = heap[p];
			heap[p] = heap[i];
			heap[i] = t;
			siftUp(heap, p);
		}
	}

	private void siftDown(int[] nums, int i, int endIndex) {
		int l = i*2 + 1;
		int r = i*2 + 2;

		if(l<=endIndex && nums[l]<nums[i] && (r>endIndex||nums[l]<=nums[r])) {
			int temp = nums[l];
			nums[l] = nums[i];
			nums[i] = temp;
			siftDown(nums, l, endIndex);
		}
		else if(r<=endIndex && nums[r]<nums[i] && (l>endIndex||nums[r]<nums[l])) {
			int temp = nums[r];
			nums[r] = nums[i];
			nums[i] = temp;
			siftDown(nums, r, endIndex);
		}
	}

	//********************** Method 1 *************************************************************************

	public int findKthLargest1(int[] nums, int k) {
		int result = 0;
		heapify(nums);
		int endIndex = nums.length-1;
		for(int i = 1; i<=k; i++) {
			result = remove(nums, endIndex);
			endIndex--;
		}
		return result;
	}

	private void heapify(int[] nums) {
		int p = (nums.length-1 - 1)/2;
		while(p>=0) {
			percolateDown(nums, p,nums.length-1);
			p--;
		}
	}

	private int remove(int[] nums,int endIndex) {
		int result = nums[0];
		nums[0]  = nums[endIndex];
		nums[endIndex] = -1;
		endIndex--;
		percolateDown(nums, 0, endIndex);
		return result;
	}

	private void percolateDown(int[] nums, int i, int endIndex) {
		int l = i*2 + 1;
		int r = i*2 + 2;

		if(l<=endIndex && nums[l]>nums[i] && (r>endIndex||nums[l]>=nums[r])) {
			int temp = nums[l];
			nums[l] = nums[i];
			nums[i] = temp;
			percolateDown(nums, l, endIndex);
		}
		else if(r<=endIndex && nums[r]>nums[i] && (l>endIndex||nums[r]>nums[l])) {
			int temp = nums[r];
			nums[r] = nums[i];
			nums[i] = temp;
			percolateDown(nums, r, endIndex);
		}
	} 
}
