package com.javadwarf.bitmanipulation.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Solution {


	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(4,8,7);
		List<Integer> low = Arrays.asList(2,4);
		List<Integer> high = Arrays.asList(8,4);
		System.out.println(countBetween(arr, low, high));
	}
	
	public static List<Integer> countBetween(List<Integer> arr, List<Integer> low, List<Integer> high){
		Collections.sort(arr);
		int[] out = new int[low.size()];
		for(int num : arr) {
			for(int i=0; i<low.size(); i++) {
				if(num>=low.get(i) && num<=high.get(i)) { 
					out[i] += 1;
				    break;
				}
			}
		}
		return Arrays.stream(out).boxed().collect(Collectors.toList());
	}
}
