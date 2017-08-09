package com.javaDwarf.dataStructure.arraysADT;

import com.javaDwarf.dataStructure.generic.AbstractDataType;

public class ArraysADT implements AbstractDataType {


	public int[] arr;
	public int numOfElements ;

	public ArraysADT(int size){
		arr = new int[size];
		numOfElements = 0 ;
	}

	@Override
	public int insert(int value) {

		if(numOfElements < arr.length ){
			arr[numOfElements++] = value;
			return (numOfElements-1);
		}
		else{
			return -1;
		}
	}

	@Override
	public int search(int value) {

		if(arr.length > 0){
			for(int i=0; i<numOfElements; i++){
				if(arr[i] == value){
					return i;
				}
			}
			return -1;
		}
		else{
			return -1;
		}
	}

	@Override
	public int delete(int value) {

		int index = search(value);

		if(index != -1 && arr.length > 0){
			for(int i=index; i<numOfElements; i++){
				arr[i] = arr[i+1];
			}
			numOfElements--;
		}
		return index;
	}

	@Override
	public int deleteAt(int index) {

		if(index <= numOfElements && arr.length > 0){
			for(int i=index; i<numOfElements; i++){
				arr[i] = arr[i+1];
			}
			numOfElements--;
		}
		return index;
	}

	@Override
	public void deleteAll(int value) {

		boolean flag = true;
		while(flag){
			int index = delete(value);
			if(index == -1){
				flag = false;
			}
		}
	}

	@Override
	public String display() {

		String arrContent = "";

		if(arr.length > 0){
			for(int i=0; i<numOfElements; i++){
				arrContent += arr[i] + " "; 
			}
			return arrContent;
		}
		else{
			return arrContent;
		}
	}

}
