package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _623_AddOneRowtoTree {

	public TreeNode addOneRow(TreeNode root, int v, int d) {

		if(root == null) return null ;

		if( d==  1) {
			TreeNode curr = new TreeNode(v);
			curr.left = root;
			return curr;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int depth = 1;

		while(q.size() > 1 && (depth <= d)) {
			TreeNode node = q.poll();

			if(depth == d-1 && node != null) {
				
				TreeNode leftV = new TreeNode(v);
				leftV.left = node.left;
				node.left = leftV;
				
				TreeNode rightV = new TreeNode(v);
				rightV.right = node.right;
				node.right = rightV;
				
				continue;
			}

			if(node == null) {
				depth += 1;
				q.add(null);
				continue;
			}

			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return root;
	}
}
