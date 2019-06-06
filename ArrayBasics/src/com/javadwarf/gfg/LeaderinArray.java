package com.javadwarf.gfg;

import java.util.ArrayList;

public class LeaderinArray {

	public static void main(String[] args) {

	}
	 static ArrayList<Integer> leaders(int arr[], int n){
		 if(arr==null || arr.length==0) return null;
		 
		 ArrayList<Integer> l = new ArrayList<>();
		 
		 int temp = Integer.MIN_VALUE;
		 for(int i=arr.length-1; i>=0; i++) {
			 if(temp <= arr[i]) {
				 l.add(arr[i]);
				 temp = arr[i];
			 }
		 }
		 return l;
	 }

}
