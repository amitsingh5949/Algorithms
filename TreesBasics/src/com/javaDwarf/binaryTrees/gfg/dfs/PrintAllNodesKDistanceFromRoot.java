package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintAllNodesKDistanceFromRoot {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOftest = s .nextInt();
		Map<Integer, Node> map = new HashMap<>();

		for(int i =0 ; i <numOftest; i++) {
			int root = -1;
			int n = -1;
			int edges = s.nextInt();
			int dist = s.nextInt();
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
			System.out.println();
			printnode(map.get(root), dist);
		}
		s.close();


	}

	public static void printnode(Node root, int k){

		if(root==null || k<0) {
			return;
		}
		if(k==0) {
			System.out.print( root.data+ " ");
		}
		printnode(root.left, k-1);
		printnode(root.right, k-1);
	}


}
