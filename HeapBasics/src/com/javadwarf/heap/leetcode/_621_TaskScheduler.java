package com.javadwarf.heap.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _621_TaskScheduler {

	public static void main(String[] args) {
		char[] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		//char[] arr = {'A','B','A'};
		//char[] arr = {'A','A','A','B','B','B'};

		System.out.println(new _621_TaskScheduler().leastInterval(arr, 2));

	}

	public int leastInterval(char[] tasks, int n) {

		int[] charCount = new int[26];

		for(char ch : tasks) {
			charCount[ch -'A'] += 1;
		}

		Queue<Pos> pq = new PriorityQueue<>();
		for(int i=0; i<charCount.length; i++) {
			if(charCount[i] > 0) {
				pq.add(new Pos(charCount[i], (char)(i+'A')));
			}
		}

		Queue<Pos> q = new LinkedList<>();
		StringBuffer res = new StringBuffer();

		while(!pq.isEmpty()){

			int n1 = n;

			while(n1 >= 0) {
				if(!pq.isEmpty()) {
					q.add(pq.poll());
				}
				else {
					q.add(null);
				}
				n1--;
			}

			while(!q.isEmpty()) {
				Pos pos = q.poll();
				if(pos != null) {
					if(pos.count > 1) {
						pos.count -= 1;
						pq.add(pos);
					}
					res.append(pos.ch);

				}
				else {
					res.append("*");
				}
			}
		}
		
		while(res.charAt(res.length()-1) == '*') {
			res.deleteCharAt(res.length()-1);
		}

		return res.length();
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
			return Integer.compare(o.count, this.count);
		}
		@Override
		public String toString() {
			return count + "=" + ch;
		}

	}

}
