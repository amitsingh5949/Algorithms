package com.javadwarf.hashtable.leetcode;

public class _389_FindtheDifference {

	public char findTheDifference(String s, String t) {
		
		int[] arr = new int[26];
		
		for(int i =0 ; i<s.length(); i++) {
			arr[s.charAt(i) - 'a'] +=1;
		}
		char ch = '\0';
		for(int i =0 ; i<t.length(); i++) {
			arr[s.charAt(i) - 'a'] -=1;
			if(arr[s.charAt(i) - 'a'] == -1) {
				ch = s.charAt(i);
			}
		}
		return ch;
	}
	
	// better solution is to add charcode of s and  add charcode of t. subtract them, we will get the extra letter code
	public char findTheDifference1(String s, String t) {
        int charCode = t.charAt(s.length());
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }
}
