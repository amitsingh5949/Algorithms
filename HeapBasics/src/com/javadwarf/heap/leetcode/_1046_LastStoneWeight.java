package com.javadwarf.heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1046_LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lastStoneWeight(int[] stones) {
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i : stones) q.add(i);
		while(q.size() > 1) q.add(q.poll()-q.poll());
		return q.size()==1? q.poll(): 0;
	}

}
