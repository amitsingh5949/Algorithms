package com.javaDwarf.binaryTrees.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InorderSuccessor {

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
			Node previous = inorderSuccessor(map.get(root), null);
			System.out.println(previous.data +"->"+-1);
		}
		s.close();
	}

	public static Node inorderSuccessor(Node root, Node previous) {
		if(root==null) {
			return previous;
		}
		previous = inorderSuccessor(root.left, previous);
		if(previous!=null) {
			System.out.print(previous.data+"->"+root.data+" ");
		}
		previous=root;
		previous = inorderSuccessor(root.right, previous);
		return previous;


	}

	/*public static void dfs(Node root) {
		if(root == null) {
			return;
		}

		dfs(root.left);
		dfs(root.right);

		inorderSuccessor(root, root.left, true);
		inorderSuccessor(root, root.right, false);

	}

	public static void inorderSuccessor(Node parent, Node parentSuccessor, boolean isLeftChild) {

		if(parent == null) {
			return;
		}
		Node successsor = null;
		if(parentSuccessor != null ) {
			if(parentSuccessor.right != null) {
				if(parentSuccessor.right.left==null) {
					successsor=parentSuccessor.right;
				}
				else {
					Node temp = parentSuccessor.right.left;
					while(temp != null) {
						successsor = temp;
						temp = temp.left;
					}
				}
			}
			else {
				if(isLeftChild)
				successsor=parent;
			}
			System.out.println(parentSuccessor.data + "->" + ((successsor != null) ? successsor.data : "") + 	" ");
		}

	}

	public static Node inorderSuccessorOfN(Node root, int n) {

		if(root != null ) {
			Node parent = root;
			Node parentSuccessor = null;
			if(parent.left != null && parent.left.data==n) {
				parentSuccessor = root.left;
			}
			else if(parent.right != null && parent.right.data==n) {
				parentSuccessor = root.right;

			}
			if(parentSuccessor != null) {
				Node successsor = null;
				if(parentSuccessor.right != null) {
					if(parentSuccessor.right.left==null) {
						successsor=parentSuccessor.right;
					}
					else {
						Node temp = parentSuccessor.right.left;
						while(temp != null) {
							successsor = temp;
							temp = temp.left;
						}
					}
				}
				else {
					successsor=parent;
				}
				return successsor;
			}

			Node left = inorderSuccessorOfN(root.left,n);
			Node right = inorderSuccessorOfN(root.right,n);

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
	}*/



}
