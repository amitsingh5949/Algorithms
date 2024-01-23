package com.javadwarf.greedy.leetcode;

import java.util.Arrays;

public class _1899_MergeTripletstoFormTargetTriplet {
	
	// idea is to eliminate arrays which have elements greater than target element, since numbers greater than target element will never result in anser.
	// Now merge all left over arrays
	// in the end see if result is same as target.
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] arr = new int[triplets[0].length];
        for( int[] t : triplets){
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]){
                if(t[0] == target[0])  arr[0] = Math.max(arr[0], t[0]);
                arr[1] = Math.max(arr[1], t[1]);
                arr[2] = Math.max(arr[2], t[2]);
            }
        }
        return Arrays.equals(arr, target);        
    }
	
	// Same as above
	public boolean mergeTriplets1(int[][] triplets, int[] target) {
        int[] arr = new int[triplets[0].length];
        for( int[] t : triplets){
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]){
                if(t[0] == target[0])  arr[0] = t[0];
                if(t[1] == target[1])  arr[1] = t[1];
                if(t[2] == target[2])  arr[2] = t[2];
            }
        }
        return Arrays.equals(arr, target);
    }

}
