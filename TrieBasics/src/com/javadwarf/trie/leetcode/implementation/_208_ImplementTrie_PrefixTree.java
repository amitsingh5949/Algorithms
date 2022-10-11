package com.javadwarf.trie.leetcode.implementation;

import java.util.HashMap;
import java.util.Map;

public class _208_ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		
		Trie obj = new Trie();
		
		obj.insertRec("abc");
		obj.insertRec("abgl");
		obj.insertRec("cdf");
		obj.insertRec("abcd");
		obj.insertRec("lmn");
		
		obj.deleteWordRec("abc");
		System.out.println(obj.startsWith("abc"));
		System.out.println(obj.search("abc"));
		obj.deleteWordRec("abgl");
		System.out.println(obj.search("abgl"));
		obj.deleteWordRec("abcd");
		System.out.println(obj.search("abcd"));
		
		System.out.println();
		
		
		
		
	}
}

class TrieImpl {
	
    TrieNode root;
    public TrieImpl() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int start = 0;
        TrieNode temp = root;
        while(start < word.length()){
            TrieNode curr = temp.map.getOrDefault(word.charAt(start), new TrieNode());
            temp.map.put(word.charAt(start),curr);
            temp = curr;
            start++;
        }
        temp.end = true;
    }
    
    public boolean search(String word) {
        int start = 0;
        TrieNode temp = root;
        while(start < word.length()){
            TrieNode curr = temp.map.get(word.charAt(start));
            if( curr == null){
                return false;
            }
            temp = curr;
            start++;
        }
        return temp.end;
    }
    
    public boolean startsWith(String prefix) {
        int start = 0;
        TrieNode temp = root;
        while(start < prefix.length()){
            TrieNode curr = temp.map.get(prefix.charAt(start));
            if( curr == null){
                return false;
            }
            temp = curr;
            start++;
        }
        return true;
    }
    
    class TrieNode{
    boolean end;
    Map<Character, TrieNode> map;
    public TrieNode(){
        map = new HashMap<>();
        end = false;
    }
}
    
    // same as above using recursion
    class TrieImplRec {
        TrieNode root;
        public TrieImplRec() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            insertRec(word,0, root);
        }

        public void insertRec(String word, int index, TrieNode temp) {
            if(index == word.length()){
                temp.end = true;
                return;
            }
            TrieNode curr = temp.map.getOrDefault(word.charAt(index), new TrieNode());
            temp.map.put(word.charAt(index), curr);
            insertRec( word, index+1, curr);
        }
        
        public boolean search(String word) {
            return searchRec(word,0, root);
        }

        public boolean searchRec(String word, int index, TrieNode temp) {
            if(index == word.length()) return temp.end;
            TrieNode curr = temp.map.get(word.charAt(index));
            if(curr == null) return false;
            return searchRec(word, index+1, curr);
        }
        
        public boolean startsWith(String prefix) {
            return startsWithRec(prefix, 0, root);
        }
        public boolean startsWithRec(String prefix, int index, TrieNode temp) {
            if(index == prefix.length()) return true;
            TrieNode curr = temp.map.get(prefix.charAt(index));
            if(curr == null) return false;
            return startsWithRec(prefix, index+1, curr);
        }

        class TrieNode{
            Map<Character, TrieNode> map;
            boolean end;
            public TrieNode(){
                map = new HashMap<>();
                end = false;
            }
        }
    }

}


