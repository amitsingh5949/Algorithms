package com.javaDwarf.dataStructure.binaryTrees.geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.javaDwarf.dataStructure.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.dataStructure.binaryTrees.Employee;
import com.javaDwarf.dataStructure.binaryTrees.Node;

public class ZigZagTraversalBT {

	public static BinaryTreeImpl bt = new BinaryTreeImpl();

	public static void main(String[] args) {

		bt.insert(new Employee(101, "Amit Singh", "Application Developer"));
		bt.insert(new Employee(13, "Aryan Sharma", "Associate Manager"));
		bt.insert(new Employee(12, "Namit Singh", "Equity Analyst"));
		bt.insert(new Employee(78, "Amit kumar", "SMO"));
		bt.insert(new Employee(45, "simpu Singh", "Electronics Enggineer"));
		bt.insert(new Employee(7, "Aman", "Call Center"));

		bt.insert(new Employee(110, "Sabrish", "L70"));
		bt.insert(new Employee(105, "KJ", "L20 dev"));
		bt.insert(new Employee(120, "Bref", "Accident"));
		bt.insert(new Employee(115, "Benitta", "Web developer"));
		bt.insert(new Employee(130, "Yamuna", "Tester"));

		zigZagOrderTraversal2();

	}

	public static void zigZagOrderTraversal2() {
		Node root = bt.getRoot();
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		boolean startLeft = true;

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
					startLeft = !startLeft;
					continue;
				}
				System.out.println(current.getEmployee().toString() + " ");
				if(startLeft){
					if(current.getLeftChild() != null)
						q.add(current.getLeftChild());
					if(current.getRightChild()!=null)
						q.add(current.getRightChild());
				}
				else{
					if(current.getRightChild() != null)
						q.add(current.getRightChild());
					if(current.getLeftChild()!=null)
						q.add(current.getLeftChild());
				}
			}
	}
}
