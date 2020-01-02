package com.javadwarf.heap.sort;

public class HeapSort {

	public static Integer[] array = null; 

	public static void main(String[] args) {
		Integer[] arr = {23,45,67,1,3,56,34,12,77};
		for(Integer u : arr) {
			System.out.print( u +" ");
		}
		arr = sort(arr);
		System.out.println();
		for(Integer u : arr) {
			System.out.print( u +" ");
		}
	}

	public static Integer[] sort(Integer[] arr) {
		array = arr;
		Integer endIndex = arr.length-1;
		heapify(endIndex);
		while(endIndex > 0) {
			swap(0, endIndex);
			endIndex--;
			percolateDown(0, endIndex);
		}
		arr = array;
		array = null;
		return arr;
	}

	public static void heapify(Integer endIndex) {
		Integer parentIndex = getParentIndex(endIndex);
		while(parentIndex >= 0) {
			percolateDown(parentIndex, endIndex);
			parentIndex--;
		}
	}

	public static void percolateDown(Integer index, Integer endIndex) {

		Integer leftIndex = getLeftIndex(index, endIndex);
		Integer rightIndex = getRightIndex(index, endIndex);

		if(leftIndex != -1 && array[leftIndex]>array[index] && 
				(rightIndex == -1 || array[leftIndex]>=array[rightIndex])) {
			swap(index, leftIndex);
			percolateDown(leftIndex, endIndex);
		}
		else if(rightIndex != -1 && array[rightIndex]>array[index] && 
				(leftIndex == -1 || array[leftIndex]<array[rightIndex])) {
			swap(index, rightIndex);
			percolateDown(rightIndex, endIndex);
		}
	}

	public static Integer getParentIndex(Integer endIndex) {
		Integer parentIndex = (endIndex-1)/2;
		if(parentIndex < 0) {
			return -1;
		}
		return parentIndex;
	}

	public static Integer getLeftIndex(Integer index, Integer endIndex) {

		Integer leftIndex = index*2 + 1;
		if(leftIndex < 0 || leftIndex > endIndex) {
			return -1;
		}
		return leftIndex;
	}

	public static Integer getRightIndex(Integer index, Integer endIndex) {

		Integer rightIndex = index*2 + 2;
		if(rightIndex < 0 || rightIndex > endIndex) {
			return -1;
		}
		return rightIndex;
	}

	public static void swap(Integer index1, Integer index2) {
		Integer temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
