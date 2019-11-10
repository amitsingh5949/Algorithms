package amazon.harsh;

import java.util.LinkedList;
import java.util.Queue;


public class Problem2 {

	public static void main(String[] args) {

	}
	
	public boolean isSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {

		if(root1 == null && root2 == null) return true;
		else if(root1 != null && root2 == null) return false;
		else if(root1 == null && root2 != null) return false;

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root1);

		while(!q.isEmpty()) {

			BinaryTreeNode curr = q.poll();

			if(isSubtreeSame(curr, root2)) return true;

			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}

		return false;

	}

	public boolean isSubtreeSame(BinaryTreeNode s, BinaryTreeNode t) {

		if(s == null && t == null) return true;
		else if(s != null && t == null) return false;
		else if(s == null && t != null) return false;

		boolean left = isSubtreeSame(s.left, t.left);
		boolean right = isSubtreeSame(s.right, t.right);

		return left && right && (s.value == t.value);

	}
	


}
class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	
}
