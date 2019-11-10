package com.javadwarf.hashtable.leetcode;

public class _953_VerifyinganAlienDictionary {

	public static void main(String[] args) {
		
		String[] arr = {"ubg","kwh"};
		System.out.println(new _953_VerifyinganAlienDictionary().isAlienSorted(arr, "qcipyamwvdjtesbghlorufnkzx"));

	}

	public boolean isAlienSorted(String[] words, String order) {

		int[] map = new int[26];

		for(int i=0; i<order.length(); i++) {
			map[order.charAt(i)-'a'] = i;
		}

		for(int i=0; i<words.length; i++) {

			for(int j=i+1; j<words.length; j++) {

				for(int k=0; k<words[i].length(); k++) {
					if(k == words[j].length() || map[words[i].charAt(k)-'a']>map[words[j].charAt(k)-'a']) {
						return false;
					}
					else if(map[words[i].charAt(k)-'a']<map[words[j].charAt(k)-'a']) {
						break;
					}
				}
			}
		}

		return true;
	}

}
