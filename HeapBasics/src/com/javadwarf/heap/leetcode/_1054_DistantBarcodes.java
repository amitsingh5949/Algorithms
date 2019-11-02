package com.javadwarf.heap.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _1054_DistantBarcodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] rearrangeBarcodes(int[] barcodes) {

		if(barcodes == null || barcodes.length <2) return barcodes;

		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<barcodes.length; i++) {
			int count = map.getOrDefault(barcodes[i], 0);
			map.put(barcodes[i], count+1);

		}
		Queue<Pos> q = new PriorityQueue<Pos>();

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr  = set.iterator();

		while(itr.hasNext()) {
			Map.Entry<Integer, Integer> e = itr.next();
			q.add(new Pos(e.getValue(), e.getKey()));
		}

		int[] res = new int[barcodes.length];
		int index = 0;
		while(!q.isEmpty()) {
			Pos pos1 = q.poll();
			Pos pos2 = null;

			if(!q.isEmpty()) {
				pos2 = q.poll();
			}

			if(pos1.count >= 2) {
				res[index++] = pos1.ch;
				pos1.count -= 1;
				q.add(pos1);
			}
			else {
				res[index++] = pos1.ch;
			}

			if(pos2 != null) {
				if(pos2.count >= 2) {
					res[index++] = pos2.ch;
					pos2.count -= 1;
					q.add(pos2);
				}
				else {
					res[index++] = pos2.ch;
				}
			}
		}

		return res;
	}

	class Pos implements Comparable<Pos>{

		int count = 0;
		Integer ch = 0;

		public Pos(int count, Integer ch) {
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

