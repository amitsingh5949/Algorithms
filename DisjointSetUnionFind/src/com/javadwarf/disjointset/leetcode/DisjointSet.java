package com.javadwarf.disjointset.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * Tushar roy Video link - https://youtu.be/ID00PMy0-vE
 *  
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 * 
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is 
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class DisjointSet {

	//map to store all the logical nodes corresponding to each vertex
	public Map<Integer, Node> map = new HashMap<>();

	class Node{
		Node parent;
		int data;
		int rank;
		public Node(int data) {
			this.data = data;
			this.parent = this;
			this.rank = 0;
		}
	}

	/**
	 * Create a set with only one element. Will be called in the beginning for each vertex and will create individual sets for each vertex.
	 */
	public void makeSet(int data) {
		Node node = new Node(data);
		map.put(data, node);
	}

	/**
	 * Combines two sets together to one.
	 * Does union by rank
	 *   Given two elements, get their respective parents
	 *   a.) if parents are same return false
	 *   b.) If parents are different, merge them based on their rank and return true
	 *      1.) if rank is same then take any parent increment its rank by 1 and set it to be parent of other parent
	 *      2.) ranks is different , greater rank parent becomes the parent of the other parent
	 */
	public boolean union(int data1, int data2) {

		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parentNode1 = map.get(find(data1));
		Node parentNode2 = map.get(find(data2));

		//if they are part of same set do nothing
		if(node1 == null || node2 == null || data1 == data2 || node1.parent.data == node2.parent.data) 
			return false;

		//else whoever's rank is higher becomes parent of other
		if(parentNode1.rank > parentNode2.rank){
			parentNode2.parent = parentNode1;
		}
		else if (parentNode1.rank < parentNode2.rank) {
			parentNode1.parent = parentNode2;
		}
		else {
			//increment rank only if both sets have same rank
			parentNode1.rank += 1;
			parentNode2.parent = parentNode1;
		}
		return true;
	}

	/**
	 * Find the representative of the set or root parent  recursively and does path
	 * compression as well.
	 */
	public int find(int data) {

		Node currNode = map.get(data);
		Node parent = currNode.parent;

		if(currNode != parent){
			int rootParent = find(parent.data);
			currNode.parent = map.get(rootParent);
		}
		return currNode.parent.data;
	}
}
