package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintKSumPath {

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
			int dist = s.nextInt();
			System.out.println(printCount(map.get(root), dist));
		}
		s.close();
	}

	public static int printCount(Node root,int k){
		return printCountImpl(root, k, 0);
	}

	public static int printCountImpl(Node root,int k, int count){
		if(root==null) {
			return count;
		}
		count = count + printNode(root, k,0);
		count = count + printCountImpl(root.left, k,0);
		count = count + printCountImpl(root.right, k,0);
		return count;
	}

	public static int printNode(Node root, int k, int count){

		if(root==null ) {
			return count;
		}
		k = k - root.data;
		if(k == 0){
			count = count + 1;
		}
		count = printNode(root.left, k,count);
		count = printNode(root.right, k,count);
		k = k + root.data;
		return count;
	}

}
