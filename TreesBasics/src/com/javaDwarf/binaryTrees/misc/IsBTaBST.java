package com.javaDwarf.binaryTrees.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.javaDwarf.binaryTrees.dfs.Node;

public class IsBTaBST {

	public static int current = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOftest = s .nextInt();
		Map<Integer, Node> map = new HashMap<>();

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
				map.computeIfAbsent(n, (x) -> new Node(x));
				int child = s.nextInt();
				map.computeIfAbsent(child, (x) -> new Node(x));
				char c = s.next().charAt(0);
				if(c == 'L' || c == 'l') {
					map.get(n).left=map.get(child);
				}
				else if(c == 'R' || c == 'r') {
					map.get(n).right=map.get(child);
				}
			}
			System.out.println(isBST(map.get(root)));
		}
		s.close();

	}

	public static int isBST(Node root) {
		return isBST(root,true)?1:0;
	}

	public static boolean isBST(Node root, boolean k) {
		if (root==null) return k;

		boolean left = isBST(root.left,k); 
		if(root.data >= current) {
			current = root.data;
		}
		else {
			k = false;
		}
		boolean right = isBST(root.right, k);
		return left && right;
	}

}
