package com.javadwarf.disjointset.leetcode;

import java.util.Arrays;

public class _1135_ConnectingCitiesWithMinimumCost {

	public static void main(String[] args) {

		int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
		System.out.println(new _1135_ConnectingCitiesWithMinimumCost().minimumCost(3, connections));
	}

	public int minimumCost(int N, int[][] connections) {

		int result = 0;

		DisjointSet ds = new DisjointSet();

		for(int i=1;i<=N; i++) {
			ds.makeSet(i);
		}

		Arrays.parallelSort(connections, (a,b) -> Integer.compare(a[2], b[2]));

		for(int[] edge : connections) {
			if(ds.union(edge[0],edge[1])) {
				result += edge[2];
			}
		}

		for(int i=1;i<=N; i++) {
			ds.find(i);
		}

		int max = 0;
		for(DisjointSet.Node node : ds.map.values()) {
			if(node.data == node.parent.data) {
				max++;
			}
		}

		if(max > 1) {
			return -1;
		}

		return result;
	}

}
