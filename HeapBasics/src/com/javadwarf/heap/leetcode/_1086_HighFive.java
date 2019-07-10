package com.javadwarf.heap.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class _1086_HighFive {

	public static void main(String[] args) {

	}

	public int[][] highFive(int[][] items) {
		
		Map<Integer, Queue<Integer>> map = new TreeMap<>();
		
		for(int i=0; i<items.length; i++) {
			Queue<Integer> q = map.getOrDefault(items[i][0], new PriorityQueue<>(Collections.reverseOrder()));
			q.add(items[i][1]);
			map.put(items[i][0],q);
		}
		
		int[][] res = new int[map.size()][2];
		Set<Map.Entry<Integer,Queue<Integer>>> set = map.entrySet();
		Iterator<Map.Entry<Integer,Queue<Integer>>> itr = set.iterator();
		
		while(itr.hasNext()) {
			Map.Entry<Integer,Queue<Integer>> e = itr.next();
			int sum = 0;
			int i =0;
			while(i<5 && !e.getValue().isEmpty()) {
				sum += e.getValue().poll();
				i++;
			}
			res[e.getKey()-1][0] =e.getKey();
			res[e.getKey()-1][1] = sum/i;
		}
		return res;

	}

}
