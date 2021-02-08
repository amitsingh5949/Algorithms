package com.javadwarf.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _205_IsomorphicStrings {

	public static void main(String[] args) {
		new _205_IsomorphicStrings().isIsomorphic("foo", "bar");
	}
	
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> tmap = new HashMap<>();

		for(int i=0; i<s.length(); i++){
			
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			
			if(!map.containsKey(ch1)) {
				map.put(ch1,ch2);
			}
			else if(map.get(ch1) != ch2) {
				return false;
			}
			if(!tmap.containsKey(ch2)) {
				map.put(ch2,ch1);
			}
			else if(tmap.get(ch2) != ch1) {
				return false;
			}
		}
		return true;
	}

	public boolean isIsomorphic1(String s, String t) {
		return isIsomorphicCheck(s, t) && isIsomorphicCheck(t, s);
	}

	public boolean isIsomorphicCheck(String s, String t) {

		Map<Character, Character> map = new HashMap<>();

		for(int i=0; i<s.length(); i++){
			
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			
			if(!map.containsKey(ch1)) {
				map.put(ch1,ch2);
			}
			else if(map.get(ch1) != ch2) {
				return false;
			}

		}
		return true;
	}

	public boolean isIsomorphicCheck1(String s, String t) {

		int[] map = new int[255];
		Arrays.fill(map, -1);

		for(int i=0; i<s.length(); i++){
			if(map[s.charAt(i)-'\0']==-1) {
				map[s.charAt(i)-'\0']=t.charAt(i)-'\0';
			}
			else if(map[s.charAt(i)-'\0']!=-1 && map[s.charAt(i)-'\0']!=t.charAt(i)-'\0') {
				return false;
			}
		}
		return true;
	}

}
