package com.javadwarf.trie.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _211_AddandSearchWordDatastructuredesign {
	
}

class WordDictionary {
	
	class TrieNode {
		
		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new HashMap<>();
			endOfWord = false;
		}
	}
	
    public TrieNode root = null;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;

		int i = 0;
		while(i < word.length()) {
			Character ch = word.charAt(i);

			if(!curr.map.containsKey(ch)) {
				TrieNode next = new TrieNode();
				curr.map.put(ch,next);
				curr = next;
			}
			else {
				curr = curr.map.get(ch);
			}
			i++;
		}
		curr.endOfWord = true;
    }
    

    public boolean search(String word) {
		return search(word, root, 0);
    }
    
    public boolean search(String word, TrieNode curr, int index) {
    	
    	if(index == word.length()) {
    		return curr.endOfWord;
    	}
    	
    	Character ch = word.charAt(index);
    	
    	if(!curr.map.containsKey(ch)) {
    		if(ch.charValue() != '.') {
    			return false;
    		}
    		else {
    			Set<Map.Entry<Character, TrieNode>> set = curr.map.entrySet();
    			Iterator<Map.Entry<Character, TrieNode>> itr = set.iterator();
    			boolean result = false;
    			while(itr.hasNext()) {
    				Map.Entry<Character, TrieNode> e = itr.next();
    				result = result ||  search(word, e.getValue(), index+1);
    			}
    			return result;
    		}
    	}
    	return search(word, curr.map.get(ch), index+1);
    }
}





// same code as above just TrieNode is an array[26] instead of map
    
class WordDictionary1 {
	
	class TrieNode {
	    public char val;
	    public TrieNode[] children = new TrieNode[26]; // notice this
	    public boolean isWord = false;
	    public TrieNode() {}
	    public TrieNode(char c) {
	        this.val = c;
	    }
	}

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary1() {
         root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = Character.toLowerCase(word.charAt(i));
            if (currentNode.children[currentChar - 'a'] == null) {
                currentNode.children[currentChar - 'a'] = new TrieNode(currentChar);
            }
            currentNode = currentNode.children[currentChar - 'a'];
        }
        currentNode.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    // backtrack
    private boolean search(String word, int index, TrieNode currentNode) {
        if (index == word.length()) {
            return currentNode.isWord;
        }
        if (word.charAt(index) != '.') {
            if (currentNode.children[word.charAt(index) - 'a'] != null) {
                return search(word, index+1, currentNode.children[word.charAt(index) - 'a']);
            }
        } else {
        	boolean result = true;
            for (int i = 0; i < currentNode.children.length; i++) {
                if (currentNode.children[i] != null) {
                    result = result ||  search(word, index+1, currentNode.children[i]);
                }
            }
            return result;
        }
        return false;
    }
}
