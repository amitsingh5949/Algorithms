package com.javaDwarf.binaryTrees.dfs;

class Node
{
   

	int data;
    Node left, right;
    Node(int item)
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
