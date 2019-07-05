package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _637_AverageofLevelsinBinaryTree {

	public static void main(String[] args) {

	}

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> l = new ArrayList<>();

		if(root == null)  return l;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		double levelSum =0.0 ;
		int levelNumNode = 0;
		while(q.size() > 1) {

			TreeNode node = q.poll();

			if(node == null) {
				l.add(levelSum/levelNumNode);
				levelSum = 0 ;
				levelNumNode = 0;
				q.add(null);
				continue;
			}

			levelSum += node.val;
			levelNumNode++;
			
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}

		}
		l.add(levelSum/levelNumNode);
		return l;
	}

}
