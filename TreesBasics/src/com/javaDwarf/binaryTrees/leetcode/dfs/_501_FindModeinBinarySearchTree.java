package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


public class _501_FindModeinBinarySearchTree {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);

		t1.right =t2;
		t2.left = t3;

		new _501_FindModeinBinarySearchTree().findMode(t1);

	}

	List<Integer> list = null;
	int max = 0;
	TreeNode prev = null;
	int count = 0; 
	
	public int[] findMode(TreeNode root) {

		if(root == null) return new int[0];
		list = new ArrayList<>();

		dfs(root);

		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public void dfs(TreeNode curr) {

		if(curr == null ) return ;

		dfs(curr.left);
		
		if(prev == null) {
			max = 1;
			count = 1;
		}
		else {
			if(prev.val == curr.val ) {
				count++;
			}
			else {
				count = 1;
			}
		}
		
		prev = curr;
		
		if(max < count) {
			list.clear();
			max = count;
			list.add(curr.val);
		}
		else if(max == count) {
			list.add(curr.val);
		}
		
		dfs(curr.right);
	}


	// Method 1  -- using extra space
	Map<Integer, Integer> map = null;

	public int[] findMode1(TreeNode root) {

		if(root == null) return new int[0];
		map = new HashMap<>();

		List<Integer> list = new ArrayList<>();

		dfs1(root);

		int max = Integer.MIN_VALUE;
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr = set.iterator();

		while(itr.hasNext()) {
			Map.Entry<Integer, Integer> e = itr.next();
			if(e.getValue() > max) {
				max = e.getValue();
				list.clear();
				list.add(e.getKey());
			}
			else if(e.getValue() == max) {
				list.add(e.getKey());
			}
		}

		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public void dfs1(TreeNode curr) {
		if(curr == null) return;

		int count = map.getOrDefault(curr.val, 0);
		map.put(curr.val, count+1);

		dfs1(curr.left);
		dfs1(curr.right);
	}

}
