package com.javaDwarf.graphs.leetcode.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _332_ReconstructItinerary {

	public static void main(String[] args) {

	}

	public static Map<String, PriorityQueue<String>> graph = null;

	public List<String> findItinerary(List<List<String>> tickets) {

		graph = new HashMap<>();

		for(List<String> ticket : tickets) {
			PriorityQueue<String> pq = graph.getOrDefault(ticket.get(0), new PriorityQueue<String>());
			pq.add(ticket.get(1));
			graph.put(ticket.get(0), pq);
		}
		LinkedList<String> route = new LinkedList<String>();
		route.addLast("JFK");
		dfs("JFK", tickets.size()+1, route);
		return route;
	}

	LinkedList<String> dfs(String src, int expectedRouteLength, LinkedList<String> l) {
		if(l.size() == expectedRouteLength) {
			return l;
		}
		PriorityQueue< String> pq = graph.get(src);
		while(pq!=null && pq.size() > 0) {
			String dest = pq.poll();
			l.addLast(dest);
			l = dfs(dest,expectedRouteLength,l);
			if(l.size() == expectedRouteLength) {
				break;
			}
			else {
				String before = l.removeLast();
				if(pq.size() > 0) {
					String destNew = pq.poll();
					pq.add(before);
					l.addLast(destNew);
					l = dfs(destNew,expectedRouteLength,l);
				}
				else {
					pq.add(before);	
				}
			}
		}
		return l;
	}

}
