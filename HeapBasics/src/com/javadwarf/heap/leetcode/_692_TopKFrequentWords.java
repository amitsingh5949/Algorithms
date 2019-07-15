package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _692_TopKFrequentWords {

	public static void main(String[] args) {

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
	Queue<Element> q = null;
	public List<String> topKFrequent(String[] words, int k) {

		this.q = new PriorityQueue<Element>(Collections.reverseOrder());
		this.map = new HashMap<>();		 
		List<String> l = new ArrayList<String>();
		for(String word :words) {
			int count = map.getOrDefault(word, 0);
			map.put(word, count+1);
		}
		
		Set<Map.Entry<String, Integer>> s = map.entrySet();
		Iterator<Map.Entry<String, Integer>> itr = s.iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Integer> e = itr.next();
			q.add(new Element(e.getKey(),e.getValue()));
		}
		
		/*
		 * Code to avoid creation of class
		 * 
		 * PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );
		 */

		int i=0;
		while(i<k && !q.isEmpty()) {
			l.add(q.poll().sentence);
			i++;
		}
		return l;
	}

}
