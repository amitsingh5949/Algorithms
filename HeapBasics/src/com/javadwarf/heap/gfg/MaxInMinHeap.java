package com.javadwarf.heap.gfg;

import com.javadwarf.heap.implementation.Heap;
import com.javadwarf.heap.implementation.HeapEmptyException;
import com.javadwarf.heap.implementation.HeapFullException;
import com.javadwarf.heap.implementation.MinHeap;

public class MaxInMinHeap {
	
	private static Integer max = 0;

	public static void main(String[] args) throws HeapFullException,HeapEmptyException {
		
		Heap<Integer> minHeap = new MinHeap<>(Integer.class);
			minHeap.insert(9);
	        minHeap.insert(4);
	        minHeap.insert(17);
	        minHeap.insert(6);
	        minHeap.insert(100);
	        minHeap.insert(20);
	        minHeap.insert(2);
	        minHeap.insert(1);
	        minHeap.insert(5);
	        minHeap.insert(3);
	        System.out.println(maxElement(minHeap));
	        max = 0;
	        System.out.println(max(minHeap));
	        max = 0;
	}
	
	// need to check only leafs for max element, first leaf comes after last parent node
	private static Integer maxElement(Heap<Integer> minHeap) throws HeapEmptyException {
		
		max = minHeap.getHighestPriorityElement();
		
		Integer lastIndex = minHeap.getCount() - 1;
		Integer lastParentIndex = minHeap.getParentNodeIndex(lastIndex);
		
		Integer firstLeafIndex = lastParentIndex + 1;
		
		for(int i = firstLeafIndex; i <= lastIndex; i++) {
			if(max < minHeap.getElementAt(i)) {
				max = minHeap.getElementAt(i);
			}
		}
		return max;
	}

	public static Integer max(Heap<Integer> minHeap ) throws HeapEmptyException {
		max = minHeap.getHighestPriorityElement();
		traverse(minHeap, 0);
		return max;
	}
	
	public static void traverse(Heap<Integer> minHeap, Integer index) {
		
		if(minHeap.getElementAt(index) > max) {
			max = minHeap.getElementAt(index);
		}
		
		Integer leftIndex = minHeap.getLeftNodeIndex(index);
		Integer rightIndex = minHeap.getRightNodeIndex(index);
		
		if(leftIndex != -1) {
			traverse(minHeap, leftIndex);
		}
		if(rightIndex != -1) {
			traverse(minHeap, rightIndex);
		}
		
		
	}

}
