package com.javadwarf.heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _480_SlidingWindowMedian {

	public static void main(String[] args) {
		//new _480_SlidingWindowMedian().medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		new _480_SlidingWindowMedian().medianSlidingWindow(new int[] {1,2,3,4,2,3,1,4,2}, 3);
	}

	// this is question combines approaches used in question _239_SlidingWindowMaximum and _295_MedianInStream
	public  double[] medianSlidingWindow(int[] nums, int k) {

		double[] medianArr = new double[nums.length - k + 1];

		if(nums== null || nums.length == 0 || nums.length < k) return medianArr;

		Queue<Element>  minHeap = new PriorityQueue<Element>();
		Queue<Element>  maxHeap = new PriorityQueue<Element>(Collections.reverseOrder());

		int begin = 0;
		int end = 0 ;

		while(end < k) {
			addElement(minHeap, maxHeap, new Element(end, nums[end]), k);
			end++;
		}

		medianArr[begin] = findMedian(minHeap, maxHeap);
		begin++;

		while(end < nums.length) {
			addElement(minHeap, maxHeap, new Element(end, nums[end]), k);
			end++;
			medianArr[begin] = findMedian(minHeap, maxHeap);
			begin++;
		}

		for(double d :  medianArr) {
			System.out.print(d +" ");
		}

		return medianArr;
	}

	public  void addElement(Queue<Element>  minHeap,	Queue<Element>  maxHeap, Element e, int window) {
		if(minHeap.size() == 0) {
			minHeap.add(e);
		}
		else {
			if( e.val > minHeap.peek().val) {
				while(minHeap.size()> 0 && e.index - minHeap.peek().index >= window) {
					minHeap.poll();
				}
				if(minHeap.size() > 0 && e.val > minHeap.peek().val) {
					Element f = minHeap.poll();
					while(maxHeap.size()>0 &&  f.index - maxHeap.peek().index >= window) {
						maxHeap.poll();
					}
					maxHeap.add(f);
				}
				minHeap.add(e);
			}
			else{
				while(maxHeap.size()>0 &&  e.index - maxHeap.peek().index >= window) {
					maxHeap.poll();
				}
				maxHeap.add(e);
			}
			/*while(maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			}
			while (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			}*/
		}
	}

	public  double findMedian(Queue<Element>  minHeap, Queue<Element>  maxHeap) {

		if(minHeap.size() > maxHeap.size()) {
			return minHeap.peek().val;
		}
		else if(maxHeap.size() > minHeap.size()) {
			return maxHeap.peek().val;
		}
		else {
			return (minHeap.peek().val + maxHeap.peek().val) / 2;
		}
	}


	class Element implements Comparable<Element>{
		public int index = 0 , val = 0;

		public Element(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}
		@Override
		public int compareTo(Element o) {
			return Integer.compare(this.val, o.val);
		} 
		@Override
		public String toString() {
			return index+":"+ val;
		}
	}

}
