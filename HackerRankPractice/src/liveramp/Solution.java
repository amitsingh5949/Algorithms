package liveramp;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	
	public static DisjointSet ds = null;
	
	private static void addLink(String id1, String id2){
		
		if(isLinked(id1, id2)) return;
		
		
		Node node1 = ds.map.get(id1);
		Node node2 = ds.map.get(id2);
		
		if(node1 == null) {
			ds.makeSet(id1);
		}
		
		if(node2 == null) {
			ds.makeSet(id2);
		}
		
		ds.union(id1, id2);
	}

	private static boolean isLinked(String id1, String id2){
		
		Node node1 = ds.map.get(id1);
		Node node2 = ds.map.get(id2);
		
		if(node1== null || node2== null)
			return false;

		Node parentNode1 = ds.map.get(ds.find(id1));
		Node parentNode2 = ds.map.get(ds.find(id2));
		
		if(parentNode1==null || parentNode2==null)
			return false;

		if(id1.equalsIgnoreCase(id2) ||
				parentNode1.data.equalsIgnoreCase(parentNode1.data))
			return true;
		else 
			return false;

	}

	private static void removeId(String id){
		ds.map.remove(id);
	}

	// Boilerplate below to emulate successive API calls.
	// Do not change
	public static boolean[] solution(long[] operationsToPerform, String[] firstArgs, String[] secondArgs) {
		ds = new DisjointSet();
		boolean[] isLinkedResults = new boolean[operationsToPerform.length];

		for (int opNum = 0; opNum < operationsToPerform.length; opNum++) {
			isLinkedResults[opNum] = callOperation(operationsToPerform[opNum], firstArgs[opNum], secondArgs[opNum]);
		}

		return isLinkedResults;
	}

	private static boolean callOperation(long operationType, String firstArg, String secondArg) {
		if (operationType == 0) {
			addLink(firstArg, secondArg);
		} else if (operationType == 1) {
			return isLinked(firstArg, secondArg);
		} else if (operationType == 2) {
			removeId(firstArg);
		} else {
			throw new RuntimeException("Unrecognized operation type.");
		}

		return true;
	}
}



class DisjointSet {

	public Map<String, Node> map = new HashMap<>();

	public void makeSet(String data) {
		Node node = new Node(data);
		map.put(data, node);
	}

	public boolean union(String data1, String data2) {

		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parentNode1 = map.get(find(data1));
		Node parentNode2 = map.get(find(data2));

		if(node1 == null || node2 == null || data1.equalsIgnoreCase(data2) ||
				node1.parent.data.equalsIgnoreCase(node2.parent.data))
			return false;

		if(parentNode1.rank > parentNode2.rank){
			parentNode2.parent = parentNode1;
		}
		else if (parentNode1.rank < parentNode2.rank) {
			parentNode1.parent = parentNode2;
		}
		else {
			parentNode1.rank += 1;
			parentNode2.parent = parentNode1;
		}
		return true;
	}


	public String find(String data) {

		Node currNode = map.get(data);
		Node parent = currNode.parent;

		if(!data.equalsIgnoreCase(parent.data)){
			String rootParent = find(parent.data);
			currNode.parent = map.get(rootParent);
		}
		return currNode.parent.data;
	}
}

class Node{
	Node parent;
	String data;
	int rank;
	public Node(String data) {
		this.data = data;
		this.parent = this;
		this.rank = 0;
	}
}
