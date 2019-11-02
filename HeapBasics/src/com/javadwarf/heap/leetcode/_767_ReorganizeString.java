package com.javadwarf.heap.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _767_ReorganizeString {

	public static void main(String[] args) {

	}

	public String reorganizeString(String S) {

		if(S == null || S.length() <2) return S;

		int max = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int i=0; i<S.length(); i++) {
			int count = map.getOrDefault(S.charAt(i), 0);
			map.put(S.charAt(i), count+1);

			if(max<count+1) {
				max = count+1;
			}
		}

		if(max > (S.length()+1)/2) {
			return "";
		}

		Queue<Pos> q = new PriorityQueue<Pos>();

		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Character, Integer>> itr  = set.iterator();

		while(itr.hasNext()) {
			Map.Entry<Character, Integer> e = itr.next();
			q.add(new Pos(e.getValue(), e.getKey()));
		}

		String res = "";
		while(!q.isEmpty()) {
			Pos pos1 = q.poll();
			Pos pos2 = null;

			if(!q.isEmpty()) {
				pos2 = q.poll();
			}

			if(pos1.count >= 2) {
				res += pos1.ch;
				pos1.count -= 1;
				q.add(pos1);
			}
			else {
				res += pos1.ch;
			}

			if(pos2 != null) {
				if(pos2.count >= 2) {
					res += pos2.ch;
					pos2.count -= 1;
					q.add(pos2);
				}
				else {
					res += pos2.ch;
				}
			}
		}

		return res;
	}

	class Pos implements Comparable<Pos>{

		int count = 0;
		char ch = '\0';

		public Pos(int count, char ch) {
			super();
			this.count = count;
			this.ch = ch;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(o.count, this.count);
		}
	}

}
