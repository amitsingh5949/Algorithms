package com.javadwarf.string.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _819_MostCommonWord {

	public static void main(String[] args) {
System.out.println(new _819_MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL .flew far after it was hit.", 
		new String[] {"hit"}));
	}
	
	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.replaceAll(",","");
		paragraph = paragraph.replace(".", "");
		paragraph = paragraph.replaceAll("!", "");
		paragraph = paragraph.replaceAll(";", "");
		paragraph = paragraph.replaceAll("'", "");
		paragraph = paragraph.replaceAll("?", "");
		paragraph = paragraph.replaceAll(":", "");
		
		paragraph = paragraph.toLowerCase();
		
		Map<String, Integer> map = new HashMap<>();
		for(String word : banned) {
			map.put(word.trim(), -1);
			map.put(",", -1);
			map.put(".", -1);
			map.put("!", -1);
			map.put("?", -1);
			map.put("", -1);
			
		}
		int maxlen = 0;
		String maxStr = "";
		String[] arr = paragraph.split(" ");
		
		for(String word : arr) {
			int count = map.getOrDefault(word.trim(), 0);
			if(count != -1) {
				map.put(word.trim(), count +1);
				if(maxlen <= count) {
					maxlen = count +1;
					maxStr = word;
				}
			}
		}
		return maxStr;
		
	}
}
