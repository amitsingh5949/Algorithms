package com.javadwarf.hashtable.leetcode;


public class _705_DesignHashSet {
	
	// space complexity O(n)
		// Time complexity 
		//add, remove  and contains- Worst case o(n), average case O(1)
	
	private Node[] buckets;

	class Node{
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
		}
	}
	
	public int hashValue(int key) {
		return key % buckets.length;
	}

	public _705_DesignHashSet() {
		buckets = new Node[50000];
	}

	public void add(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			buckets[index] = new Node(-1);
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			pos.next = new Node(key);
		}

	}

	public void remove(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			return;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return;
		}
		else {
			pos.next = pos.next.next;
		}

	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		
		int index = hashValue(key);

		if(buckets[index] == null) {
			return false;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return false;
		}
		else {
			return true;
		}

	}
	
	public Node findElement(int key, Node head) {

		Node curr = head;
		Node prev = null;

		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}

		return prev;

	}

}


//Implementing HashSet using double hashing collision resolution strategy all operation o(1) and space is o(HASH_LEN1 *HASH_LEN2)
class MyHashSetUsingDoubleHahing {
    
    final private  int HASH_LEN1 = 1000;
    final private  int HASH_LEN2 = 1000;
    
    private  boolean[][] hashValMatrix;

    public MyHashSetUsingDoubleHahing() {
        hashValMatrix = new boolean[HASH_LEN1][];
    }
    
    public void add(int key) {
        
        if(contains(key)) return;
        
        int hash1 = getHash1(key);
        if(hashValMatrix[hash1] == null){
            if(hash1 == 0){
               hashValMatrix[hash1] = new boolean[HASH_LEN2+1]; 
            }
            else{
               hashValMatrix[hash1] = new boolean[HASH_LEN2];  
            }
        }
        int hash2 = getHash2(key);
        hashValMatrix[hash1][hash2] = true;
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            hashValMatrix[hash1][hash2] = false;
        } 
    }
    
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        if(hashValMatrix[hash1] == null) return false;
        return hashValMatrix[hash1][hash2];
    }
    
    public int getHash1(int key){
        return key%HASH_LEN1;
    }
    public int getHash2(int key){
        return key/HASH_LEN2;
    }
    
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
