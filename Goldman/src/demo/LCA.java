package demo;

import java.util.Stack;



public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node LCA(Node root, int v1,int v2)
	{
		Node lca = root;
		Stack<Node>  s1 = new Stack<>();
		Stack<Node>  s2 = new Stack<>();
		dfs(root, v1, false, s1);
		dfs(root, v2, false, s2);

		if(!s1.isEmpty() && !s2.isEmpty()) {
			lca = s1.peek();
			while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
				lca = s1.peek();
				s1.pop();
				s2.pop();
			}
		}
		return lca;
	}

	public static boolean dfs(Node root, int n1, boolean found, Stack<Node> s){
		if(root == null) {
			return false;
		}
		if(root!=null && root.data==n1) {
			return true;
		}
		found = dfs(root.left,n1,found,s) || dfs(root.right,n1,found,s);
		if(found) {
			if(root.left != null && root.left.data==n1 ) {
				s.add(root.left);
			}
			else if(root.right != null && root.right.data==n1 ) {
				s.add(root.right);
			}
			s.add(root);
		}
		return found;
	}

}

 class Node
{
	public int data;
	public Node left, right;
	public Node(int item)
    {
        data = item;
        left = right = null;
    }
    
    
    
    
}
