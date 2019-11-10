package com.javadwarf.hashtable.leetcode;

import java.util.Arrays;

public class _205_IsomorphicStrings {

	public static void main(String[] args) {
new _205_IsomorphicStrings().isIsomorphic("foo", "bar");
	}
	
	public boolean isIsomorphic(String s, String t) {
		return isIsomorphicCheck(s, t) && isIsomorphicCheck(t, s);
	}

	public boolean isIsomorphicCheck(String s, String t) {
		
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
