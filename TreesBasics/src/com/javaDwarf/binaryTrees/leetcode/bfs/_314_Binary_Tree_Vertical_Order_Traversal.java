package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.javaDwarf.binaryTrees.TreeNode;

public class _314_Binary_Tree_Vertical_Order_Traversal {


	//BFS - keep row and column id at each node
	public List<List<Integer>> verticalOrder(TreeNode root) {

		if(root==null) return new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();
		int id_min = 0;

		Queue<Object[]> q = new LinkedList<>();
		q.add(new Object[]{root,0,0});

		while(!q.isEmpty()){

			int size = q.size();

			for( int i=0; i<size; i++){

				Object[] curr = q.poll();
				TreeNode node = (TreeNode) curr[0];
				Integer row = (Integer) curr[1];
				Integer col = (Integer) curr[2];

				List<Integer> l = map.getOrDefault(col, new ArrayList<>());
				l.add(node.val);
				map.put(col,l);

				if(node.left != null){
					id_min = Math.min(id_min, col-1);
					q.add(new Object[]{node.left, row+1, col-1});
				}
				if(node.right != null){
					q.add(new Object[]{node.right, row+1, col+1});
				}

			}
		}

		List<List<Integer>> res = new ArrayList<>();
		for(int i=id_min; i<=Integer.MAX_VALUE; i++){
			if(!map.containsKey(i)){
				break;
			}
			res.add(map.get(i));
		}
		return res;
	}
//
	//DFS approach would not work, does not take row number in account
	int id_min;
	Map<Integer, List<Integer>> map;

	public List<List<Integer>> verticalOrderDFS(TreeNode root) {
		map = new HashMap<>();
		id_min = 0;
		helper(root, 0);

		List<List<Integer>> res = new ArrayList<>();
		for(int i=id_min; i<=Integer.MAX_VALUE; i++){
			if(!map.containsKey(i)){
				break;
			}
			res.add(map.get(i));
		}
		return res;
	}

	public void helper(TreeNode root, int id){

		if( root == null) return;
		id_min = Math.min(id_min, id);

		helper(root.left, id-1);
		helper(root.right, id+1);
		List<Integer> l = map.getOrDefault(id, new ArrayList<>());
		l.add(root.val);
		map.put(id,l);

	}
	
	//56800235584
	//9223372036854775807

}
