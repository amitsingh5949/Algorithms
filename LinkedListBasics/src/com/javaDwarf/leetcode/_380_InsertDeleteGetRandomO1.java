package com.javaDwarf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class _380_InsertDeleteGetRandomO1 {

	public static void main(String[] args) {

		_380_InsertDeleteGetRandomO1 obj = new _380_InsertDeleteGetRandomO1();
		
		/*obj.insert(1);
		obj.remove(2);
		System.out.println(obj.getRandom());
		obj.insert(2);
		System.out.println(obj.getRandom());
		obj.remove(1);
		obj.insert(2);
		System.out.println(obj.getRandom());*/
		
		obj.remove(0);
		obj.remove(0);
		obj.insert(0);
		System.out.println(obj.getRandom());
		obj.remove(0);
		obj.insert(0);
		System.out.println(obj.getRandom());

	}
	
	List<Integer> list = null;
	Map<Integer, Integer> map = null;

	public _380_InsertDeleteGetRandomO1() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)) {
			return false;
		}
		list.add(val);
		map.put(val, list.size()-1);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		int lastElement = list.get(list.size()-1);
		list.set(index, lastElement);
		list.remove(list.size()-1);
		map.remove(val);
		map.put(lastElement, index);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if(list.size() > 0) {
			return list.get(new Random().nextInt(list.size()));
		}
		return -1;
	}


	/* HashMap and Double linkedlist Approach, works okay according to me but 1 test case is not passing in leetcode

	Node head = null;
	Node tail = null;
	Map<Integer, Node> map = null;

	public _380_InsertDeleteGetRandomO1() {
		map = new HashMap<>();
		head = new Node(Integer.MIN_VALUE);
		tail = new Node(Integer.MIN_VALUE);
		head.next = tail;
		tail.prev = head;

	}

	public boolean insert(int val) {

		if(map.containsKey(val)) {
			return false;
		}

		Node curr = new Node(val);

		Node before = tail.prev;

		before.next = curr;
		tail.prev = curr;

		curr.prev = before;
		curr.next = tail;

		map.put(val, curr);

		return true;


	}

	public boolean remove(int val) {

		if(!map.containsKey(val)) {
			return false;
		}

		Node removedNode = map.remove(val);

		Node before = removedNode.prev;
		Node after = removedNode.next;

		before.next= after;
		after.prev= before;

		return true;

	}

	public int getRandom() {

		if(head.next.val == Integer.MIN_VALUE) {
			return -1;
		}

		Node last = tail.prev;
		Node first = head.next;

		if(first == last) {
			return first.val;
		}

		Node before = last.prev;
		Node after = last.next;

		before.next = after;
		after.prev = before;

		last.next = null;
		last.prev = null;

		head.next = last;
		last.prev = head;
		last.next = first;
		first.prev = last;

		return last.val;
	}

	class Node{

		int val;
		Node prev;
		Node next;

		public Node(int val) {
			super();
			this.val = val;
		}



	}

	 */

}
