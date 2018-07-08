package com.javaDwarf.binaryTrees.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.javaDwarf.binaryTrees.BinaryTreeImpl;

public class LevelOrderTraversalBT {

	public static BinaryTreeImpl bt = new BinaryTreeImpl();

	public static void main(String[] args) {

		Node root = null;
		
		levelOrderTraversal1(root);//n square complexity
		System.out.println("\n");
		levelOrderTraversal2(root);//n square complexity
		System.out.println("\n");
		levelOrderTraversal3(root);// O(n) time complexity and O(w) space complexity (max width of tree)

	}


	//**************************************************************************************//
	
	private static void levelOrderTraversal1(Node root) {
		int height = HeightOfTree.heightOfTree2(root);
		for(int i = 1; i<=height; i++){
             printNodesAtLevel(root, i, 1);
		}
	}
	
	private static void printNodesAtLevel(Node n, int level, int currentLevel){
		if(n==null){
			return;
		}
		if(level == currentLevel){
			System.out.println(n.data);
		}
		printNodesAtLevel(n.left, level, currentLevel+1);
		printNodesAtLevel(n.right, level, currentLevel+1);
	}
	
	//**************************************************************************************//
	
	private static void levelOrderTraversal2(Node root) {
		int height = HeightOfTree.heightOfTree2(root);
		for(int i = 1; i<=height; i++){
             printNodesAtLevel2(root, i);
		}
	}
	
	private static void printNodesAtLevel2(Node n, int level){
		if(n==null){
			return;
		}
		if(level ==1){
			System.out.println(n.data);
		}
		printNodesAtLevel2(n.left, level-1);
		printNodesAtLevel2(n.right, level-1);
	}
	
	//**************************************************************************************//

	public static void levelOrderTraversal3(Node root) {
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
				System.out.println(current.data + " ");
				if(current.left != null)
					q.add(current.left);
				if(current.right!=null)
					q.add(current.right);
			}
		}
	}


}
