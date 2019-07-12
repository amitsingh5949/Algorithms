package com.javadwarf.trie.leetcode.implementation;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	public Map<Character,TrieNode> map = null;//if the string is only lower case letter then we can also use an array of 26 characters
	public boolean endOfWord = false;

	public TrieNode() {
		map = new HashMap<>();
		endOfWord = false;
	}

}
