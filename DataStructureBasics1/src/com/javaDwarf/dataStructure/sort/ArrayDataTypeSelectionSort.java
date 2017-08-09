package com.javaDwarf.dataStructure.sort;

import com.javaDwarf.dataStructure.arraysADT.ArraysADT;

public class ArrayDataTypeSelectionSort extends ArraysADT {

	public ArrayDataTypeSelectionSort(int size) {
		super(size);
	}
	
	public void selectionSort(){

		int temp = 0;
		
		for(int i=0; i<arr.length-1; i++ ){
			
			int shortIndex = i ;
			
			for(int j=i; j<arr.length; j++){
				if(arr[j] < arr[shortIndex]){
					shortIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[shortIndex];
			arr[shortIndex] = temp;
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
