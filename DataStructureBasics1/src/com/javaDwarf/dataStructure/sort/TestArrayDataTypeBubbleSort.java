package com.javaDwarf.dataStructure.sort;

public class TestArrayDataTypeBubbleSort {

	public static void main(String[] args) {
		
		ArrayDataTypeBubbleSort arrADT = new ArrayDataTypeBubbleSort(18);
		
		arrADT.insert(12);
		arrADT.insert(13);
		arrADT.insert(34);
		arrADT.insert(7);
		arrADT.insert(1);
		arrADT.insert(99);
		arrADT.insert(21);
		arrADT.insert(11);
		arrADT.insert(18);
		arrADT.insert(23);
		arrADT.insert(12);
		arrADT.insert(12);
		arrADT.insert(10);
		arrADT.insert(39);
		arrADT.insert(12);
		arrADT.insert(66);
		
		System.out.println("Array : " + arrADT.display());
		
		arrADT.bubbleSort();
		
		System.out.println("Array : " + arrADT.display());
		
		

	}

}
