package com.javaDwarf.dataStructure.binaryTrees.geeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.dataStructure.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.dataStructure.binaryTrees.Employee;
import com.javaDwarf.dataStructure.binaryTrees.Node;

public class HeightOfTree {

	public static BinaryTreeImpl bt = new BinaryTreeImpl();

	public static int height = 0; 

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

		heightOfTree1(bt.getRoot(),1);
		System.out.println("Height of tree bye method 1 : " + height);

		System.out.println("Height of tree bye method 2 : " + heightOfTree2(bt.getRoot()));
	}


	private static void heightOfTree1(Node root, int h) {
		if(root == null){
			return ;
		}
		if(h>height){
			height = h;
		}
		heightOfTree1(root.getLeftChild(), h+1);
		heightOfTree1(root.getRightChild(), h+1);
	}

	public static int heightOfTree2(Node root) {
		if(root == null){
			return 0;
		}
		return 1 + Math.max(heightOfTree2(root.getLeftChild()),
				heightOfTree2(root.getRightChild()));
	}


}
