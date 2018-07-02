package com.javaDwarf.binaryTrees;

public class BinaryTreeBasics1 {

	public static void main(String[] args) {
		
		BinaryTreeImpl sll = new BinaryTreeImpl();
		
		sll.insert(new Employee(101, "Amit Singh", "Application Developer"));
		sll.insert(new Employee(13, "Aryan Sharma", "Associate Manager"));
		sll.insert(new Employee(12, "Namit Singh", "Equity Analyst"));
		sll.insert(new Employee(78, "Amit kumar", "SMO"));
		sll.insert(new Employee(45, "simpu Singh", "Electronics Enggineer"));
		sll.insert(new Employee(7, "Aman", "Call Center"));
		sll.insert(new Employee(7, "Shashank kumar", "Digital marketing manager"));
		
		sll.insert(new Employee(110, "Sabrish", "L70"));
		sll.insert(new Employee(105, "KJ", "L20 dev"));
		sll.insert(new Employee(120, "Bref", "Accident"));
		sll.insert(new Employee(115, "Benitta", "Web developer"));
		sll.insert(new Employee(130, "Yamuna", "Tester"));
		
		sll.inOrderTraversal(sll.getRoot());
		
		try {
			System.out.println("lets find aryan : " + sll.find(13).displayNode());
			System.out.println("Min in Binary tree : " + sll.minBinaryTree());
			System.out.println("Max in Binary tree : " + sll.maxBinaryTree());
			System.out.println("lets delete Shashank : " + sll.delete(7).displayNode());
			System.out.println("lets delete simpu : " + sll.delete(45).displayNode());
			System.out.println("lets delete Bref : " + sll.delete(120).displayNode());
		} catch (BinaryTreeEmptyexception e) {
			e.printStackTrace();
		}
		sll.inOrderTraversal(sll.getRoot());

	}

}


