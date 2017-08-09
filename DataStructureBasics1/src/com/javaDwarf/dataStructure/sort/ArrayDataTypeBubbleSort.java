package com.javaDwarf.dataStructure.sort;

import com.javaDwarf.dataStructure.arraysADT.ArraysADT;

public class ArrayDataTypeBubbleSort extends ArraysADT {

	public ArrayDataTypeBubbleSort(int size) {
		super(size);
	}
	
	public void bubbleSort(){

		for(int i=arr.length-1; i>1; i-- ){
			for(int j=0; j<i; j++){
				if(arr[j] > arr[j+1]){
					int temp = 0;
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public String display() {

		String arrContent = "";

		if(arr.length > 0){
			for(int i=0; i<arr.length; i++){
				arrContent += arr[i] + " "; 
			}
			return arrContent;
		}
		else{
			return arrContent;
		}
	}
	
	
	
	

}
