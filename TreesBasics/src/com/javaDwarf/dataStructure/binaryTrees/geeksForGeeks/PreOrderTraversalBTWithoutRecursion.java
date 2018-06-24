package com.javaDwarf.dataStructure.binaryTrees.geeksForGeeks;

import java.util.Stack;

import com.javaDwarf.dataStructure.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.dataStructure.binaryTrees.Employee;
import com.javaDwarf.dataStructure.binaryTrees.Node;

public class PreOrderTraversalBTWithoutRecursion {

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

		preOrderTraversalBTWithoutRecursion1(); 
		System.out.println();
		preOrderTraversalBTWithoutRecursion2();
	}


	//**************************************************************************************//

	public static void preOrderTraversalBTWithoutRecursion1() {
		Stack<Node> s = new Stack<>();

		s.add(bt.getRoot());
		Node current = null;
		while ( !s.isEmpty()){
			current=s.pop();
			while(current != null){
				if(current.getRightChild() !=null){
					s.add(current.getRightChild());
				}
				System.out.print(current.getEmployee().getEmpId() + " ");
				current = current.getLeftChild();
			}
		}
	}

	//**************************************************************************************//

	public static void preOrderTraversalBTWithoutRecursion2() {
		Stack<Node> s = new Stack<>();

		s.add(bt.getRoot());
		Node current = null;
		while ( !s.isEmpty()){
			current = s.pop();
			System.out.print(current.getEmployee().getEmpId() + " ");
			if(current.getRightChild()!=null){
				s.add(current.getRightChild());	
			}
			if(current.getLeftChild()!=null){
				s.add(current.getLeftChild());	
			}
		}
	}
}
