package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _721_AccountsMerge {

	public static void main(String[] args) {}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> res = new ArrayList<>();
		createGraph(accounts);

		Set<String> visited = new HashSet<>();
		for(String key : graph.keySet()){
			List<String> temp = new ArrayList<>();
			if(!visited.contains(key)){
				helper(accounts, key, visited, temp);
				Collections.sort(temp);
				int accIndex = graph.get(key).get(0);
				String name = accounts.get(accIndex).get(0);
				temp.add(0, name);
				res.add(temp);
			}
		}
		return res;
	}


	public void helper(List<List<String>> accounts, String email, Set<String> visited, List<String> temp){

		temp.add(email);
		visited.add(email);

		for(int i=0; i<graph.get(email).size(); i++){
			int accIndex = graph.get(email).get(i);
			for( int j=1; j<accounts.get(accIndex).size(); j++){
				String neighborEmail = accounts.get(accIndex).get(j);
				if(!visited.contains(neighborEmail)){
					helper(accounts, neighborEmail, visited, temp);
				}
			}
		}

	}

	// for every email, store its occurrence in all accounts indices and run dfs
	Map<String, List<Integer>> graph;
			public void createGraph(List<List<String>> accounts){
				graph = new HashMap<>();
				for( int j = 0; j<accounts.size(); j++){
					List<String> acc = accounts.get(j);
					for(int i=1; i<acc.size(); i++){
						List<Integer> temp = graph.getOrDefault(acc.get(i), new ArrayList<>());
						temp.add(j);
						graph.put(acc.get(i), temp);
					}
				}
			}

}
