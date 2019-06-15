package com.javaDwarf.binaryTrees.gfg.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewOfBT {

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
			leftView(map.get(root));
		}
		s.close();

	}

	private static void leftView(Node node) {
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		while(q.size()>1) {
			Node n = q.poll();
			if(n==null) {
				q.add(null);
				continue;
			}
			if(q.peek()==null) {
				System.out.print(n.data+" ");
			}
			if(n.right!=null)
				q.add(n.right);
			if(n.left!=null)
			q.add(n.left);
		}
	}

}
