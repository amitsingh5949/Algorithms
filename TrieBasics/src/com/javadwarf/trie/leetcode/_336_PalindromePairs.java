package com.javadwarf.trie.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _336_PalindromePairs {


	public static void main(String[] args) {
		//List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"a","ab"}); //[[1, 0]]
		//List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"});
		//List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"a",""});
		//List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"a","aa","aaa"});
		//List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"ab","ba","abc","cba"});

		List<List<Integer>> x = new _336_PalindromePairs().palindromePairs(new String[] {"aba","ba","a","caba"});
		System.out.println(x);
	}

	class TrieNode {

		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new HashMap<>();
			endOfWord = false;
		}

	}

	TrieNode root = new TrieNode();
	List<List<Integer>> ll  = new ArrayList<List<Integer>>();
	Map<String, Integer> map = new HashMap<>();

	public List<List<Integer>> palindromePairs(String[] words) {

		if(words == null || words.length == 0) return ll;
		int i = 0;
		for(String word : words) {
			insert(word);
			map.put(word, i++);
		}

		for(i=0; i<words.length; i++) {
			serach(words[i]);
		}
		return ll;
	}

	public void insert(String word) {

		TrieNode curr = this.root;

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

	public void serach(String word) {


		String wordRev = new StringBuffer(word).reverse().toString();

		TrieNode curr = this.root;

		int i = 0 ;
		String prefix = "";
		while( i<wordRev.length()) {

			if(curr.endOfWord && i < wordRev.length()) {
				String temp1 =  wordRev.substring(i);
				if( isPallindrom(temp1) ) {
					addToList( prefix, word);
				}
			}

			Character ch = wordRev.charAt(i);
			prefix+=ch;
			if(!curr.map.containsKey(ch)) {
				return;
			}
			curr = curr.map.get(ch);
			i++;
		}

		if(i == word.length()) {
			if(curr.endOfWord) {
				addToList(prefix, word);
			}
			List<String> rems =  remainingStrings(curr, new ArrayList<String>(), "");
			for(String str : rems) {
				addToList(prefix+str, word);
			}

		}
	}

	public List<String> remainingStrings(TrieNode curr,List<String> l, String currWord){
		if( currWord.length() > 0 && curr.endOfWord && isPallindrom(currWord)) {
			l.add(currWord);
		}
		Set<Map.Entry<Character, TrieNode>> set = curr.map.entrySet();
		Iterator<Map.Entry<Character, TrieNode>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Character, TrieNode> e = itr.next();
			l = remainingStrings(e.getValue(), l, currWord+e.getKey());
		}
		return l;
	}

	public boolean isPallindrom(String word) {
		int start = 0;
		int end = word.length()-1;

		while(start < end) {
			if(word.charAt(start++) != word.charAt(end--))  return false;
		}
		return true;
	}

	public void addToList(String str1, String str2) {
		List<Integer> l = new ArrayList<>();
		int p = map.get(str1);
		int q = map.get(str2); 
		if(p!=q) {
			l.add(p);
			l.add(q);
			ll.add(l);
		}
	}
}
