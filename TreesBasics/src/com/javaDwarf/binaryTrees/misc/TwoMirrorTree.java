package com.javaDwarf.binaryTrees.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.javaDwarf.binaryTrees.dfs.Node;

public class TwoMirrorTree {

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
			mirror(map.get(root));
		}
		s.close();
	}

	public static boolean areMirror(Node a, Node b){
		mirror(a);
		return areMirrorForReal(a, b, true);
	}

	public static void mirror(Node node){
		if(node==null) return ;
		Node temp = node.left;
		node.left= node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);
	}	


	public static boolean areMirrorForReal(Node a, Node b, boolean b1)   {
		
		if(a==null && b ==null) {
			return true;
		}
		else if((a==null && b!=null) ||(a!=null && b==null)) {
			return false;
		}
		
		if(a.data!=b.data) {
			return false;
		}
		boolean left = areMirrorForReal(a.left, b.left, b1);
		boolean right = areMirrorForReal(a.right, b.right, b1);
		return left && right;
	}
}
