package com.javadwarf.disjointset.leetcode;

public class _547_FriendCircles {

	public static void main(String[] args) {

		int[][] nums = {{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
		
		System.out.println(new _547_FriendCircles().findCircleNum(nums));
	}

	public static DisjointSet ds = null;
	public int findCircleNum(int[][] M) {
		
		if(M==null || M.length==0) return 0;
		
		ds = new DisjointSet();
		for(int i=0; i<M.length; i++) {
			ds.makeSet(i);
		}
		
		for(int i=0; i<M.length; i++) {
			for(int j=0; j<M[i].length; j++) {
				if(M[i][j] ==1) {
					ds.union(i, j);
				}
			}
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
