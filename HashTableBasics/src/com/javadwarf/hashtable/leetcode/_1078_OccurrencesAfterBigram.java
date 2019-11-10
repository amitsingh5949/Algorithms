package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1078_OccurrencesAfterBigram {

	public static void main(String[] args) {

	}

	public String[] findOcurrences(String text, String first, String second) {

		String[] arr = text.split(" ");
		
		List<String> l = new ArrayList<>();
		
		for(int i=0; i<arr.length-3; i++) {
			
			if(arr[i].equals(first) && arr[i+1].equals(second)) {
				l.add(arr[i+3]);
			}
		}
		
		return l.toArray(new String[l.size()]);
	}

}
