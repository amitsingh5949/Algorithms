package com.javaDwarf.dataStructure.binaryTrees.geeksForGeeks;

import java.util.Stack;

import com.javaDwarf.dataStructure.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.dataStructure.binaryTrees.Employee;
import com.javaDwarf.dataStructure.binaryTrees.Node;

public class InOrderTraversalBTWithoutRecursion {

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

		inOrderTraversalBTWithoutRecursion();// O(n) time complexity and O(n) space complexity 

	}

	
	//**************************************************************************************//

	public static void inOrderTraversalBTWithoutRecursion() {
		Stack<Node> s = new Stack<>();

		s.add(bt.getRoot());
		Node current = null;
		while ( !s.isEmpty()){
				if(s.peek().getLeftChild()==null || current != null){
					current = s.pop();
					System.out.print(current.getEmployee().getEmpId() +" ");
					if(current.getRightChild()!=null){
						s.add(current.getRightChild());
						current=null;
					}
				}
				else if(s.peek().getLeftChild() !=null ){
					s.add(s.peek().getLeftChild());
				}
		}
	}


}
