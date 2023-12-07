package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _242_ValidAnagram {


	// instead of using a map, we can use a array of length 26, increment and decrement based on two strings
	// when count at index goes below zero we can return false
	public boolean isAnagram(String s, String t) {

		if(s == null || t == null || s.length() != t.length()) return false;

		Map<Character, Integer> map = new HashMap<>();

		for(int i =0; i<s.length();i++) {
			int count = map.getOrDefault(s.charAt(i), 0);
			map.put(s.charAt(i), count +1);
		}

		for(int i =0; i<t.length();i++) {
			int count = map.getOrDefault(t.charAt(i), 0);

			if(count  == 0) {
				return false;
			}
			else if(count  == 1) {
				map.remove(t.charAt(i));
			}
			else {
				map.put(s.charAt(i), count -1);
			}
		}

		return map.size() == 0;

	}

	//above is o(2n), below is single pass
	public boolean isAnagram1(String s, String t) {

		if(s == null || t== null || s.length() != t.length()) return false;

		int[] arr = new int[256];

		for(int i=0; i<s.length(); i++){
			arr[s.charAt(i)-'a']++;
			arr[t.charAt(i)-'a']--;
		}

		for(int i=0; i<256; i++){
			if(arr[i] !=0) return false;
		}

		return true;

	}

}
