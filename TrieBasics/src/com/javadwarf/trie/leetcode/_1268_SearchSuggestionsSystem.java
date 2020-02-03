package com.javadwarf.trie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1268_SearchSuggestionsSystem {

	class TrieNode {

		public TrieNode[] map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new TrieNode[26];
			endOfWord = false;
		}

	}

	class Trie {

		public TrieNode root = null;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {

			TrieNode curr = root;

			int i = 0;
			while(i < word.length()) {
				Character ch = word.charAt(i);

				if(curr.map[ch-'a'] == null) {
					TrieNode next = new TrieNode();
					curr.map[ch-'a'] = next;
					curr = next;
				}
				else {
					curr = curr.map[ch-'a'];
				}
				i++;
			}
			curr.endOfWord = true;
		}

	}



	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

		List<List<String>> res = new ArrayList<List<String>>();
		Trie t = new Trie();

		for(String product : products) {
			t.insert(product);
		}

		TrieNode root = t.root;
		String curr = "";

		boolean found = true;

		for(char ch : searchWord.toCharArray()) {

			List<String> temp = new ArrayList<>();

			if(found  && root.map[ch-'a'] != null) {
				curr += ch;
				root= root.map[ch-'a'];
				res.add(getWords(root, new StringBuilder(curr), temp));
			}
			else{
				found  = false;
				res.add(temp);
			}
		}
		return res;
	}

	public List<String> getWords(TrieNode curr, StringBuilder wordSoFar, List<String> temp ){

		if(temp.size() ==  3) {
			return temp;
		}

		if(curr.endOfWord) {
			temp.add(new StringBuilder(wordSoFar).toString());
		}

		TrieNode[] nodes = curr.map;

		for(int i=0; i<nodes.length; i++) {
			if(nodes[i] != null){
				char add =((char)(i+97));
				wordSoFar.append(add);
				temp = getWords(nodes[i], wordSoFar, temp);
				wordSoFar.deleteCharAt(wordSoFar.length()-1);
			}
		}
		return temp;
	}


	public static void main(String[] args) {

		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"}; 
		String searchWord = "mouse";

		System.out.println(new _1268_SearchSuggestionsSystem().suggestedProducts(products, searchWord));

	}

}
