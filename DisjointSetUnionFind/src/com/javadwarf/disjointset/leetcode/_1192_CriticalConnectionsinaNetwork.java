package com.javadwarf.disjointset.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1192_CriticalConnectionsinaNetwork {

	public static void main(String[] args) {

	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for(int i=0 ;i<connections.size();i++) {
			if(countComponents(n, connections, i) > 1) {
				res.add(connections.get(i));
			}
		}
		
		return res;
	}

	public int countComponents(int n, List<List<Integer>> connections, int curr) {
		DisjointSet ds = new DisjointSet();
		for(int i=0; i<n; i++) {
			ds.makeSet(i);
		}
		for(int i=0; i<connections.size(); i++) {
			if(i != curr) {
				ds.union(connections.get(i).get(0), connections.get(i).get(0));
			}
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
