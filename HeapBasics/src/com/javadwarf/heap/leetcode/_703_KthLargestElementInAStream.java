package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _703_KthLargestElementInAStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	///Brute force approach using max heap , keep all elements in heap
	Queue<Integer> q;
    int k;
    public _703_KthLargestElementInAStream(int k, int[] nums) {
        q = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.k = k;
        for(int i : nums){
            q.add(i);        
        }
    }
    
    public int add(int val) {
        q.add(val);
        List<Integer> l = new ArrayList<>();
        int res = -1;
        for( int i=0;i<k-1; i++){
            l.add(q.poll()) ;               
        }
        res = q.peek();
        for( int i=0;i<l.size(); i++){ 
            q.add(l.get(i));
        }
        return res;
    }
    
    //using min heap, keeping k elements in heap all the time and top will be kth largest element
    public _703_KthLargestElementInAStream(int k, int[] nums, String overloadDummyArg) {
        q = new PriorityQueue<Integer>();
        this.k = k;
        for(int i : nums){
           q.add(i);
           if(q.size() > k){
              q.poll();
            }
        }
    }
    
    public int add1(int val) {
        q.add(val);
        if(q.size() > k){
           q.poll();
        }
        return q.peek();
    }


}
