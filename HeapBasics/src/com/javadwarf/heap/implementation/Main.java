package com.javadwarf.heap.implementation;

public class Main {

	public static void main(String[] args) throws HeapFullException {

		Heap<Integer> h = new MinHeap<Integer>(Integer.class,40);
		
		h.insert(1);
		h.insert(2);
		h.insert(3);
		h.insert(4);
		h.insert(8);
		h.insert(7);
		h.insert(6);
		h.insert(5);
		
		for(int i=0; i<8; i++) {
			System.out.print(h.getElementAt(i) +",");
		}
		
	}

}
