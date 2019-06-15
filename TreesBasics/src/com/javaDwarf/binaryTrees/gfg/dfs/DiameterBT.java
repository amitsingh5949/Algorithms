package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiameterBT {
	
	public static int max = 0;

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
			System.out.println(diameter(map.get(root)));
		}
		s.close();
	}
	
	public static int diameter(Node node ) {
		max = 0;
		diameterForReal(node);
		return max-1;
	}
	
	public static int diameterForReal(Node node){
		if(node==null) return 0;
		int left = diameterForReal(node.left);
		int right = diameterForReal(node.right);
		 left = left + 1 ;
		 right = right + 1 ;
		 if(max < left+right) {
			 max = left+right;
		 }
		 return Integer.max(left, right);
    }

}
