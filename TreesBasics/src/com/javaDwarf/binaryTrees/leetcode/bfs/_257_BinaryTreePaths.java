package com.javaDwarf.binaryTrees.leetcode.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _257_BinaryTreePaths {


	class Element{
		TreeNode node = null;
		String path = null;
		public Element(TreeNode node, String path) {
			super();
			this.node = node;
			this.path = path;
		}

	}

	public List<String> binaryTreePaths(TreeNode root) {

		List<String>  l =new ArrayList<String>();
		if(root == null) return l;

		Stack<Element> q = new Stack<>();
		q.add(new Element(root, Integer.valueOf(root.val).toString()));


		while(!q.isEmpty()) {

			Element e = q.pop();
			
			if(e.node.left==null && e.node.right==null) {
				l.add(e.path);
				continue;
			}
			
			if(e.node.left!=null) {
				q.add(new Element(e.node.left, (e.path+"->"+e.node.left.val)));
			}
			if(e.node.right!=null) {
				q.add(new Element(e.node.right, (e.path+"->"+e.node.right.val)));
			}
		}
		return l;
	}
	
	
	//recursion
	List<String> res;
	public List<String> binaryTreePaths1(TreeNode root) {
        res = new ArrayList<>();
        helper(root, new ArrayList<>());
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> sb){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            sb.add(root.val);
            String s = sb.stream().map(i->i.toString()).collect(Collectors.joining("->"));
            res.add(s);
            sb.remove(sb.size()-1);
            return;
        }
        
        sb.add(root.val);
        helper(root.left, sb);
        helper(root.right,sb);
        sb.remove(sb.size()-1);
    }


}
