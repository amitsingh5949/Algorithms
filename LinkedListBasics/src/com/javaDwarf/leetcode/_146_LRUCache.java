package com.javaDwarf.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _146_LRUCache {

	public static void main(String[] args) {

		/*_146_LRUCache cache = new _146_LRUCache( 2 /* capacity  );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));*/


		_146_LRUCache cache = new _146_LRUCache(3);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);

		System.out.println(cache.get(4));       
		System.out.println(cache.get(3));       
		System.out.println(cache.get(2));      
		System.out.println(cache.get(1));

		cache.put(5, 5);    
		System.out.println(cache.get(1));      
		System.out.println(cache.get(2));      
		System.out.println(cache.get(3));       
		System.out.println(cache.get(4));       
		System.out.println(cache.get(5));

	}

	int capacity;
	Map<Integer,Node> map = new HashMap<>();
	Node  head = null;
	Node  tail = null;

	public _146_LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		head = new Node(null,null,0,0);
		tail = new Node(null,null,0,0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			moveToFront(key);
			return map.get(key).value;
		}
		else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(map.containsKey(key)) {
			moveToFront(key);
			map.get(key).value = value;
		}
		else {
			if(map.size() == capacity) {
				Node nodeEvicted = removeRear();
				map.remove(nodeEvicted.key);
			}
			Node curr = addFront(key, value);
			map.put(key, curr);
		}
	}


	public void moveToFront(int key) {

		Node nodeToBeMoved = map.get(key);

		Node prevNode = nodeToBeMoved.prev;
		Node nextNode = nodeToBeMoved.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		nodeToBeMoved.next = null;
		nodeToBeMoved.prev = null;

		Node firstNode = head.next;

		head.next = nodeToBeMoved;
		nodeToBeMoved.prev= head;
		nodeToBeMoved.next = firstNode;
		firstNode.prev = nodeToBeMoved;

	}

	public Node removeRear() {

		Node nodeEvicted = tail.prev;

		Node evictedPrev = nodeEvicted.prev;

		if(nodeEvicted != head) {
			tail.prev = evictedPrev;
			evictedPrev.next = tail;
			nodeEvicted.next = null;
			nodeEvicted.prev = null;
		}

		return nodeEvicted;
	}

	public Node addFront(int key, int value) {

		Node curr = new Node(null,null,key,value);

		Node firstNode = head.next;

		head.next = curr;
		curr.prev= head;
		curr.next = firstNode;
		firstNode.prev = curr;

		return curr;
	}

	class Node{
		Node next;
		Node prev;
		int key;
		int value;

		public Node(Node next, Node prev, int key, int value) {
			super();
			this.next = next;
			this.prev = prev;
			this.key = key;
			this.value = value;
		}
	}

}

/************ Same as above but more cleaner ********/
class LRUCache {

	class Node {
		int key;
		int val;
		Node next;
		Node prev;
		public Node(int key, int val) {this.key = key; this.val = val;}
	}

	Map<Integer, Node> map;
	int totalCapacity;
	int initialCapacity;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.totalCapacity = capacity;
		this.initialCapacity = 0;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			Node n = removeElement(key);
			addElement(key, n.val);
			return n.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		int x = get(key);
		if(x == -1){
			if(initialCapacity == totalCapacity) removeElement(tail.prev.key);
			addElement(key, value);
		}
		else{
			removeElement(key);
			addElement(key, value);
		}
	}

	public void addElement(int key, int val){
		Node n = new Node(key, val);
		//adding at head
		Node next = head.next;

		head.next = n;
		n.prev = head;
		n.next = next;
		next.prev = n;

		map.put(key,n);
		initialCapacity++;
	}

	public Node removeElement(int key){
		Node n = map.get(key);

		Node prevE = n.prev;
		Node nextE = n. next;

		prevE.next = nextE;
		nextE.prev = prevE;

		map.remove(key);
		initialCapacity--;
		return n;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


