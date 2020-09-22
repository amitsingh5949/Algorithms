package com.javadwarf.string.leetcode;

public class _459_RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern(""));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("s"));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("abaababaab"));
		System.out.println(new _459_RepeatedSubstringPattern().repeatedSubstringPattern("aabaaba"));
		
	}
	
	
	
	public boolean repeatedSubstringPattern(String s) {
		if(s == null || s.length()<2) return false;
		return (s+s).substring(1,s.length()*2-1).contains(s);
	}
	
	// Brute force O(n^2)
	public boolean repeatedSubstringPattern2(String s) {
		
		if(s == null || s.length()<2) return false;
		
		for(int i=1; i<=s.length()/2; i++) {
			
			String str = s.substring(0,i);
			
			boolean tempRes = true; 

			for(int j=0; j<s.length(); j=j+i){
				if(j+i > s.length()) {
					tempRes =  false;
					break;
				}
				String temp = s.substring(j,j+i);
				if(!temp.equals(str)) {
					tempRes =  false;
					break;
				}
			}
			if(tempRes) return tempRes;
		}
		return false;
	}

	
	// wrong logic
	public boolean repeatedSubstringPattern1(String s) {
		
		if(s == null || s.length()<2) return false;

		int[] arr = new int[26];

		int max = 0;
		int len = 0;

		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'a'] += 1;
			max = Integer.max(max,arr[s.charAt(i)-'a']);
		}

		for(int i=0; i<26; i++) {
			if(arr[i] !=0 && arr[i] != max) {
				return false;
			}
			else if(arr[i] !=0 && arr[i] == max){
				len++;
			}
		}

		String str = s.substring(0,len);

		for(int i=0; i<s.length(); i=i+len){
			String temp = s.substring(i,i+len);
			if(!temp.equals(str)) {
				return false;
			}
		}

		return true;
	}

}
