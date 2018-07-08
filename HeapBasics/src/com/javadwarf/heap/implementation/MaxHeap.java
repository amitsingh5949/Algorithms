package com.javadwarf.heap.implementation;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

	public MaxHeap(Class<T> arrayType) {
		super(arrayType);
	}

	public MaxHeap(Class<T> arrayType, Integer size) {
		super(arrayType,size);
	}

	@Override
	public void siftDown(Integer index) {

		Integer leftIndex = this.getLeftNodeIndex(index);
		Integer rightIndex = this.getRightNodeIndex(index);

		Integer smallerindex = -1;

		if(leftIndex != -1 && rightIndex != -1) {
			if(this.getElementAt(leftIndex).compareTo(this.getElementAt(rightIndex)) > 0) {
				smallerindex = leftIndex;
			}
			else {
				smallerindex = rightIndex;
			}
		}
		else if ( leftIndex != -1 && rightIndex == -1) {
			smallerindex = leftIndex;
		}
		else if ( leftIndex == -1 && rightIndex != -1) {
			smallerindex = rightIndex;
		}

		if(smallerindex ==  -1) {
			return;
		}
		else {
			if(this.getElementAt(smallerindex).compareTo(this.getElementAt(index)) > 0) {
				this.swap(smallerindex, index);
				siftDown(smallerindex);
			}
			else {
				return;
			}
		}

	}

	@Override
	public void siftUp(Integer index) {

		Integer parentIndex = this.getParentNodeIndex(index);

		if(parentIndex != -1 && this.getElementAt(index).compareTo(this.getElementAt(parentIndex)) > 0) {
			this.swap(index, parentIndex);
			siftUp(parentIndex);
		}
		else {
			return;
		}
	}


}
