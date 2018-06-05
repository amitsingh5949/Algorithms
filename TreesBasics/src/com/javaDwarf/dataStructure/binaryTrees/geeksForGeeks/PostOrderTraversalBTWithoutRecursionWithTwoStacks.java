package com.javaDwarf.dataStructure.binaryTrees.geeksForGeeks;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

import com.javaDwarf.dataStructure.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.dataStructure.binaryTrees.Employee;
import com.javaDwarf.dataStructure.binaryTrees.Node;

public class PostOrderTraversalBTWithoutRecursionWithTwoStacks {

	public static BinaryTreeImpl bt = new BinaryTreeImpl();

	public static void main(String[] args) {

		bt.insert(new Employee(101, "Amit Singh", "Application Developer"));
		bt.insert(new Employee(13, "Aryan Sharma", "Associate Manager"));
		bt.insert(new Employee(12, "Namit Singh", "Equity Analyst"));
		bt.insert(new Employee(78, "Amit kumar", "SMO"));
		bt.insert(new Employee(45, "simpu Singh", "Electronics Enggineer"));
		bt.insert(new Employee(7, "Aman", "Call Center"));
		bt.insert(new Employee(7, "Shashank kumar", "Digital marketing manager"));

		bt.insert(new Employee(110, "Sabrish", "L70"));
		bt.insert(new Employee(105, "KJ", "L20 dev"));
		bt.insert(new Employee(120, "Bref", "Accident"));
		bt.insert(new Employee(115, "Benitta", "Web developer"));
		bt.insert(new Employee(130, "Yamuna", "Tester"));

		postOrderTraversalBTWithoutRecursionWithTwoStacks(); 
	}


	//**************************************************************************************//

	public static void postOrderTraversalBTWithoutRecursionWithTwoStacks() {
		Stack<Node> sl = new Stack<>();
		Stack<Node> sr = new Stack<>();
		sr.add(bt.getRoot());
		Node current = null;
		while ( !sr.isEmpty()){
			current=sr.peek();
			while(current.getLeftChild() != null){
			sl.add(current.getLeftChild());
			}
		}
	}

}