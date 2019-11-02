package com.javadwarf.string.leetcode;

public class _1165_SingleRowKeyboard {

	public static void main(String[] args) {
		System.out.println(new _1165_SingleRowKeyboard().calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
		System.out.println(new _1165_SingleRowKeyboard().calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));

	}
	
	 public int calculateTime(String keyboard, String word) {
		 
		 int[] keyLen = new int[26];
		 
		 for(int i=0; i<26; i++) {
			 char ch = keyboard.charAt(i);
			 keyLen[ch-'a'] = i;
		 }
		 
		 int count = 0;
		 
		 for(int i= 0; i<word.length(); i++) {
			 if(i==0) {
				 count += keyLen[word.charAt(0)-'a'];
			 }
			 else {
				 count += Math.abs(keyLen[word.charAt(i) -'a'] - keyLen[word.charAt(i-1)-'a']) ;
			 }
		 }
		 
		 return count;
	        
	    }

}
