package com.javadwarf.trie.leetcode;

public class _421_MaximumXORofTwoNumbersinanArray {

	public static void main(String[] args) {

	}

	class Node{
		Node left = null;
		Node right = null;
	}

	Node root = null;
	public int findMaximumXOR(int[] nums) {
		
		int maxXor = Integer.MIN_VALUE;
		
		this.root = new Node();
		
		for(int n : nums) {
			insert(n);
		}
		for(int n : nums) {
			maxXor = Integer.max(maxXor, findMaxXorPair(n));
		}
		
		return maxXor;
	}
	
	public void insert(int n) {
		Node curr = this.root;
		
		for(int i =31; i>=0; i--) {
			
			int currBit = (n & (1<<i));
			
			if(currBit == 0) {
				if(curr.left == null) {
					curr.left = new Node();
				}
				curr = curr.left;
			}
			else {
				if(curr.right == null) {
					curr.right = new Node();
				}
				curr = curr.right;
			}
		}
	}
	
	public int findMaxXorPair(int n) {
		Node curr = this.root;
		int currXor = 0;
		
		for(int i =31; i>=0; i--) {
			
			int currBit = (n & (1<<i));
			
			if(currBit == 0) {
				if(curr.right != null) {
					currXor += 1 * Math.pow(2, i);
					curr = curr.right;
				}
				else {
					curr = curr.left;
				}
			}
			else {
				if(curr.left != null) {
					currXor += 1 * Math.pow(2, i);
					curr = curr.left;
				}
				else {
					curr = curr.right;
				}
			}
		}
		return currXor;
	}

}
