package com.javaDwarf.binaryTrees.gfg.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrderTraversal {

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
			verticalOrder(map.get(root));
		}
		s.close();
	}

	private static void verticalOrder(Node root) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		dfs(root,0,map);
		map.entrySet().stream().forEach( e -> {
			List<Integer>  l = e.getValue();
			l.stream().forEach( x -> System.out.print(x +" "));
			System.out.print("$");
		});
	}

	private static Map<Integer, List<Integer>> dfs(Node root, int level,  Map<Integer, List<Integer>> map) {
		if(root == null) {
			return map;
		}	
		if(map.containsKey(level)) {
			map.get(level).add(root.data);
		}
		else{
			List<Integer> ll = new ArrayList<>();
			ll.add(root.data);
			map.put(level, ll);
		}
		dfs(root.left,level-1,map);
		dfs(root.right,level+1,map);
		return map;
	}
}
