package com.javadwarf.heap.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _290_WordPattern {

	public static void main(String[] args) {
		
		System.out.println(new _290_WordPattern().wordPattern("abba", "dog dog dog dog"));

	}
	
	
	public boolean wordPattern(String pattern, String str) {
		
		String[] arr = new String[26];
		
		String[] strArr = str.split(" ");
		
		if(pattern.length() != strArr.length) return false;
		
		Map<String, Character> map = new HashMap<>();
		
		for(int i=0; i<pattern.length(); i++) {
			
			int index = pattern.charAt(i) -'a';
			if(arr[index] == null) {
				if(map.containsKey(strArr[i])) {
					return false;
				}
				arr[index] = strArr[i];
				map.put(strArr[i], pattern.charAt(i));
			}
			else if(!arr[index].equals(strArr[i])) {
				return false;
			}
		}
		return true;
	}

}
