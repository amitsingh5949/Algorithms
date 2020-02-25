package com.javadwarf.trie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _472_ConcatenatedWords {

	public static void main(String[] args) {
		System.out.println(new _472_ConcatenatedWords().findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
		//System.out.println(new _472_ConcatenatedWords().findAllConcatenatedWordsInADict(new String[] {"catsdog", "cats","dog"}));

		//System.out.println(new _472_ConcatenatedWords().findAllConcatenatedWordsInADict(new String[] {"catsdogcats","cat","cats","dog"}));

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> res = new ArrayList<String>();
		Trie t = new Trie();

		for(String word : words) {
			t.insert(word);
		}

		for(String word : words) {
			if(t.check(word, 0, 0, t.root)) {
				res.add(word);
			}
		}

		return res;
	}

	class TrieNode{
		TrieNode[] map = null;
		boolean isEnd = false;

		public TrieNode() {
			map = new TrieNode[26];
			isEnd = false;
		}
	}

	class Trie{
		TrieNode root = null;

		public Trie(){
			root = new TrieNode();
		}

		public void insert(String word) {

			TrieNode curr = root;

			for(char ch : word.toCharArray()) {
				if(curr.map[ch-'a']==null) {
					TrieNode next = new TrieNode();
					curr.map[ch-'a'] = next;
					curr = next;
				}
				else {
					curr = curr.map[ch-'a'];
				}
			}
			curr.isEnd = true;
		}

		public boolean check(String word, int index, int level, TrieNode root ) {

			TrieNode curr = root;

			for(int i = index ; i<word.length(); i++) {

				char ch = word.charAt(i);

				if(curr.map[ch-'a'] != null) {

					curr = curr.map[ch-'a'];// in trie befor checking is end get the node first

					if(curr.isEnd) {

						if(i == word.length()-1) {
							return level >= 1;
						}
						if( check(word, i+1, level+1, root)) {// important condition, don't return false  eg :{"catsdogcats","cat","cats","dog"}
							return true;
						}
					}
				}
				else {
					return false;
				}
			}
			return false;
		}

	}

}
