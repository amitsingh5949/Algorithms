package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

	
	// Finding all paths using backtracking dfs gives time limit exceeded 
	// USe BFS , see the same solution in bfs package
	List<List<String>> res = null;
	Map<String, List<String>> graph = null;
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		res = new ArrayList<List<String>>();
		graph = new HashMap<String, List<String>>();
		generateGraph(beginWord, endWord, wordList);

		List<String> curr =  new ArrayList<>();
		curr.add(beginWord);

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		dfs(beginWord, endWord, curr,visited);
		
		int min = Integer.MAX_VALUE;
		
		for(List<String> l : res) {
			min = Math.min(min, l.size());
		}

		return min==Integer.MAX_VALUE?0:min;
	}

	public void dfs(String beginWord, String endWord, List<String> list, Set<String> visited) {

		if(beginWord.equals(endWord)) {
			res.add(new ArrayList<>(list));
			return;
		}

		for(int j =0; j<beginWord.length(); j++) {
			String key = beginWord.substring(0,j) +  "*" + beginWord.substring(j+1);
			List<String> neighbors = graph.get(key);

			for(String neighbor : neighbors) {

				if(!visited.contains(neighbor)) {
					list.add(neighbor);
					visited.add(neighbor);
					dfs(neighbor,endWord,list, visited);
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
