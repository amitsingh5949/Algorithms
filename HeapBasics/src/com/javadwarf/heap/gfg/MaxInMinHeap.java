package com.javadwarf.heap.gfg;

import com.javadwarf.heap.implementation.Heap;
import com.javadwarf.heap.implementation.HeapEmptyException;
import com.javadwarf.heap.implementation.HeapFullException;
import com.javadwarf.heap.implementation.MinHeap;

public class MaxInMinHeap {
	
	private static Integer max = 0;

	public static void main(String[] args) throws HeapFullException,HeapEmptyException {
		
		Heap<Integer> maxHeap = new MinHeap<>(Integer.class);
			maxHeap.insert(9);
	        maxHeap.insert(4);
	        maxHeap.insert(17);
	        maxHeap.insert(6);
	        maxHeap.insert(100);
	        maxHeap.insert(20);
	        maxHeap.insert(2);
	        maxHeap.insert(1);
	        maxHeap.insert(5);
	        maxHeap.insert(3);
	        System.out.println(maxElement(maxHeap));
	        max = 0;
	        System.out.println(max(maxHeap));
	        max = 0;
	}
	
	// need to check only leafs for max element, first leaf comes after last parent node
	private static Integer maxElement(Heap<Integer> maxHeap) throws HeapEmptyException {
		
		max = maxHeap.getHighestPriorityElement();
		
		Integer lastIndex = maxHeap.getCount() - 1;
		Integer lastParentIndex = maxHeap.getParentNodeIndex(lastIndex);
		
		Integer firstLeafIndex = lastParentIndex + 1;
		
		for(int i = firstLeafIndex; i <= lastIndex; i++) {
			if(max < maxHeap.getElementAt(i)) {
				max = maxHeap.getElementAt(i);
			}
		}
		return max;
	}

	public static Integer max(Heap<Integer> maxHeap ) throws HeapEmptyException {
		max = maxHeap.getHighestPriorityElement();
		traverse(maxHeap, 0);
		return max;
	}
	
	public static void traverse(Heap<Integer> maxHeap, Integer index) {
		
		if(maxHeap.getElementAt(index) > max) {
			max = maxHeap.getElementAt(index);
		}
		
		Integer leftIndex = maxHeap.getLeftNodeIndex(index);
		Integer rightIndex = maxHeap.getRightNodeIndex(index);
		
		if(leftIndex != -1) {
			traverse(maxHeap, leftIndex);
		}
		if(rightIndex != -1) {
			traverse(maxHeap, rightIndex);
		}
		
		
	}

}
