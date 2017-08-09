package com.javaDwarf.dataStructure.arraysADT;

public class SortedArraysADT extends ArraysADT {

	public SortedArraysADT(int size){
		super(size);
	}
	
	@Override
	public int insert(int value) {
		
		if(numOfElements < arr.length){
			int i= 0;
			while(i<numOfElements){
				if( value < arr[i]){
					break;
				}
				i++;
			}
			
			for(int j=numOfElements; j>i; j--){
				arr[j] =arr[j-1];
			}
			
			arr[i] = value;
			numOfElements++;
			return i;
		}
		else{
			return -1;
		}
	}

	
	public int searchBinary(int value) {
		
		int lowerBound = 0;
		int upperBound = numOfElements - 1;
		int curIndex ;
		
		if(arr.length > 0){

			while(true){

				curIndex = (lowerBound + upperBound)/2;

				if(arr[curIndex] == value){
					return curIndex;
				}
				else if(lowerBound > upperBound){
					return -1;
				}
				else{
					if(arr[curIndex] < value){
						lowerBound = curIndex+1;
					}
					else{
						upperBound = curIndex-1;
					}
				}
			}
		}
		return -1;
	}
	
}
