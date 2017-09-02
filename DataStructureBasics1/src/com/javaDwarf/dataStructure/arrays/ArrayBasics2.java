package com.javaDwarf.dataStructure.arrays;
/**
 * Anonymous Array
 * Has no name(i.e. no reference variable , neither they have size)
 * @author Amit Singh
 *
 */
public class ArrayBasics2 {

	public static void main(String... args) {
		
       int[] a;
       //a={1,2,3};Array constants can only be used in initializers.
       //int b  = findMin({17,3,89,12, 7, 8, 2, 30, 56});Array constants can only be used in initializers.
       System.out.println(findMin(new int[]{17,3,89,12, 7, 8, 2, 30, 56}));
       
	}
	
	static int findMin(int[] arr){
		int minVal= arr[0];
		for(int i:arr){
			if(i<minVal){
				minVal = i;
			}
		}
		return minVal;
	}

}
