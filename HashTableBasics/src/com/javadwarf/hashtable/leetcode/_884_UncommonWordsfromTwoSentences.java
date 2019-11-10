package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _884_UncommonWordsfromTwoSentences {

	public static void main(String[] args) {

	}

	
	// or we can have only one map and add all words and count, if word has count == 1 then that is good word
	public String[] uncommonFromSentences(String A, String B) {
		
		Map<String , Integer> map1 = new HashMap<>();
		Map<String , Integer> map2 = new HashMap<>();
		
		for(String word : A.split(" ")) {
			int count = map1.getOrDefault(word, 0);
			map1.put(word,count+1);
		}
		
		for(String word : B.split(" ")) {
			int count = map2.getOrDefault(word, 0);
			map2.put(word,count+1);
		}
		
		List<String> l = new ArrayList<>();
		
		for(String word : A.split(" ")) {
			if(map1.get(word) == 1 && !map2.containsKey(word)) {
				l.add(word);
			}
		}
		
		for(String word : B.split(" ")) {
			if(map2.get(word) == 1 && !map1.containsKey(word)) {
				l.add(word);
			}
		}
		
		return l.toArray(new String[l.size()]);

	}

}
