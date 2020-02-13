package com.javaDwarf.graphs.leetcode.shortestpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _126_WordLadderII {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<String>();
		String[] words = new String[]{"hot","dot","dog","lot","log","cog"};
		//String[] words = new String[]{"hot","dot","dog","cog"};
		for(String s : words) {
			wordList.add(s);
		}
		System.out.println(new _126_WordLadderII().findLadders("hit", "cog", wordList));
	}

	List<List<String>> res = null;
	Map<String, List<String>> graph = null;

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		res = new ArrayList<List<String>>();
		graph = new HashMap<String, List<String>>();
		generateGraph(beginWord, endWord, wordList);


		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

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
				count++;
				break;
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

		if(count == 0) {
			return res;
		}
		else {
			List<String> curr =  new ArrayList<>();
			curr.add(beginWord);
			visited.clear();
			visited.add(beginWord);
			dfs(beginWord, endWord, curr, visited, count);
		}


		return res;
	}


	public void dfs(String beginWord, String endWord, List<String> list, Set<String> visited, int count) {

		if(count == list.size()) {
			if(beginWord.equals(endWord)) {
				res.add(new ArrayList<>(list));
			}
			return;
		}

		for(int j =0; j<beginWord.length(); j++) {
			String key = beginWord.substring(0,j) +  "*" + beginWord.substring(j+1);
			List<String> neighbors = graph.get(key);

			for(String neighbor : neighbors) {

				if(!visited.contains(neighbor)) {
					list.add(neighbor);
					visited.add(neighbor);
					dfs(neighbor,endWord,list, visited,count);
					visited.remove(neighbor);
					list.remove(list.size()-1);
				}
			}
		}
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
