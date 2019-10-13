package com.javadwarf.heap.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _1167_MinimumCosttoConnectSticks {

	public static void main(String[] args) {
		int[] a = {2,4,3};
		System.out.println(new _1167_MinimumCosttoConnectSticks().connectSticks(a));
	}

	public int connectSticks(int[] sticks) {
		int res =0;
		Queue<Integer> q = new PriorityQueue<>();
		for(int i : sticks) {
			q.add(i);
		}
		while(q.size() > 1) {
			int x = q.poll()+q.poll();
			res += x;
			q.add(x);
		}
		return res;
	}

}
