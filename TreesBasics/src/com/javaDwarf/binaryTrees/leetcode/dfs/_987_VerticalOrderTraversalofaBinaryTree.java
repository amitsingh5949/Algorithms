package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


public class _987_VerticalOrderTraversalofaBinaryTree {

	public static void main(String[] args) {

	}
	
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		 List<List<Integer>> ll = new ArrayList<List<Integer>>();
		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		dfs(root,0,map);
		map.entrySet().stream().forEach( e -> ll.add(e.getValue()));
		
		return ll;
	}

	private static Map<Integer, List<Integer>> dfs(TreeNode root, int level,  Map<Integer, List<Integer>> map) {
		if(root == null) {
			return map;
		}	
		if(map.containsKey(level)) {
			map.get(level).add(root.val);
		}
		else{
			List<Integer> ll = new ArrayList<>();
			ll.add(root.val);
			map.put(level, ll);
		}
		dfs(root.left,level-1,map);
		dfs(root.right,level+1,map);
		return map;
	}

}
