package com.javaDwarf.graphs.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133_CloneGraph {

	public static void main(String[] args) {}
	
	Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
       if(node == null) return null;
       map = new HashMap<>();
       return helper(node); 
    }
    
    public Node helper(Node node){
        if(map.containsKey(node.val)) return map.get(node.val);
        Node n = null;
        if(!map.containsKey(node.val)){  
             map.put(node.val, new Node(node.val,new ArrayList<>()));
        }
        n = map.get(node.val);
        for(Node neighbor : node.neighbors){
            n.neighbors.add(helper(neighbor));
        }
        return n;        
    }

    
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
}
