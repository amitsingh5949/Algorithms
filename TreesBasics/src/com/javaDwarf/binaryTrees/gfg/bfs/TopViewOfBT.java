package com.javaDwarf.binaryTrees.gfg.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TopViewOfBT {

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
			topView(map.get(root));
		}
		s.close();
	}

	private static void topView(Node root) {
		List<Integer> list = new ArrayList<>();
		if(root==null) return;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0));
		while(!q.isEmpty()) {
			Pair current = q.poll();
			if(!list.contains(current.key)) {
				list.add(current.key);
				System.out.println(current.data.data+" ");
			}
			if(current.data.left != null)
				q.add(new Pair(current.data.left,current.key-1));
			if(current.data.right != null)
				q.add(new Pair(current.data.right,current.key+1));
		}
	}
}

class Pair{
	public Node data;
	public int key;
	public Pair(Node data, int key) {
		this.data = data;
		this.key = key;
	}


}
