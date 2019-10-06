package com.javaDwarf.graphs.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _269_AlienDictionary {

	public static void main(String[] args) {
		//String[] words = {"wrt","wrf","er","ett","rftt"};
		//String[] words = {"z","w","z"};
		//String[] words = {"z","z"};
		String[] words = {"ab","adc"};
		System.out.println(alienOrder(words));
	}

	public static Map<Character, ArrayList<Character>> graph = null;
	public static Map<Character, Integer> degree = null;

	public  static String alienOrder(String[] words) {
		
		createGraph(words);// create graph

		// Add edges based on dictionary ordering. For every pair of words, If in two words if chars are same then skip else add edge b/w those two chars
		for(int i=0; i<words.length-1; i++) {

			for(int j= i+1; j<words.length; j++) {

				String first = words[i];
				String second = words[j];

				int k = 0;

				while( k < first.length() && k < second.length() && (first.charAt(k) == second.charAt(k)) ) {
					k++;
				}

				if(k < first.length() && k < second.length()) {
					addEdge(first.charAt(k), second.charAt(k));
				}

			}
		}
		
		// Once graph constructed and we get degree of each vertex as well then use topological sort.

		String res = "";
		int count  = 0;
		Queue<Character> q = new LinkedList<>();

		Set<Map.Entry<Character,Integer>> degreeEntrySet = degree.entrySet();
		Iterator<Map.Entry<Character,Integer>> itr = degreeEntrySet.iterator();
		while(itr.hasNext()) {
			Map.Entry<Character,Integer> e = itr.next();
			if(e.getValue() == 0) {
				q.add(e.getKey());
			}
		}

		while(!q.isEmpty()) {

			Character ch = q.poll();
			res += ch;
			count++;

			ArrayList<Character> neighbors = graph.get(ch);
			if(neighbors!=null) {
				for(Character neighbor : neighbors) {
					Integer degreeCurr = degree.get(neighbor);
					degree.put(neighbor, degreeCurr-1);
					if((degreeCurr-1) == 0) {
						q.add(neighbor);
					}
				}
			}

		}

		if(count != degree.size()) return "";
		return res;
	}

	public static void createGraph(String[] words) {

		graph = new HashMap<>();
		degree = new HashMap<>();

		for(int i=0; i<words.length; i++) {
			for(char ch : words[i].toCharArray()) {
				if(!graph.containsKey(ch)) {
					graph.put(ch,  new ArrayList<>());
					degree.put(ch, 0);
				}
			}
		}
	}

	public static void addEdge(char src, char dest) {
		ArrayList<Character> neighbors = graph.getOrDefault(src, new ArrayList<>());
		if(!neighbors.contains(dest)) {
			neighbors.add(dest);
			graph.put(src, neighbors);

			Integer degreeCountSrc = degree.getOrDefault(src, 0);
			degree.put(src, degreeCountSrc);

			Integer degreeCountDest = degree.getOrDefault(dest, 0);
			degree.put(dest, degreeCountDest+1);
		}
	}

}


