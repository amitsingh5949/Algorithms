package com.javaDwarf.binaryTrees.gfg.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseOrderTraversalBT {


	public static void main(String[] args) {

		Node root = null;
		reverseOrderTraversal1(root);
		System.out.println();
		reverseOrderTraversal2(root);
	}



	//**************************************************************************************//
	private static void reverseOrderTraversal1(Node root) {
		int height = heightOfTree(root);
		for(int i = height; i>=1; i--){
             printNodesAtLevel1(root, i);
		}
	}
	
	public static int heightOfTree(Node root) {
		if(root == null){
			return 0;
		}
		return 1 + Math.max(heightOfTree(root.left),
				heightOfTree(root.right));
	}
	
	private static void printNodesAtLevel1(Node n, int level){
		if(n==null){
			return;
		}
		if(level ==1){
			System.out.print(n.data + " ");
		}
		printNodesAtLevel1(n.left, level-1);
		printNodesAtLevel1(n.right, level-1);
	}
//*****************************************************************************************//
	private static void reverseOrderTraversal2(Node root) {
		
		Stack<Node> s = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		Node current = null;
		while(!q.isEmpty()){
			current = q.poll();
			if(current.right!=null)
				q.add(current.right);
			if(current.left != null)
				q.add(current.left);
			s.add(current);
		}
		while(!s.isEmpty()){
			System.out.print(s.pop().data + " ");
		}
		
		s.stream().forEach(e -> System.out.println(e.data + " "));
	}


}
