package com.javaDwarf.binaryTrees.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConvertBTtoDLL {

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
			Node head = convertBTtoDLL(map.get(root));
			while(head!=null) {
				System.out.print(head.data+" ");
				head=head.right;
			}
		}
		s.close();
	}
	
	private static Node convertBTtoDLL(Node root) {
		Node head =  dfs(root, null);
		while(head.left!=null) {
			head=head.left;
		}
		return head;
	}

	private static Node dfs(Node root, Node previous) {
		if(root==null) {
			return previous;
		}
		previous = dfs(root.left, previous);
		if(previous!=null) {
			root.left=previous;
			previous.right=root;
		}
		previous=root;
		previous = dfs(root.right, previous);
		return previous;
	}

}
