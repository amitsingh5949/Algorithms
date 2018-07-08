package com.javadwarf.heap.implementation;

import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable<T>> {

	private static Integer MAX_SIZE = 40;
	private T[] array = null;
	private Integer count = 0;

	public Heap(Class<T> arrayType) {
		this(arrayType,MAX_SIZE);
	}

	public Heap(Class<T> arrayType, Integer size) {
		this.array = (T[]) Array.newInstance(arrayType, size);
	}

	public Integer getLeftNodeIndex(Integer currentNodeIndex) {
		Integer leftIndex = currentNodeIndex*2 + 1 ;
		if(leftIndex >= count) {
			return -1;
		}
		return leftIndex;
	}

	public Integer getRightNodeIndex(Integer currentNodeIndex) {
		Integer rightIndex = currentNodeIndex*2 + 2 ;
		if(rightIndex >= count) {
			return -1;
		}
		return rightIndex;
	}
	
	public Integer getParentNodeIndex(Integer currentNodeIndex) {
		
		if(currentNodeIndex < 0 || currentNodeIndex > count) {
			return -1;
		}
		return  (currentNodeIndex-1)/ 2 ;
		
	}
	
	public Boolean isEmpty() {
		return this.count==0;
	}
	
	public Boolean isFull() {
		return this.count==array.length;
	}
	
	public Integer getCount() {
		return this.count;
	}
	
	public T getElementAt(Integer index) {
		if(index < 0 || index > count) {
			return null;
		}
		return  this.array[index];
	}

	public void swap(Integer index1, Integer index2) {
		T temp = this.array[index1];
		this.array[index1] = this.array[index2];
		this.array[index2] = temp;
	}


	public abstract void siftDown(Integer index);
	public abstract void siftUp(Integer index);
	
	public void insert(T element) throws HeapFullException {
		
		if(this.isFull()) {
			throw new HeapFullException("Heap is full");
		}
		array[count] = element;
		this.siftUp(count);
		count++;
	}
	
	public T remove() throws HeapEmptyException {
		
		T highestPriorityElement = this.getHighestPriorityElement();
		
		if( highestPriorityElement != null) {
			array[0] = array[count-1];
			array[count-1] = null ;
			count--;
			this.siftDown(0);
		}
		return highestPriorityElement;
	}
	
	public T getHighestPriorityElement() throws HeapEmptyException {
		if(this.isEmpty()) {
			throw new HeapEmptyException("heap is Empty");
		}
		return this.getElementAt(0);
	}
	
}
