package com.javadwarf.hashtable.leetcode;

public class _748_ShortestCompletingWord {

	public static void main(String[] args) {

	}

	public String shortestCompletingWord(String licensePlate, String[] words) {

		
		licensePlate =  licensePlate.toLowerCase();
		int[] map1 = new int[26];

		for(int i=0; i<licensePlate.length(); i++) {
			if(Character.isLetter(licensePlate.charAt(i)))
				map1[licensePlate.charAt(i)-'a'] +=1;
		}

		int index = -1;
		int len  = Integer.MAX_VALUE;

		for(int i=0; i<words.length; i++) {

			int[] map2 = new int[26];

			for(int j=0; j<words[i].length(); j++) {
				map2[words[i].charAt(j)-'a'] +=1;
			}

			boolean isGood = true;
			for(int k=0; k<26; k++) {
				if(map1[k] > map2[k]) {
					isGood = false;
					break;
				}

			}

			if(isGood && words[i].length() < len) {
				index = i;
				len = words[i].length();
			}

		}

		return index != -1? words[index] : null;

	}

}
