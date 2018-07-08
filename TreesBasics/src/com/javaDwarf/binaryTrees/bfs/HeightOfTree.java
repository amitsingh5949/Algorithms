package com.javaDwarf.binaryTrees.bfs;


public class HeightOfTree {

	public static int height = 0; 

	private static void heightOfTree1(Node root, int h) {
		if(root == null){
			return ;
		}
		if(h>height){
			height = h;
		}
		heightOfTree1(root.left, h+1);
		heightOfTree1(root.right, h+1);
	}

	public static int heightOfTree2(Node root) {
		if(root == null){
			return 0;
		}
		return 1 + Math.max(heightOfTree2(root.left),
				heightOfTree2(root.right));
	}


}
