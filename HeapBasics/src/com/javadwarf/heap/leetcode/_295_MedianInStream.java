package com.javadwarf.heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _295_MedianInStream {

	public static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
	public static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int x=1; x<=n; x++) {
			addNum(s.nextInt());
			System.out.println(findMedian());
		}
		s.close();
	}
	
	/*
	 * Median is always calculated on sorted numbers, so stream numbers must be sorted each time
	 * Consider numbers 5, 3,1,6,4,2 in stream, so if we sort it  1, 2,3 4, 5,6 it creates two parts 1,2,3 and 4,5,6
	 * so store part 3,2,1 in max heap and 4,5,6 in min heap as insertion in heap is log(n) time
	 * 
	 * algorithm:
	 *  1. Maintain two heaps , min and max 
	 *  2. add first element in min heap
	 *  3. if next num > head of min heap , then move head of min heap to max heap
	 *        and add num to min heap else add number to max heap
	 *  4. Difference b/w Length of max heap and min heap < = 1, if increases to > 1 then we need to balance
	 *  5. To balance , move head of max heap to min heap (len of max > len of min heap) or move head of min heap to max heap (len of min > len of max heap)
	 *  
	 *  
	 */
			
	
	public static void addNum(int num) {
		if(pqMin.size()==0) {
			pqMin.add(num);
		}
		else {
			if(pqMin.peek()<num) {
				pqMin.add(num);
			}
			else {
				pqMax.add(num);
			}
			if(pqMax.size()-pqMin.size()>1) {
				pqMin.add(pqMax.poll());
			}
			else if(pqMin.size()-pqMax.size()>1) {
				pqMax.add(pqMin.poll());
			}
		}
	}

	public static double findMedian() {
		double median = 0.0;
		if(pqMin.size() < pqMax.size() ) {
			median = pqMax.peek();
		}
		else if(pqMin.size() > pqMax.size() ) {
			median = pqMin.peek();
		}
		else {
			median =  (pqMin.peek() + pqMax.peek())/2.0;
		}
		return median;
	}
}
