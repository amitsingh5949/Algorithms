package com.javadwarf.heap.leetcode;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class _239_SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] a = new _239_SlidingWindowMaximum().maxSlidingWindow2(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		for(int x : a) System.out.print( x + ", ");
	}
	/*
	 * Method 1 : using Max heap
	 *  Create class Element to store value and index for each element in array
	 *  Add k(window) elements from array to priority queue
	 *  Now we want to add next elements, removing the previously added elements which are not in window
	 *   so remove all elements from pq until i-e.index >= k and also if nums[i] is greater than top of pq then empty the pq as no element will be max than nums[i]
	 *   (i index of element currently being added, e is element at top)
	 */
	public int[] maxSlidingWindow(int[] nums, final int k) {
		if(nums == null || nums.length==0) 
			return new int[0];

		int[] result = new int[nums.length - (k-1)];
		Queue<Element> pq = new PriorityQueue<Element>(Collections.reverseOrder());

		for(int i = 0 ; i <k; i++) {
			pq.add(new Element(i, nums[i]));
		}

		for(int i=k; i<nums.length; i++) {
			Element e = pq.peek();
			result[i-k] = e.value;
			while( !pq.isEmpty() && (i-e.index >= k || e.value < nums[i] )) {
				pq.poll();
				e = pq.peek();
			}
			pq.add(new Element(i, nums[i]));
		}
		result[result.length-1] = pq.peek().value;
		return result;
	}

	/*Method 2 : using deque
	 *  It is similar to the above approach, we add max element to head of deque
	 *   a. new element comes, if top is out of range of window , remove it until top comes in window range
	 *   b. check if the element at last is smaller, if smaller remove the element until an element come which is greater than current element
	 *   c. add element at last of deque
	 *  
	 */

	public int[] maxSlidingWindow2(int[] nums, final int k) {
		if(nums == null || nums.length==0) 
			return new int[0];

		int[] result = new int[nums.length - (k-1)];
		Deque<Integer> dq = new ArrayDeque<>();

		for(int i=0; i<nums.length; i++) {
			while(!dq.isEmpty() && i-dq.peek() >= k) {
				dq.pollFirst();
			}
			while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
			if(i >= k-1) {
				result[i-(k-1)] = nums[dq.peekFirst()];
			}
		}
		result[result.length-1] = nums[dq.peekFirst()];
		return result;
	}
}
class Element implements Comparable<Element>{
	int index, value = 0;
	public Element(int index, int value) {
		this.index = index;
		this.value = value;
	}
	@Override
	public String toString() {
		return "index=" + index + ", value=" + value;
	}

	@Override
	public int compareTo(Element e) {
		return Integer.compare(this.value, e.value);

	}
}
