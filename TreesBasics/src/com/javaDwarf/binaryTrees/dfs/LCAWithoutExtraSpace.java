package com.javaDwarf.binaryTrees.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LCAWithoutExtraSpace {

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
			int n1 = s.nextInt();
			int n2 = s.nextInt();
			System.out.println(dfs(map.get(root), n1, n2));
		}
		s.close();

	}

	public static Node dfs(Node root, int n1,int n2) {
		if(root != null) {
			if(root.data==n1 || root.data==n2) {
				return root;
			}
			Node left = dfs(root.left,n1,n2);
			Node right = dfs(root.right,n1,n2);

			if(left !=null && right==null) {
				root =  left;
			}
			else if(left ==null && right!=null) {
				root =  right;
			}
			else if(left ==null && right==null) {
				root =  null;
			}
		}
		return root;
	}



}
