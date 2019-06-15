package com.javaDwarf.binaryTrees.gfg.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VerticalSumBT {

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
			DoubleLinkedList dll = verticalSum(map.get(root), new DoubleLinkedList());
			while(dll.prev.data!=0) {
				dll= dll.prev;
			}
			while(dll.data!=0) {
				System.out.print(dll.data+" ");
				dll= dll.next;
			}
		}
		s.close();
	}

	public static DoubleLinkedList verticalSum(Node root, DoubleLinkedList dll) {
		if(root==null) return null;

		if(dll.data==0) {
			dll.data=root.data;
		}
		else {
			dll.data=dll.data+root.data;	
		}
		if(dll.prev==null) {
			DoubleLinkedList temp = new DoubleLinkedList();
			dll.prev  = temp;
			temp.next = dll;
		}
		if(dll.next==null) {
			DoubleLinkedList temp = new DoubleLinkedList();
			dll.next  = temp;
			temp.prev = dll;
		}
		verticalSum(root.left, dll.prev);
		verticalSum(root.right, dll.next);
		return dll;
	}
}

class DoubleLinkedList {
	int data;
	DoubleLinkedList prev, next;
	public DoubleLinkedList(){
	}
	public DoubleLinkedList(int data) {
		this.data = data;
	}
}
