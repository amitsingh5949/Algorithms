package com.javaDwarf.binaryTrees.gfg.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SerializeDeSerializeBT {

	public static int current = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOftest = s .nextInt();
		Map<Integer, Tree> map = new HashMap<>();

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
				map.computeIfAbsent(n, (x) -> new Tree(x));
				int child = s.nextInt();
				map.computeIfAbsent(child, (x) -> new Tree(x));
				char c = s.next().charAt(0);
				if(c == 'L' || c == 'l') {
					map.get(n).left=map.get(child);
				}
				else if(c == 'R' || c == 'r') {
					map.get(n).right=map.get(child);
				}
			}
			String str = serialize(map.get(root));
			Tree rootFinal = deSerialize(str);
			System.out.println(inorder(rootFinal,""));

		}
		s.close();
	}

	public static String serialize(Tree root) {
		current = 0;
		String str = inorder(root, "");
		str += "-";
		return preorder(root, str);
	}

	public static String inorder(Tree root, String str) {
		if(root==null) return str;
		str = inorder(root.left, str);
		str += root.data+",";
		str = inorder(root.right, str);
		return str;
	}

	public static String preorder(Tree root, String str) {
		if(root==null) return str;
		str += root.data+",";
		str = preorder(root.left, str);
		str = preorder(root.right, str);
		return str;
	}

	public static  Tree deSerialize(String data) {
		String[] arr = data.split("-");
		String[] inArr = arr[0].substring(0, arr[0].length()-1).split(",");
		String[] preArr = arr[1].substring(0, arr[0].length()-1).split(",");
		int[] inorder = new int [inArr.length];
		int[] preorder = new int [preArr.length];

		for(int i=0; i<inorder.length; i++) {
			inorder[i] = Integer.parseInt(inArr[i]);
			preorder[i] = Integer.parseInt(preArr[i]);
		}

		return buildTree(inorder, preorder);
	}

	private static Tree buildTree(int[] inorder, int[] preorder) {
		return construct(inorder, preorder, 0, inorder.length-1);
	}

	private static Tree construct(int[] inorder, int[] preorder, int start, int end) {
		if(start>end) {
			return null;
		}
		Tree node = new Tree(preorder[current++]);
		int mid = -1;
		for(int i=start; i<=end; i++) {
			if(inorder[i]==node.data) {
				mid = i;
				break;
			}
		}
		node.left = construct(inorder, preorder, start, mid-1);
		node.right = construct(inorder, preorder, mid+1, end);
		return node;
	}
}

class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}


