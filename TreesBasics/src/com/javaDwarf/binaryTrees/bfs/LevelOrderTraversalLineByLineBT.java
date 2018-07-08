package com.javaDwarf.binaryTrees.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLineBT {


	public static void main(String[] args) {

		Node root = null;

		levelOrderTraversal1(root);//n square complexity
		System.out.println("\n");
		levelOrderTraversal3(root);// O(n) time complexity and O(w) space complexity (max width of tree)

	}


	//**************************************************************************************//

	private static void levelOrderTraversal1(Node root) {
		int height = HeightOfTree.heightOfTree2(root);
		for(int i = 1; i<=height; i++){
			printNodesAtLevel1(root, i, 1);
			System.out.println();
		}
	}

	private static void printNodesAtLevel1(Node n, int level, int currentLevel){
		if(n==null){
			return;
		}
		if(level == currentLevel){
			System.out.print(n.data +" ");
		}
		printNodesAtLevel1(n.left, level, currentLevel+1);
		printNodesAtLevel1(n.right, level, currentLevel+1);
	}

	//**************************************************************************************//


	public static void levelOrderTraversal3(Node root) {
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
			System.out.print(current.data + " ");
			if(current.left != null)
				q.add(current.left);
			if(current.right!=null)
				q.add(current.right);
		}
	}
	
	


}
