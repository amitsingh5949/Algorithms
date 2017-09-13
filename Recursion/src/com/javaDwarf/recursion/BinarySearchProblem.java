package com.javaDwarf.recursion;

import java.util.Arrays;

public class BinarySearchProblem {

	public static int[] arr = {15,67,12,7,90,53,234,102,97};
	public static void main(String[] args) {
		
         Arrays.sort(arr);
         int index  = binarySearch(67,0,arr.length-1);
         if(index!=-1){
         System.out.println("Fount at : "+ index);
         }
         else{
        	 System.out.println("Fount at : "+ index); 
         }
         
	}

	private static int binarySearch(int value,int front, int rear) {
		int curr = (front+rear)/2;
		if(arr[curr] == value){
			return curr;
		}
		else if(front > rear){
			return -1;
		}
		else{
			if(arr[curr]< value){
				binarySearch(value,curr+1,rear);
			}
			else{
				binarySearch(value,front,curr-1);
			}
				
		}
		return -1;
	}

}
