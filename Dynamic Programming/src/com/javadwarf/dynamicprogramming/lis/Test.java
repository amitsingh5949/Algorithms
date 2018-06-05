package com.javadwarf.dynamicprogramming.lis;

import java.util.Arrays;

public class Test {
	
	public  static void main(String [] args){
		String str = "31 64 97 58 14 21 84 47 45 90 37 "
				+ "27 35 71 52 12 82 82 75 100 83 46 86 6 34 77 "
				+ "57 96 35 57 3 17 72 51 74 37 24 10 83 68 99 19 "
				+ "94 33 42 46 44 75 79 70 75 61 68 60 66 1";
		
		String[] sArr = str.split(" ");
		int[] arr = new int[sArr.length];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = Integer.parseInt(sArr[i]);
		}
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" "); 
		}
		
		String str1 = "[[9,10],[9,10],[4,5],[-9,-3],[-9,1],[0,3],[6,10],[-5,-4],[-7,-6]]";
		//System.out.println(str1.replaceAll("[", "{").replaceAll("]", "}"));
		System.out.println("\n"+str1.replace('[', '{').replace(']', '}'));
	}

}
