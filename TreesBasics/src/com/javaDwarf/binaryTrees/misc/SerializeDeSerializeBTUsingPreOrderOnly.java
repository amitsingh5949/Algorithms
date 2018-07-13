package com.javaDwarf.binaryTrees.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SerializeDeSerializeBTUsingPreOrderOnly {

	public static int current = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOftest = s .nextInt();
		Map<Integer, Tree2> map = new HashMap<>();

		for(int i =0 ; i <numOftest; i++) {
			int root = -1;
			int n = -1;
			int edges = s.nextInt();
			for(int k =0 ;k<edges; k++) {
				if(k==0) {
					n = s.nextInt();
					root = n;
				}
				else {
					n = s.nextInt();	
				}
				map.computeIfAbsent(n, (x) -> new Tree2(x));
				int child = s.nextInt();
				map.computeIfAbsent(child, (x) -> new Tree2(x));
				char c = s.next().charAt(0);
				if(c == 'L' || c == 'l') {
					map.get(n).left=map.get(child);
				}
				else if(c == 'R' || c == 'r') {
					map.get(n).right=map.get(child);
				}
			}
			String str = serialize(map.get(root));
			str= str.substring(0,str.length()-1);
			Tree2 rootFinal = deSerialize(str);
			inorder(rootFinal);
		}
		s.close();
	}

	public static void inorder(Tree2 root) {
		if(root==null) return ;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static String serialize(Tree2 root) {
		current = 0;
		return preorder(root, "");
	}

	public static String preorder(Tree2 root, String str) {
		if(root==null) { 
			str += "#,";
			return str;
		}
		str += root.data+",";
		str = preorder(root.left, str);
		str = preorder(root.right, str);
		return str;
	}

	public static  Tree2 deSerialize(String data) {
		String[] arr = data.split(",");
		Tree2  root = null; 
		if(arr.length > 0) {
			root = buildTree(arr);
		}
		return root;
	}

	private static Tree2 buildTree(String[] arr) {
		if(arr[current].equals("#")) {
			return null;
		}
		Tree2  node = new Tree2(Integer.parseInt(arr[current]));
		current = current + 1 ;
		node.left = buildTree(arr);
		current = current + 1 ;
		node.right = buildTree(arr);
		return node;
	}
}

class Tree2{
	int data;
	Tree2 left,right;
	Tree2(int d){
		data=d;
		left=right=null;
	}
}



