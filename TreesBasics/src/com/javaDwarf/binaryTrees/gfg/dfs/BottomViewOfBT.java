package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BottomViewOfBT {

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
			bottomView(map.get(root));
		}
		s.close();
	}

	private static void bottomView(Node node) {
		Map<Integer,Integer> map = new TreeMap<>();
		bottomViewForReal(node,0, map);
		map.entrySet().stream().forEach(e -> System.out.print(e.getValue()+" "));
	}

	private static void bottomViewForReal(Node node, int k, Map<Integer, Integer> map) {
		if(node==null) return;
		map.put(k, node.data);
		bottomViewForReal(node.left, k-1, map);
		bottomViewForReal(node.right, k+1, map);
	}

}
