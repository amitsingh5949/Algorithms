package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOftest = s .nextInt();
		Map<Integer, Node1> map = new HashMap<>();

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
				map.computeIfAbsent(n, (x) -> new Node1(x));
				int child = s.nextInt();
				map.computeIfAbsent(child, (x) -> new Node1(x));
				char c = s.next().charAt(0);
				if(c == 'L' || c == 'l') {
					map.get(n).left=map.get(child);
				}
				else if(c == 'R' || c == 'r') {
					map.get(n).right=map.get(child);
				}
			}
			connect(map.get(root),null);
			inorder(map.get(root));

		}
		s.close();
	}
	public static void connect(Node1 root, Node1 parent){

		if(root==null) {
			return;
		}
		if(parent != null) {
			if(parent.right != null && root.data!=parent.right.data) {
				root.nextRight = parent.right;
			}
			else {
				Node1 temp = parent.nextRight;
				while(temp != null) {
					if(temp.left!=null) {
						root.nextRight = temp.left;
						break;
					}
					else if(temp.right!=null) {
						root.nextRight = temp.right;
						break;
					}
					temp=temp.nextRight;
				}
			}
		}
		connect(root.left, root);
		connect(root.right, root);
	}
	
	public static void inorder(Node1 root) {
		if (root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}

class Node1
{
	int data;
	Node1 left, right, nextRight;
	Node1(int item)
	{
		data = item;
		left = right = nextRight = null;

	}
}
