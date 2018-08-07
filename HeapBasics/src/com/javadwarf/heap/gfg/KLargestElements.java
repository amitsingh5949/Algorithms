package com.javadwarf.heap.gfg;

import java.util.Scanner;

public class KLargestElements {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int k = s.nextInt();
			int[] heap = new int[k];
			int n = s.nextInt();
			for(int x=0; x<n; x++) {
				int curr = s.nextInt();
				if(x < k-1) {
					heap[x] = curr;
					siftup(heap,x);
					System.out.print("-1 ");
				}
				else if(x == k-1) {
					heap[x] = curr;
					siftup(heap,x);
					System.out.print(heap[0]+" ");
				}
				else {
					if(curr > heap[0]) {
						heap[0] = curr;
						siftdown(heap,0);
					}
					System.out.print(heap[0]+" ");
				}
			}
			System.out.println();
		}
		s.close();
	}

	private static void siftup(int[] heap, int currIndex) {
		int parent = (currIndex-1)/2;
		if(parent>=0 && heap[currIndex]<heap[parent]) {
			int temp = heap[parent];
			heap[parent] = heap[currIndex];
			heap[currIndex] = temp;
			siftup(heap, parent);
		}
	}

	private static void siftdown(int[] heap, int currIndex) {

		int left = -1;
		int right = -1;

		if(currIndex*2+1<heap.length) {
			left = currIndex*2+1;
		}
		if(currIndex*2+2<heap.length) {
			right = currIndex*2+2;
		}

		if( (left != -1 && right !=-1 && heap[left]<=heap[right] && heap[left]<heap[currIndex]) ||
				(left != -1 && right == -1 && heap[left]<heap[currIndex]) ) {
			int temp = heap[left];
			heap[left] = heap[currIndex];
			heap[currIndex] = temp;
			siftdown(heap, left);
		}
		else if( (left != -1 && right !=-1 && heap[left]>heap[right] && heap[right]<heap[currIndex]) ||
				(left == -1 && right != -1 && heap[right]<heap[currIndex]) ) {
			int temp = heap[right];
			heap[right] = heap[currIndex];
			heap[currIndex] = temp;
			siftdown(heap, right);
		}
	}
}
