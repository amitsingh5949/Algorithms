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
		int value;
		Node next;
		Node prev;
		public Node(int key, int value) {this.key = key; this.value = value;}
	}

	Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int currCapacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        currCapacity = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key).value;
            put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(key);
        }
        if(currCapacity == capacity){
            removeNode(tail.prev.key);
        }
        addNode(key, value);
    }
    
    public void addNode( int key, int value){
        Node curr = new Node(key, value);
        
        Node prev = head;
        Node next = head.next;
        
        prev.next = curr;
        curr.prev = prev;
        
        curr.next = next;
        next.prev = curr;
        
        map.put(key, curr);
        currCapacity++;
    }
    
    public void removeNode(int key){
        
        if(!map.containsKey(key)) return;
        
        Node curr = map.get(key);
        
        Node prev = curr.prev;
        Node next = curr.next;

        prev.next = next;
        next.prev = prev;
        
        map.remove(key);
        currCapacity--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


