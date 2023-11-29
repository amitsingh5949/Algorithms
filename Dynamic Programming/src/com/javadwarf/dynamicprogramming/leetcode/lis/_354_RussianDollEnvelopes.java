package com.javadwarf.dynamicprogramming.leetcode.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _354_RussianDollEnvelopes {

	public static void main(String[] args) {

	}

	//Sort the array. Ascend on width and descend on height(to avoid same width envelop issue).
	//Find the LIS based on height.
	public int maxEnvelopes(int[][] envelopes) {
		
		if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
		
		Arrays.parallelSort(envelopes, (a,b) -> {
			int temp = Integer.compare(a[0], b[0]);
			if(temp == 0) {
				return Integer.compare(b[1], a[1]);
			}
			return temp;
		});
		
		int last = 0;
		int[] output = new int[envelopes.length];
		output[0] = envelopes[0][1];

		for(int i=1; i<envelopes.length; i++) {

			if(output[last] < envelopes[i][1]) {
				output[++last] = envelopes[i][1];
			}
			else {
				int start = 0;
				int end = last;
				int mid = (start + end)/2;
				 
				while(start <= end) {
					mid = (start + end)/2;
                    if(output[mid] == envelopes[i][1]){
                    	start = mid;
                        break ;
                    }
					else if(output[mid] > envelopes[i][1]) {
						end = mid-1;
					}
					else {
						start = mid+1;
					}
				}
				output[start] = envelopes[i][1];
			}
		}
		return last+1;
	}
	
	//	// Same binary search solution as above but bit modular  o(nlogn) and o(n)
	
	//Sort the array. Ascend on width and descend on height(to avoid same width envelop issue).
		//Find the LIS based on height.
public int maxEnvelopesBSO(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a,b) -> {
            int x = a[0] - b[0];
            if(x == 0){
                return b[1]-a[1];
            }
            return x;
        });
        
        List<Integer> lis = new ArrayList<>();
        lis.add(envelopes[0][1]);
        
        for(int i=1; i< envelopes.length; i++){
            
            if(envelopes[i][1] > lis.get(lis.size()-1)){
                lis.add(envelopes[i][1]);
            }
            else{
                int index = binarySearch(lis,envelopes[i][1], 0, lis.size()-1);
                lis.set(index,envelopes[i][1]);
            }
        }
        return lis.size();
        
    }
    
    public int binarySearch(List<Integer> lis, int num, int start, int end){
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(start == mid){
                return lis.get(mid) >= num ? start : end;
            }
            
            if(lis.get(mid) < num){
                start = mid+1;
            }
            else if(lis.get(mid) >= num){
                end = mid;
            }
        }
        return start;
    }
}
