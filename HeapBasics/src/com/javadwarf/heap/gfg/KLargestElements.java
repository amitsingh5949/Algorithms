package com.javadwarf.heap.gfg;

import com.javadwarf.heap.implementation.Heap;
import com.javadwarf.heap.implementation.HeapEmptyException;
import com.javadwarf.heap.implementation.HeapFullException;
import com.javadwarf.heap.implementation.MaxHeap;

public class KLargestElements {

	public static void main(String[] args) {
		
		Heap<Integer> minHeap = new MaxHeap<>(Integer.class,5);

	}
	
	public void doStuff(Heap<Integer> minHeap, Integer val) throws HeapFullException, HeapEmptyException {
		if(!minHeap.isFull()) {
			minHeap.insert(val);
		}
		else {
			if(val > minHeap.getHighestPriorityElement()) {
				minHeap.remove();
				minHeap.insert(val);
			}
		}
	}

}
