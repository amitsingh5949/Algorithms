package com.java.binaryserach.leetcode;

public class _702_SearchinaSortedArrayofUnknownSize {
	
//time	o(logn)
//space	o(1)
	
	//find the lower and upper bound for target value and then perform binary search

	/*public int search(ArrayReader reader, int target) {

		int beginIndex = 0;
		int endIndex = 1;
		int mid = beginIndex + (endIndex - beginIndex)/2; 

		while(reader.get(endIndex) < target){
			beginIndex = endIndex;
			endIndex = endIndex*2;
		}// or move the condition inside next while

		while(beginIndex <= endIndex){

			mid = beginIndex + (endIndex - beginIndex)/2; 

			if(reader.get(mid) == target){
				return mid;
			}
			else if(reader.get(mid) < target){
				beginIndex = mid + 1;
			}
			else{
				endIndex = mid - 1; 
			} 
		}    
		return -1;
	}*/
	
public int search(ArrayReader reader, int target) {
        
        int start = 0 ;
        int end = 1;
        
        int mid = start + (end-start)/2;
        
        while(start <= end){
            
            if(reader.get(end) < target){
                start = end;
                end = end*2;
                continue;
            }
            
            mid = start + (end-start)/2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        
        return -1;
    }

	class ArrayReader{
			public int get(int end) {
				return 0;
			}
	}

}
