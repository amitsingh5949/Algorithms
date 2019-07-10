package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _500_KeyboardRow {

	public static void main(String[] args) {

	}

	public String[] findWords(String[] words) {

		Set<Character> set1 = "qwertyuiop".chars().mapToObj(e->(char)e).collect(Collectors.toSet());
		Set<Character> set2 = "asdfghjkl".chars().mapToObj(e->(char)e).collect(Collectors.toSet());
		Set<Character> set3 = "zxcvbnm".chars().mapToObj(e->(char)e).collect(Collectors.toSet());

		List<String> l = new ArrayList<>();
		
		outer : for(String word : words) {
			String wordLow = word.toLowerCase();
			Set<Character> set  = set1.contains(wordLow.charAt(0))? set1 : ( set2.contains(wordLow.charAt(0))? set2 : set3);
			for(int i = 0; i<wordLow.length(); i++) {
				if(!set.contains(wordLow.charAt(i))) {
					continue outer;
				}
			}
			l.add(word);
		}
		return l.toArray(new String[l.size()]);
	}

}
