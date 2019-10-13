package com.javadwarf.disjointset.leetcode;

public class _323_NumberofConnectedComponentsinUndirectedGraph {

	public static void main(String[] args) {

	}

	public int countComponents(int n, int[][] edges) {

		DisjointSet ds = new DisjointSet();
		for(int i=0; i<n; i++) {
			ds.makeSet(i);
		}
		for(int i=0; i<edges.length; i++) {
			ds.union(edges[i][0], edges[i][1]);
		}
		for(int i=0; i<n; i++) {
			ds.find(i);
		}
		int max = 0;
		for(DisjointSet.Node node : ds.map.values()) {
			if(node.data == node.parent.data) {
				max++;
			}
		}
		return max;
	}
}
