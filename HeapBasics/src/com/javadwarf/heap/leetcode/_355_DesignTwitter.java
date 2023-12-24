package com.javadwarf.heap.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _355_DesignTwitter {

	public static void main(String[] args) {}
	
	public Map<Integer, Set<Integer>> follow;
    public Map<Integer, Node> feed;
    public int time;
    
    public _355_DesignTwitter() {
        follow = new HashMap<>();    
        feed = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Node head = feed.getOrDefault(userId, new Node(-1,-1,-1));
        Node curr = new Node(userId, tweetId, time++);
        head.next = curr;
        curr.prev = head;
        feed.put(userId, curr);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> l = new ArrayList<>();
        Set<Integer> users = follow.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        Queue<Node> q = new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));
        for(int user : users){
            if(feed.get(user) != null)
               q.add(feed.get(user));
        }
        
        int i=0;
        while(!q.isEmpty() && i< 10){
            Node n = q.poll();
            l.add(n.tweetId);
            if(n.prev.userId != -1)
                q.add(n.prev);
            i++;
        }
        return l;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = follow.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        follow.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId) && follow.get(followerId).contains(followeeId)){
            follow.get(followerId).remove(followeeId);
        }
    }
    
    class Node{
        int userId;
        int time;
        int tweetId;
        Node next;
        Node prev;
        public Node(int userId, int tweetId, int time){
            this.userId = userId;
            this.time = time;
            this.tweetId = tweetId;
        }
    }

}
