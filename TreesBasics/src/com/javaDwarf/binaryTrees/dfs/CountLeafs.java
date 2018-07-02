package com.javaDwarf.binaryTrees.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class CountLeafs {

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
			System.out.println(countLeaves(map.get(root)));
		}
		s.close();
	}

	public static int countLeaves(Node root) 
	{
		int count =0;
		count = dfs(root,0);
		return count;
	}

	public static int dfs (Node root, int count) {
		if(root==null) {
			return count;
		}

		if(root.left == null && root.right == null) {
			return ++count;
		}
		count = dfs(root.left,count);
		count = dfs(root.right,count);
		return count;

	}

}


