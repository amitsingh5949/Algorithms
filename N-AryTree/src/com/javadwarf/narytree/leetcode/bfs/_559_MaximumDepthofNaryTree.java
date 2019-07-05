package com.javadwarf.narytree.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import  com.javadwarf.narytree.leetcode.Node;

public class _559_MaximumDepthofNaryTree {

	public int maxDepth(Node root) {

		if(root == null) return 0;

		int max = 1;

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(q.size() >1) {
			Node curr = q.poll();

			if(curr == null) {
				max++;
				q.add(null);
				continue;
			}

			for(Node child  : curr.children) {
				if(child != null) {
					q.add(child);
				}
			}
		}

		return max;
	}

}
