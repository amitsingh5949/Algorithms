package com.javaDwarf.binaryTrees.gfg.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;


public class ZigZagTraversalBT {

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
				if(c=='L'|| c=='l') {
					map.get(n).left=map.get(child);
				}
				else if(c=='R' || c=='r') {
					map.get(n).right=map.get(child);
				}
			}
			//zigZagOrderTraversal1(map.get(root));
			//zigZagOrderTraversal2(map.get(root));
			zigZagOrderTraversal3(map.get(root));
		}
		s.close();

	}

	/******technique 1 using 1 stack and 1 queue*/
	public static void zigZagOrderTraversal1(Node root) {
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		boolean startleftt = true;

		Node current = null;
		q.add(root);
		q.add(null);
		while (!q.isEmpty() ){
			current = q.poll();
			if(current == null){
				while(!q.isEmpty()){
					s.add(q.poll());
				}
				while(!s.isEmpty()){
					q.add(s.pop());
				}
				q.add(null);
				startleftt = !startleftt;
				continue;
			}
			System.out.println(current.data + " ");
			if(startleftt){
				if(current.left != null)
					q.add(current.left);
				if(current.right!=null)
					q.add(current.right);
			}
			else{
				if(current.right != null)
					q.add(current.right);
				if(current.left!=null)
					q.add(current.left);
			}
		}
	}

	/****technique 2 using 2 stacks*/

	public static void zigZagOrderTraversal2(Node root) {

		if(root==null) return;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);

		while(!s1.isEmpty() || !s2.isEmpty()) {

			while(!s1.isEmpty()) {
				Node current = s1.pop();
				if(current.right != null)
					s2.add(current.right);
				if(current.left!=null)
					s2.add(current.left);
				System.out.print(current.data +" ");
			}

			while(!s2.isEmpty()) {
				Node current = s2.pop();
				if(current.left != null)
					s1.add(current.left);
				if(current.right!=null)
					s1.add(current.right);
				System.out.print(current.data + " " );
			}
		}
	}

	/****technique 3 using 1 Deque*/

	public static void zigZagOrderTraversal3(Node root) {

		if(root==null) return;

		Deque<Node> deque = new LinkedList<>();
		deque.addLast(null);
		deque.addLast(root);

		boolean startLast = true;

		while(deque.size()>1){
			Node current = null;
			if(startLast) {
				current = deque.removeLast();
				if(current==null) {
					startLast=false;
					deque.addLast(null);
				}
				else{
					if(current.right != null)
						deque.addFirst(current.right);
					if(current.left!=null)
						deque.addFirst(current.left);
					System.out.print(current.data + " " );
				}
			}
			else {
				current = deque.removeFirst();
				if(current==null) {
					startLast=true;
					deque.addFirst(null);
				}
				else{
					if(current.right != null)
						deque.addLast(current.right);
					if(current.left!=null)
						deque.addLast(current.left);
					System.out.print(current.data + " " );
				}
			}
			

		}

	}
	/****technique 4 using 1 Queue and Using linkedlist in the resultant List which we need to return*/
	public List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
	       
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        boolean flag = true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null)
                        q.add(curr.left);
                if(curr.right != null)
                        q.add(curr.right);
                if(flag){
                    temp.add(curr.val);
                }
                else{
                    temp.addFirst(curr.val);
                }
                
            }
            flag = !flag;
            res.add(temp);
        }
        return res;
    }
}
