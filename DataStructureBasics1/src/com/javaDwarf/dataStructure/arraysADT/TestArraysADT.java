package com.javaDwarf.dataStructure.arraysADT;

public class TestArraysADT {

	public static void main(String[] args) {
		
		ArraysADT arrADT = new ArraysADT(100);
		
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
		
		System.out.println("Element 34 found at index : " + arrADT.search(34) ) ;
		System.out.println("Element 52 found at index : " + arrADT.search(52) ) ;
		System.out.println("Element 66 found at index : " + arrADT.search(66) ) ;
		
		
		System.out.println("Element 21 deleted at index : " +arrADT.delete(21));
		System.out.println("Array : " + arrADT.display());
		
		System.out.println("Element 99 deleted at index : " +arrADT.delete(99));
		System.out.println("Array : " + arrADT.display());
		
		System.out.println("Element 105 deleted at index : " +arrADT.delete(105));
		System.out.println("Array : " + arrADT.display());
		
		System.out.println("Element deleted at index : " +arrADT.deleteAt(7));
		System.out.println("Array : " + arrADT.display());
		
		System.out.println("Element 12 deleted at index : " +arrADT.delete(12));
		System.out.println("Array : " + arrADT.display());
		
		System.out.println("All Element 12 deleted " );
		arrADT.deleteAll(12);
		System.out.println("Array : " + arrADT.display());
		
		

	}

}
