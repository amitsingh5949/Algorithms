package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(new _49_GroupAnagrams().groupAnagrams(new String[] {"huh","tit"}));
	}


// o(n*k)
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for(String str : strs) {
			String code = getCode(str);
			List<String> l = map.getOrDefault(code, new ArrayList<String>());
            l.add(str);
            map.put(code,l);
		}
		return new ArrayList<List<String>>(map.values());
	}


	public String getCode(String str) {
		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) -'a'] += 1;
		}
		String res = "";
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0) {
				char ch = ((char)(i+97));
				res += arr[i]+""+ch;
			}
		}
		return res;
	}


	// O(n^2)*k time
	public List<List<String>> groupAnagrams1(String[] strs) {

		List<String> input = new ArrayList<String>();
		for(String temp : strs) {
			input.add(temp);
		}

		List<List<String>> l = new ArrayList<List<String>>();
		if(strs == null || strs.length==0){
			return l;
		}

		while(input.size() > 0) {

			List<String> ll = new ArrayList<String>();
			String s1 = input.get(0);
			ll.add(s1);

			for(int j =1; j<input.size(); j++) {
				String s2 = input.get(j);
				if(isAnagram(s1, s2)) {
					ll.add(s2);
				}
			}

			l.add(ll);

			for(String temp :ll) {
				input.remove(temp);
			}
		}

		return l;

	}

	public boolean isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		else {
			int[] arr = new int[26];
			for(int i=0; i<s1.length(); i++) {
				arr[s1.charAt(i) -'a'] += 1;
			}
			for(int j=0; j<s2.length(); j++) {
				arr[s2.charAt(j) -'a'] -= 1;
			}
			for(int i=0; i<arr.length; i++) {
				if(arr[i]!=0) return false;
			}
		}
		return true;
	}



}
