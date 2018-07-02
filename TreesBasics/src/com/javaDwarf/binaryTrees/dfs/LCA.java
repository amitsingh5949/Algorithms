package com.javaDwarf.binaryTrees.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class LCA {

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
			int n1 = s.nextInt();
			int n2 = s.nextInt();	
			System.out.println(LCA(map.get(root), n1, n2));
		}
		s.close();

	}

	public static Node LCA(Node root, int n1,int n2)
	{
		Node lca = root;
		Stack<Node>  s1 = new Stack<>();
		Stack<Node>  s2 = new Stack<>();
		dfs(root, n1, false, s1);
		dfs(root, n2, false, s2);

		if(!s1.isEmpty() && !s2.isEmpty()) {
			lca = s1.peek();
			while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
				lca = s1.peek();
				s1.pop();
				s2.pop();
			}
		}
		return lca;
	}

	public static boolean dfs(Node root, int n1, boolean found, Stack<Node> s){
		if(root == null) {
			return false;
		}
		if(root!=null && root.data==n1) {
			return true;
		}
		found = dfs(root.left,n1,found,s) || dfs(root.right,n1,found,s);
		if(found) {
			if(root.left.data==n1 ) {
				s.add(root.left);
			}
			else if(root.right.data==n1 ) {
				s.add(root.right);
			}
			s.add(root);
		}
		return found;
	}

}
