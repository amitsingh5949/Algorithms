package com.javaDwarf.graphs.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _133_CloneGraph {
	
	public Node cloneGraphOptimized(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            Node currCopy = map.get(curr.val);
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor.val)){
                   Node neighborCopy = new Node(neighbor.val, new ArrayList<>());
                    q.add(neighbor);
                    map.put(neighbor.val, neighborCopy);
                }
                currCopy.neighbors.add(map.get(neighbor.val));
            }
        }
        return map.get(node.val);
    }

// visited is not required , see above solution
	public Node cloneGraph(Node node) {

		Map<Integer, Node> map = new HashMap<>();

		Set<Integer> visited = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while(!q.isEmpty()) {

			Node curr = q.poll();
			visited.add(curr.val);

			Node currCopy = map.getOrDefault(curr.val, new Node());
			currCopy.val = curr.val;
			map.put(curr.val, currCopy);

			List<Node> neighbors = curr.neighbors;

			for(Node neighbor : neighbors) {

				if(!visited.contains(neighbor.val)) {
					Node neighborCopy = map.getOrDefault(neighbor.val, new Node());
					neighborCopy.val = neighbor.val;
					currCopy.neighbors.add(neighborCopy);
					neighborCopy.neighbors.add(currCopy);
					map.put(neighbor.val, neighborCopy);
					q.add(neighbor);
				}
			}
		}
		return map.get(node.val);
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {}

		public Node(int _val,List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
