package com.javadwarf.trie.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1032_StreamofCharacters {

	public static void main(String[] args) {

	}
	
	

}


class StreamChecker {
	
	Set<Character> set =null;

    public StreamChecker(String[] words) {
    	this.set = new HashSet<>();
    	
    	for(String word : words) {
    		set.add(word.substring(word.length()-1).charAt(0));
    	}
    }
    
    public boolean query(char letter) {
        return this.set.contains(letter);
    }
}
