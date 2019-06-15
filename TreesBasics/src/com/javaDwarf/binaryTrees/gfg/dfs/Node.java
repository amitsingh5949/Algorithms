package com.javaDwarf.binaryTrees.gfg.dfs;

public class Node
{
	public int data;
	public Node left, right;
	public Node(int item)
    {
        data = item;
        left = right = null;
    }
    
    public static void inOrderTraversal(Node localRoot){

		if(localRoot != null){

			inOrderTraversal(localRoot.left);
			System.out.println("Current is : " + localRoot.data);
			inOrderTraversal(localRoot.right);


		}
	}
    
    @Override
   	public String toString() {
   		return "Node [data=" + data + "]";
   	}
}
