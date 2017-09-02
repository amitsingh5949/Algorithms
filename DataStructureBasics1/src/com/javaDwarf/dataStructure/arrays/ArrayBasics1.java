package com.javaDwarf.dataStructure.arrays;

public class ArrayBasics1 {

	static int[] a, b;
	static int []c, d;
	static int e[], f;
	
	public static void main(String[] args) {
		
       System.out.println(b);// b is array
       System.out.println(d);// d is array
       System.out.println(f);// f is int
       
       b = new int[0];// b is an array of size 0
       //c=  new int[-1];//NegativeArraySizeException
       int[] x = {23,56,89,90};
        System.out.println(x['b'-'a']); //index 1 =56
        System.out.println(x['a']);   //java.lang.ArrayIndexOutOfBoundsException: 97   
//taking ASCII value as index
	}

}
