package com.javadwarf.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _290_WordPattern {

	public static void main(String[] args) {

		System.out.println(new _290_WordPattern().wordPattern("abba", "dog dog dog dog"));

	}
	//time: o(n.w) and space :o(n)

	public boolean wordPattern(String pattern, String s) {

		HashMap<Character, String> smap = new HashMap<>();
		HashMap<String, Character> tmap = new HashMap<>();

		String[] arr = s.split(" ");

		if(pattern.length() != arr.length) return false;

		for(int i=0; i< pattern.length(); i++){

			char ch = pattern.charAt(i);
			String curr = arr[i];

			if(!smap.containsKey(ch)){
				smap.put(ch,curr);
			}
			else{
				if(!smap.get(ch).equals(curr)) return false;
			}

			if(!tmap.containsKey(curr)){
				tmap.put(curr, ch);
			}
			else{
				if(tmap.get(curr) != ch) return false;
			}

		}

		return true;


	}

	//o(n.w) and o(n)
	public boolean wordPattern1(String pattern, String str) {

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
