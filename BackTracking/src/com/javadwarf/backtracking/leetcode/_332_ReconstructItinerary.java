package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _332_ReconstructItinerary {

	public static void main(String[] args) {
		String[][] arr = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		
		List<List<String>> tickets = new ArrayList<List<String>>();
		
		for(String[] ticket : arr) {
			tickets.add(Arrays.asList(ticket));
		}
		
		new _332_ReconstructItinerary().findItinerary(tickets);
	}

	List<String> itinearay = null;
	Map<String, PriorityQueue<String>> map = null;
	
	int required = Integer.MAX_VALUE;

	public List<String> findItinerary(List<List<String>> tickets) {

		itinearay = new ArrayList<String>();
		map = new HashMap<>();
		
		for(List<String> ticket : tickets) {
			map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
		}
		required = map.size();
		
		for(String start : map.keySet()) {
			findItinerary(start);
		}
		

		return itinearay;
	}
	
	public void findItinerary(String start) {
		
	}
	
	

}
