package com.javadwarf.leetcode;

import java.util.Scanner;

public class _136_UniqueNumber {

	public static void main (String[] args)
	{
		/*Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i =0; i<testCases; i++) {
			int size = s.nextInt();
			int[] a = new int[size];
			for(int x=0; x<size; x++) {
				a[x] = s.nextInt();
			}
			sortColors(a);
			System.out.println();
		}
		s.close();*/

		//String input = "0 2 2 1 0 0 2 0 1 1 1 0 0 2 0 1 2 1 2 0 2 2 0 0 1 2 1 2 2 1 0 2 1 2 1 0 0 1 0 2 0 2 0 1 0 1 2 0 0 2 1 2 2 2 1 0 2 2 0 2 0 0 1 2 1 0 0 2 2 1 2 0 1 2 2 1 2 2 1 2 1 1 2 1 0" ;
		//String input = "2 0 0 2 1 1 0 0 1 1 1 1 2 1 1 1 1 1 0 1 0 2 2 1 2 0 2 2 1 2 1 1 0 1 2 2 0 2 2";
		//String input = "2 0 0 2 1 0 2 2";
		//String input = "0 0 2 2";
		//String input =  "2 1 1 0 1 0";
		//String input =  "0 1 0";

		//String input =  "2 1";
		//String input =  "1 2 0";

		String input =  "0 2 1 2 0";
		//String input =  "0 1 0";

		String[] arr = input.split(" ");
		int[] arr1 = new int[arr.length];
		for(int x =0; x<arr.length; x++) {
			arr1[x] = Integer.parseInt(arr[x]);
		}
		//sortColors2(arr1);
		singleNumber(arr1);
		xor();


	}

	/* XOR ^ , if same number then result is 0, in XOR TT/FF is F TF/FT is T
	    binary 5 is 101 and 6 is 110  (101 ^ 110) 011 i.e.
	    5 ^ 6 ^ 5 = 3 ^ 5 ( 011 ^ 101) = 110 i.e 6
	  
	    System.out.println( 5 ^ 5); 0
		System.out.println( 5 ^ 6); 3
		System.out.println( 5 ^ 6 ^ 5 ^6);  6
		
		System.out.println( 5 ^ 6 ^ 5 ^6); 0
	 */
	
	public static  void xor() {
		
		    System.out.println( 5 ^ 5); 
			System.out.println( 5 ^ 6); 
			System.out.println( 5 ^ 6 ^ 5 ^6);  
			System.out.println( 5 ^ 6 ^ 5 ^6); 
			
			System.out.println('a' ^ 'a'); //0
			System.out.println('a' ^ 'b'); //3
			System.out.println('a' ^ 'b' ^ 'a');//98
			
			char ch = (char) ('a' ^ 'b' ^ 'a');
			
			System.out.println(ch);//b
			System.out.println((char)98);//b
			
		
	}
	
	public static  int singleNumber(int[] nums) {
		int result = 0;
		
		for(int i = 0; i<nums.length; i++ ) {
			result ^= nums[i];
		}
		
		return result;
	}




}
