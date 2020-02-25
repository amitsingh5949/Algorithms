package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


public class _987_VerticalOrderTraversalofaBinaryTree {

	public static void main(String[] args) {

	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {


		List<List<Integer>> ll = new ArrayList<List<Integer>>();

		if(root == null) return ll;

		List<Location> map = new ArrayList<>();
		dfs(root,0,0, map);

		Collections.sort(map);

		int prevX = map.get(0).x;
		List<Integer> temp = new ArrayList<Integer>();
		
		for(int i=0; i<map.size(); i++) {
			Location loc = map.get(i);

			if(loc.x == prevX) {
				temp.add(loc.val);
			}
			else {
				ll.add(temp);
				temp.clear();
				prevX = loc.x;
				temp.add(loc.val);
			}
		}
		ll.add(temp);
		return ll;
	}

	private static void dfs(TreeNode root, int x, int y, List<Location> map) {
		if(root == null) {
			return ;
		}	
		map.add(new Location(x,y,root.val));
		dfs(root.left,x-1,y-1,map);
		dfs(root.right,x+1,y-1,map);
	}
}

class Location implements Comparable<Location>{

	int x, y, val;

	public Location(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Location l) {

		int a = Integer.compare(this.x, l.x);
		if(a == 0) {
			int b = Integer.compare(this.y, l.y);
			if(b ==0) {
				return Integer.compare(this.val, l.val);
			}
			return b;
		}
		return a;
	}

	@Override
	public String toString() {
		return "val=" + val;
	}
	
}
