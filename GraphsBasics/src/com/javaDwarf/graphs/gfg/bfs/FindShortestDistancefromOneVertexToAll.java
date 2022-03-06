package com.javaDwarf.graphs.gfg.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class FindShortestDistancefromOneVertexToAll {

	public static void main(String[] args) {
		String source = "A";
		String edges = "A,B;B,C;A,C;B,D;C,D;D,E;F,G;G,H;F,H";
		System.out.println(solution(source, edges));
	}

	public static Map<Character, Integer> res = null;
	public static Map<Character, Integer>solution(String source, String edges) {

		res= new HashMap<>();
		generateGraph(source, edges);

		Queue<Character> q = new LinkedList<>();
		Set<Character> visited = new HashSet<>();
		q.add(source.charAt(0));
		visited.add(source.charAt(0));

		int count = 1;

		while(!q.isEmpty()) {

			int size = q.size();

			for(int i=0; i<size; i++) {
				char currVertex = q.poll();
				Set<Character> neighbours = vertextList.get(currVertex);

				for(char neighbor : neighbours) {
					if(!visited.contains(neighbor)){
						res.put(neighbor, count);
						q.add(neighbor);
						visited.add(neighbor);
					}
				}
			}
			count++;
		}
		return res;
	}


	public static Map<Character, Set<Character>> vertextList= new HashMap<>();

	public static void generateGraph(String source, String edgesStr){

		for(char ch : edgesStr.toCharArray()) {
			if(ch != ';' && ch != ',') {
				vertextList.put(ch, new HashSet<>());
				res.put(ch, Integer.MAX_VALUE);
			}
		}
		vertextList.put(source.charAt(0), new HashSet<>());
		res.remove(source.charAt(0));

		String[] edges = edgesStr.split(";");
		for(String edge : edges) {
			if(edge.length() == 3) {
				vertextList.get(edge.charAt(0)).add(edge.charAt(2));
				vertextList.get(edge.charAt(2)).add(edge.charAt(0));
			}
		}
	}
}
