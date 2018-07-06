package com.javaDwarf.binaryTrees.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.binaryTrees.Employee;
import com.javaDwarf.binaryTrees.Node;

public class LevelOrderTraversalBT {

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

		bt.inOrderTraversal(bt.getRoot());
		System.out.println("\n");
		levelOrderTraversal1();//n square complexity
		System.out.println("\n");
		levelOrderTraversal2();//n square complexity
		System.out.println("\n");
		levelOrderTraversal3();// O(n) time complexity and O(w) space complexity (max width of tree)

	}


	//**************************************************************************************//
	
	private static void levelOrderTraversal1() {
		int height = HeightOfTree.heightOfTree2(bt.getRoot());
		for(int i = 1; i<=height; i++){
             printNodesAtLevel(bt.getRoot(), i, 1);
		}
	}
	
	private static void printNodesAtLevel(Node n, int level, int currentLevel){
		if(n==null){
			return;
		}
		if(level == currentLevel){
			System.out.println(n.getEmployee());
		}
		printNodesAtLevel(n.getLeftChild(), level, currentLevel+1);
		printNodesAtLevel(n.getRightChild(), level, currentLevel+1);
	}
	
	//**************************************************************************************//
	
	private static void levelOrderTraversal2() {
		int height = HeightOfTree.heightOfTree2(bt.getRoot());
		for(int i = 1; i<=height; i++){
             printNodesAtLevel2(bt.getRoot(), i);
		}
	}
	
	private static void printNodesAtLevel2(Node n, int level){
		if(n==null){
			return;
		}
		if(level ==1){
			System.out.println(n.getEmployee());
		}
		printNodesAtLevel2(n.getLeftChild(), level-1);
		printNodesAtLevel2(n.getRightChild(), level-1);
	}
	
	//**************************************************************************************//

	public static void levelOrderTraversal3() {
		Node root = bt.getRoot();
		Queue<Node> q = new LinkedList<>();

		Node current = null;
		boolean visitRoot = true;
		while (visitRoot || !q.isEmpty()){
			if(visitRoot){
				q.add(root);
				visitRoot = false;
			}
			else{
				current = q.poll();
				System.out.println(current.getEmployee().toString() + " ");
				if(current.getLeftChild() != null)
					q.add(current.getLeftChild());
				if(current.getRightChild()!=null)
					q.add(current.getRightChild());
			}
		}
	}


}
