package com.javaDwarf.leetcode;

public class _109_ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {

	}
	// O(n) time and o(n) space
	// create sorted array from sorted list, and use the array to create bst
	// Top -down approach
	public TreeNode sortedListToBST(ListNode head) {

		if(head == null ) return null;

		int size = 0;

		ListNode temp = head;

		while(temp!=null) {
			temp = temp.next;
			size++;
		}

		int[] arr = new int[size];

		temp = head;
		size = 0;
		while(temp!=null) {
			arr[size] = temp.val;
			temp = temp.next;
		}

		return addNode(arr, 0, arr.length-1);
	}

	public TreeNode addNode(int[]nums, int start, int end) {
		if(start >  end) {
			return null;
		}
		int mid = (start+end)/2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = addNode(nums, start, mid-1);
		root.right = addNode(nums, mid+1, end);
		return root;
	}


	//O(n) time and O(1) space
	//Bottom-up approach

	ListNode head = null;

	public TreeNode sortedListToBST1(ListNode head) {

		if(head == null ) return null;

		int size = 0;

		ListNode temp = head;

		while(temp!=null) {
			temp = temp.next;
			size++;
		}
		this.head = head;

		return addNode( 0, size-1);
	}
	
	private TreeNode addNode(int start, int end) {

		if(start > end) {
			return null;
		}

		int mid = (start + end)/2;

		TreeNode left = addNode(start, mid-1);

		TreeNode root = new TreeNode(this.head.val);
		root.left  = left;
		
		this.head = this.head.next;
		
		root.right = addNode(mid+1, end);
		
		return root;

	}




}
