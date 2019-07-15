package com.javadwarf.trie.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _642_DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
		int[] times =  {5,3,2,2};
		AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
		
		List<String> param_1 = obj.input('i');
		System.out.println(param_1);
		List<String> param_2 = obj.input(' ');
		System.out.println(param_2);
		List<String> param_3 = obj.input('a');
		System.out.println(param_3);
		List<String> param_4 = obj.input('#');
		System.out.println(param_4);
		
		List<String> param_5 = obj.input('i');
		System.out.println(param_5);
		List<String> param_6 = obj.input(' ');
		System.out.println(param_6);
		List<String> param_7 = obj.input('a');
		System.out.println(param_7);
		List<String> param_8 = obj.input('#');
		System.out.println(param_8);
		
		List<String> param_9 = obj.input('i');
		System.out.println(param_9);
		List<String> param_10 = obj.input(' ');
		System.out.println(param_10);
		List<String> param_11 = obj.input('a');
		System.out.println(param_11);
		List<String> param_12 = obj.input('#');
		System.out.println(param_12);
		
	}
}

class AutocompleteSystem {
	
	class TrieNode {

		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new HashMap<>();
			endOfWord = false;
		}
	}

	class Element implements Comparable<Element>{
		String sentence =null;
		int times = 0;
		public Element(String sentence, int times) {
			super();
			this.sentence = sentence;
			this.times = times;
		}
		@Override
		public int compareTo(Element o) {
			int x = Integer.compare(this.times, o.times);
			if(x == 0) {
				return o.sentence.compareTo(this.sentence);
			}
			return x;
		}
	}

	Map<String, Integer> map = null;
	String prefix = null;
	TrieNode root = null;
	Queue<AutocompleteSystem.Element> q = null;

	public AutocompleteSystem(String[] sentences, int[] times) {
		this.q = new PriorityQueue<AutocompleteSystem.Element>(Collections.reverseOrder());
		this.root = new TrieNode();
		this.prefix = "";
		this.map = new HashMap<>();
		for(int i=0; i<sentences.length; i++) {
			map.put(sentences[i], times[i]);
			insert(sentences[i]);
		}
	}

	public List<String> input(char c) {

		List<String> l = new ArrayList<String>();

		if(c == '#') {
			int count = map.getOrDefault(this.prefix, 0);
			if(count == 0) {
				insert(prefix);
			}
			map.put(this.prefix,count+1);
			this.prefix = "";
			this.q.clear();
			return l;
		}

		this.prefix += c;

		List<String> remianingSentences = serach(this.prefix);

		for(String remianingSentence :remianingSentences) {
			String sentence = this.prefix + remianingSentence;
			int times = map.getOrDefault(sentence, 0);
			q.add(new Element(sentence, times));
		}

		int i=0;
		while(i<3 && !q.isEmpty()) {
			l.add(q.poll().sentence);
			i++;
		}
		this.q.clear();
		return l;
	}

	public void insert(String word) {

		TrieNode curr = root;

		int i=0;
		while(i<word.length()) {
			Character ch = word.charAt(i);	
			if(!curr.map.containsKey(ch)) {
				curr.map.put(ch, new TrieNode());
			}
			curr = curr.map.get(ch);
			i++;
		}
		curr.endOfWord = true;
	}


	private List<String> serach(String currPrefix) {

		TrieNode curr = root;

		int i=0;
		while(i<currPrefix.length()) {

			Character ch = currPrefix.charAt(i);
			if(!curr.map.containsKey(ch)) {
				return new ArrayList<String>();
			}
			curr = curr.map.get(ch);
			i++;
		}

		return getAllSentencesWithCurrPrefix(curr,new ArrayList<String>(), "");
	}

	private List<String> getAllSentencesWithCurrPrefix(TrieNode curr, List<String> l, String currWord) {

		if(curr.endOfWord) {
			l.add(currWord);
		}
		Set<Map.Entry<Character, TrieNode>> s = curr.map.entrySet();
		Iterator<Map.Entry<Character, TrieNode>> itr = s.iterator();
		while(itr.hasNext()) {
			Map.Entry<Character, TrieNode> e = itr.next();
			l = getAllSentencesWithCurrPrefix(e.getValue(), l, currWord+e.getKey());
		}
		return l;
	}
}
