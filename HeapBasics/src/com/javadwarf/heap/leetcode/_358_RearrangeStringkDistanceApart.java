package com.javadwarf.heap.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class _358_RearrangeStringkDistanceApart {

	public static void main(String[] args) {
		//System.out.println(new _358_RearrangeStringkDistanceApart().rearrangeString( "a",0));
		//System.out.println(new _358_RearrangeStringkDistanceApart().rearrangeString( "abb",3));
		System.out.println(new _358_RearrangeStringkDistanceApart().rearrangeString( "abb",2));

	}

	public String rearrangeString(String s, int k) {
		if(k == 0 || s ==null || s.length() <= 1) return s;

		String res = "";

		int[] map = new int[26];

		for(int i=0; i<s.length(); i++) {
			map[s.charAt(i) - 'a'] += 1;
		}

		Queue<Pos> pq = new PriorityQueue<>();
		for(int i=0; i<map.length; i++) {
			if(map[i] > 0) {
				pq.add(new Pos(map[i], (char)(i+'a')));
			}
		}

		Queue<Pos> q = new LinkedList<>();

		while(!pq.isEmpty()) {

			int n = k;

			while(n > 0) {
				Pos p = pq.poll();
				if((pq.isEmpty() && q.isEmpty() && p.count > 1 && k > 1)) {
					return "";
				}
				else {
					q.add(p);
				}
				n--;
			}

			while(!q.isEmpty()) {
				Pos p = q.poll();
				if(p.count > 1) {
					p.count -= 1;
					pq.add(p);
				}
				res += p.ch;
			}
		}

		return res;
	}

	class Pos implements Comparable<Pos>{
		int count;
		char ch;
		public Pos(int count, char ch) {
			super();
			this.count = count;
			this.ch = ch;
		}
		@Override
		public int compareTo(Pos o) {
			int x  =  Integer.compare(o.count, this.count);
			if(x == 0) {
				return Character.compare(this.ch,o.ch);
			}

			return x;
		}
		@Override
		public String toString() {
			return count + "=" + ch;
		}

	}

}
