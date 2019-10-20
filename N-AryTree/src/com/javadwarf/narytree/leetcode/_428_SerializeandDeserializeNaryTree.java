package com.javadwarf.narytree.leetcode;

import java.util.List;

public class _428_SerializeandDeserializeNaryTree {

	public static void main(String[] args) {

	}

	public String serialize(Node root) {
		return preorder(root, "");
	}
	
	public String preorder(Node root, String res) {
		if(root == null) return res + "null,";
		res += root.val+",";
		List<Node> children = root.children;
		for(Node child : children) {
			res = preorder(child, res);
		}
		return res;
	}

	public static int current = 0;
	public Node deserialize(String data) {
		String[] arr = data.split(",");
		return deserialize(arr);
	}
	
	public Node deserialize(String[] arr) {
		
		if(arr[current] == null) {
			current++;
			return null;
		}
		
		Integer i = Integer.parseInt(arr[current]);
		current++;
		
		Node root = new Node();
		root.val = i;
		
		
		//TODO : add children but how? Need to use Level order traversal i guess
		
		return root;
		
		
		

	}

}
