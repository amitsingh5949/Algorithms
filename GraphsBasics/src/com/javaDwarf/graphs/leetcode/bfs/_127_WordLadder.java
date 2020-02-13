package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _127_WordLadder {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		String[] words = new String[]{"hot","dot","dog","lot","log","cog"};

		for(String s : words) {
			wordList.add(s);
		}
		System.out.println(new _127_WordLadder().ladderLength("hit", "cog", wordList));
	}


	Map<String, List<String>> graph = null;
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		graph = new HashMap<String, List<String>>();
		generateGraph(beginWord, endWord, wordList);

		Set<String> visited = new HashSet<>(); 

		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		visited.add(beginWord);
		q.add(null);

		int count = 0;

		while(q.size()>1) {

			String word = q.poll();

			if(word == null) {
				q.add(null);
				count++;
				continue;
			}

			if(word.equalsIgnoreCase(endWord)) {
				return ++count;
			}

			for(int j =0; j<word.length(); j++) {
				
				String key = word.substring(0,j) +  "*" + word.substring(j+1);
				List<String> neighbors = graph.get(key);
				
				for(String neighbor : neighbors) {
					if(!visited.contains(neighbor)) {
						visited.add(neighbor);
						q.add(neighbor);
					}
				}
			}
		}
		return 0;
	}

	public void generateGraph(String beginWord, String endWord, List<String> wordList) {

		wordList.add(beginWord);

		for(String word : wordList) {
			for(int j =0; j<word.length(); j++) {
				String key = word.substring(0,j) +  "*" + word.substring(j+1);
				List<String> neighbors = graph.getOrDefault(key, new ArrayList<>());
				neighbors.add(word);
				graph.put(key, neighbors);
			}
		}
	}

}
