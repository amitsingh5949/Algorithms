package com.javaDwarf.binaryTrees.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.BinaryTreeImpl;
import com.javaDwarf.binaryTrees.Employee;
import com.javaDwarf.binaryTrees.Node;

public class LevelOrderTraversalLineByLineBT {

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

		levelOrderTraversal1();//n square complexity
		System.out.println("\n");
		levelOrderTraversal3();// O(n) time complexity and O(w) space complexity (max width of tree)

	}


	//**************************************************************************************//

	private static void levelOrderTraversal1() {
		int height = HeightOfTree.heightOfTree2(bt.getRoot());
		for(int i = 1; i<=height; i++){
			printNodesAtLevel1(bt.getRoot(), i, 1);
			System.out.println();
		}
	}

	private static void printNodesAtLevel1(Node n, int level, int currentLevel){
		if(n==null){
			return;
		}
		if(level == currentLevel){
			System.out.print(n.getEmployee().getEmpId() +" ");
		}
		printNodesAtLevel1(n.getLeftChild(), level, currentLevel+1);
		printNodesAtLevel1(n.getRightChild(), level, currentLevel+1);
	}

	//**************************************************************************************//


	public static void levelOrderTraversal3() {
		Node root = bt.getRoot();
		Queue<Node> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		Node current = null;
		while ( !q.isEmpty() ){
			current = q.poll();
			if(current==null ){
				if(!q.isEmpty()){
					System.out.println();
					q.add(null);
					continue;
				}
				else{
					break;
				}
			}
			System.out.print(current.getEmployee().getEmpId() + " ");
			if(current.getLeftChild() != null)
				q.add(current.getLeftChild());
			if(current.getRightChild()!=null)
				q.add(current.getRightChild());
		}
	}


}
