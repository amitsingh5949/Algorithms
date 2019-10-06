package com.javadwarf.disjointset.leetcode;

public class _261_GraphValidTree {

	public static void main(String[] args) {
		int[][] edges = {{5,6},{0,2},{1,7},{1,8},{5,9},{3,4},{0,6},{0,7},{0,3},{8,9}};
		//int[][] edges = {{0,2},{2,1}};
		System.out.println(new _261_GraphValidTree().validTree(10, edges));

	}
	
	public boolean validTree(int n, int[][] edges) {
		DisjointSet ds = new DisjointSet();
		for(int i=0; i<n; i++) {
			ds.makeSet(i);
		}
		for(int i=0; i<edges.length; i++) {
			boolean val = ds.union(edges[i][0], edges[i][1]);
			if(!val) return val;
		}
		for(int i=0; i<n; i++) {
			ds.find(i);
		}
		
		int parent = Integer.MAX_VALUE;
		for(DisjointSet.Node node :ds.map.values()) {
			if(parent == Integer.MAX_VALUE) {
				parent = node.parent.data;
				continue;
			}
			if(node.parent.data != parent) {
				return false;
			}
		}
		return true;
	}
	
}
