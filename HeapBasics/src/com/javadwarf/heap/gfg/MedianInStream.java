package com.javadwarf.heap.gfg;

import java.util.Scanner;

public class MedianInStream {

	public static int[] minHeap = null;
	public static int[] maxHeap = null;
	public static int countMin = 0;
	public static int countMax = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		minHeap = new int[n];
		maxHeap = new int[n];
		countMin = 0;
		countMax = 0;
		for(int x=1; x<=n; x++) {
			System.out.print(median(s.nextInt()) + " ");
		}
		s.close();
	}

	private static int median(int x) {
		int median = 0;

		if(countMin==0) {
			minHeap[countMin++] = x;
		}
		else {
			if(minHeap[countMin-1] > x) {
				maxHeap[countMax] = x;
				siftupMax(maxHeap, countMax);
				countMax++;	
			}
			else {
				int temp = minHeap[0];
				minHeap[0] = x;
				siftdownMin(minHeap, 0, countMin);
				maxHeap[countMax] = temp;
				siftupMax(maxHeap, countMax);
				countMax++;
			}
			if(countMax-countMin > 1) {
				int temp = maxHeap[0];

				maxHeap[0] = maxHeap[countMax-1];
				maxHeap[countMax-1] = 0;
				countMax--;
				siftdownMax(maxHeap, 0, countMax);

				minHeap[countMin] = temp;
				siftupMin(minHeap, countMin);
				countMin++;
			}
		}
		if(countMin < countMax ) {
			median = maxHeap[0];
		}
		else if(countMin > countMax ) {
			median = minHeap[0];
		}
		else {
			median =  (minHeap[0] + maxHeap[0])/2;
		}
		return median;
	}

	private static void siftupMin(int[] heap, int currIndex) {
		int parent = (currIndex-1)/2;
		if(parent>=0 && heap[currIndex]<heap[parent]) {
			int temp = heap[parent];
			heap[parent] = heap[currIndex];
			heap[currIndex] = temp;
			siftupMin(heap, parent);
		}
	}

	private static void siftupMax(int[] heap, int currIndex) {
		int parent = (currIndex-1)/2;
		if(parent>=0 && heap[currIndex]>heap[parent]) {
			int temp = heap[parent];
			heap[parent] = heap[currIndex];
			heap[currIndex] = temp;
			siftupMax(heap, parent);
		}
	}

	private static void siftdownMin(int[] heap, int currIndex, int lastIndex) {

		int left = -1;
		int right = -1;

		if(currIndex*2+1<lastIndex) {
			left = currIndex*2+1;
		}
		if(currIndex*2+2<lastIndex) {
			right = currIndex*2+2;
		}

		if( (left != -1 && right !=-1 && heap[left]<=heap[right] && heap[left]<heap[currIndex]) ||
				(left != -1 && right == -1 && heap[left]<heap[currIndex]) ) {
			int temp = heap[left];
			heap[left] = heap[currIndex];
			heap[currIndex] = temp;
			siftdownMin(heap, left,lastIndex);
		}
		else if( (left != -1 && right !=-1 && heap[left]>heap[right] && heap[right]<heap[currIndex]) ||
				(left == -1 && right != -1 && heap[right]<heap[currIndex]) ) {
			int temp = heap[right];
			heap[right] = heap[currIndex];
			heap[currIndex] = temp;
			siftdownMin(heap, right,lastIndex);
		}
	}

	private static void siftdownMax(int[] heap, int currIndex, int lastIndex) {

		int left = -1;
		int right = -1;

		if(currIndex*2+1<lastIndex) {
			left = currIndex*2+1;
		}
		if(currIndex*2+2<lastIndex) {
			right = currIndex*2+2;
		}

		if( (left != -1 && right !=-1 && heap[left]>=heap[right] && heap[left]>heap[currIndex]) ||
				(left != -1 && right == -1 && heap[left]>heap[currIndex]) ) {
			int temp = heap[left];
			heap[left] = heap[currIndex];
			heap[currIndex] = temp;
			siftdownMax(heap, left,lastIndex);
		}
		else if( (left != -1 && right !=-1 && heap[left]<heap[right] && heap[right]>heap[currIndex]) ||
				(left == -1 && right != -1 && heap[right]>heap[currIndex]) ) {
			int temp = heap[right];
			heap[right] = heap[currIndex];
			heap[currIndex] = temp;
			siftdownMax(heap, right,lastIndex);
		}
	}
}
