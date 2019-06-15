package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BoundaryOfBT {

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
				if(c=='L'||c=='l') {
					map.get(n).left=map.get(child);
				}
				else if(c=='R'||c=='r') {
					map.get(n).right=map.get(child);
				}
			}
			boundary(map.get(root));
		}
		s.close();
	}

	private static void boundary(Node node) {
		System.out.print(node.data+" ");
		printLeft(node.left);
		printLeafs(node);
		printRight(node.right);
	}

	private static void printLeft(Node node) {
		if(node==null) return;
		if(node.left!=null || node.right!=null) {
			System.out.print(node.data+" ");
		}
		if(node.left!=null) {
			printLeft(node.left);
		}
		else if(node.right!=null){
			printLeft(node.right);
		}
	}


	private static void printLeafs(Node node) {
		if(node==null) return;
		if(node.left==null && node.right==null) {
			System.out.print(node.data+" ");
		}
		printLeafs(node.left);
		printLeafs(node.right);
	}


	private static void printRight(Node node) {
		if(node==null) return;
		if(node.right!=null) {
			printRight(node.right);
		}
		else if(node.left!=null){
			printRight(node.left);
		}
		if(node.left!=null || node.right!=null) {
			System.out.print(node.data+" ");
		}
	}

}
