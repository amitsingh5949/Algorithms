package com.javadwarf.hashtable.leetcode;

public class _1160_FindWordsThatCanBeFormedbyCharacters {

	public static void main(String[] args) {

	}

	public int countCharacters(String[] words, String chars) {

		int[] map = new int[26];

		for(int i=0;i<chars.length();i++) {
			map[chars.charAt(i)-'a'] +=1;
		}

		int len = 0;

		for(String word: words) {

			boolean isGood = true;
			int[] mapWord = new int[26];
			
			for(int i=0;i<word.length();i++) {
				mapWord[word.charAt(i)-'a'] +=1;
			}
			
			for(int i =0; i<26; i++) {
				if(mapWord[i] > map[i]) {
					isGood = false;
					break;
				}
			}
			
			if(isGood) {
				len += word.length();
			}
		}
		return len;
	}
}
