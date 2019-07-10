package com.javadwarf.narytree.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javadwarf.narytree.leetcode.Node;

public class _429_NaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> l = new ArrayList<>();
		if(root==null) return l;

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		List<Integer> ll = new ArrayList<>();

		while(q.size() > 1) {

			Node curr = q.poll();
			if(curr == null) {
				l.add(ll);
				ll = new ArrayList<>();
				q.add(null);
				continue;
			}
			ll.add(curr.val);
			for(Node child : curr.children) {
				if(child != null) {
					q.add(child);
				}
			}

		}
		if(ll.size()>0)
			l.add(ll);
		return l;
	}

}
