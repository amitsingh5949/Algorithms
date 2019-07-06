package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.javaDwarf.binaryTrees.TreeNode;

public class _508_MostFrequentSubtreeSum {

	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(5);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(-5);

		l1.left = l2;
		l1.right = l3;

		new _508_MostFrequentSubtreeSum().findFrequentTreeSum(l1);

	}

	Map<Integer, Integer> map= new HashMap<>();

	public int[] findFrequentTreeSum(TreeNode root) {

		if(root == null) return new int[0];

		map= new HashMap<>();

		dfsSubTreeSum(root);

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();

		List<Map.Entry<Integer, Integer>> l =  new ArrayList<Map.Entry<Integer, Integer>>(set);

		Collections.sort(l, (a,b) -> Integer.compare( b.getValue(), a.getValue()));

		List<Integer> resultList = new ArrayList<>();
		resultList.add(l.get(0).getKey());
		int mostFreq = l.get(0).getValue();

		for(int i=1; i<l.size(); i++ ) {
			if(l.get(i).getValue() != mostFreq)
				break;
			resultList.add(l.get(i).getKey());
		}

		int[] resultArr = new int[resultList.size()];

		for(int i =0 ; i<resultArr.length; i++) {
			resultArr[i] = resultList.get(i);
		}
		return resultArr;
	}

	public int dfsSubTreeSum(TreeNode root) {
		if(root == null) return 0;
		int sum =  dfsSubTreeSum(root.left) + dfsSubTreeSum(root.right) + root.val;
		int val = map.getOrDefault(sum, 0);
		map.put(sum, val+1);
		return sum;
	}
}
