package com.javaDwarf.binaryTrees.geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.javaDwarf.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.binaryTrees.Employee;
import com.javaDwarf.binaryTrees.Node;

public class ReverseOrderTraversalBT {

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
		reverseOrderTraversal1();
		System.out.println();
		reverseOrderTraversal2();
	}



	//**************************************************************************************//
	private static void reverseOrderTraversal1() {
		int height = HeightOfTree.heightOfTree2(bt.getRoot());
		for(int i = height; i>=1; i--){
             printNodesAtLevel1(bt.getRoot(), i);
		}
	}
	
	private static void printNodesAtLevel1(Node n, int level){
		if(n==null){
			return;
		}
		if(level ==1){
			System.out.print(n.getEmployee().getEmpId() + " ");
		}
		printNodesAtLevel1(n.getLeftChild(), level-1);
		printNodesAtLevel1(n.getRightChild(), level-1);
	}
//*****************************************************************************************//
	private static void reverseOrderTraversal2() {
		
		Stack<Node> s = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		
		q.add(bt.getRoot());
		Node current = null;
		while(!q.isEmpty()){
			current = q.poll();
			if(current.getRightChild()!=null)
				q.add(current.getRightChild());
			if(current.getLeftChild() != null)
				q.add(current.getLeftChild());
			s.add(current);
		}
		while(!s.isEmpty()){
			System.out.print(s.pop().getEmployee().getEmpId() + " ");
		}
	}


}
