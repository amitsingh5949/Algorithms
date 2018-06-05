package com.javaDwarf.dataStructure.graphs.basics1.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlienDictionary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();
		for(int i=0; i<numOfTestCases; i++){
			int numOfWords = in.nextInt();
			int numOfDiffLetters = in.nextInt();
			GraphImpl3 g = new GraphImpl3(numOfDiffLetters);
			String[] dictionary = new String[numOfWords];
			for(int j=0; j<numOfWords; j++){
				dictionary[j] = in.next();
			}
			g.constuctGraph(dictionary, numOfWords, numOfDiffLetters);
			System.out.println(g.topologicalSort());
		}
		in.close();
	}

}

class Vertex implements Comparable<Vertex>{
	Character val;
	List<Vertex> neighbhourList;

	public Vertex(Character val){
		this.val = val;
		neighbhourList =  new ArrayList<>();
	}

	@Override
	public int compareTo(Vertex o) {
		return Character.compare(this.val, o.val);
	}
}

class GraphImpl3{
	int numOfVertecies;
	Map<Character,Vertex> map;
	int[] dependentCount=null;

	public GraphImpl3(int numOfVertecies){
		this.numOfVertecies = numOfVertecies;
		map = new HashMap<>();
	}

	public void addEdge(Character src, Character dest){
		if(!map.containsKey(src)){
			map.put(src, new Vertex(src));
		}
		if(!map.containsKey(dest)){
			map.put(dest, new Vertex(dest));
		}
		Vertex srcV = map.get(src);
		Vertex destV = map.get(dest);
		if(!srcV.neighbhourList.contains(destV)){
			srcV.neighbhourList.add(destV);
		}
	}

	public void constuctGraph(String[] dictionary, int numOfWords, int numOfDiffLetters){

		int maxLengthOfWord=0;
		for(String temp: dictionary){
			if(temp.length()>maxLengthOfWord)
				maxLengthOfWord=temp.length();
		}

		for(int i=0; i<maxLengthOfWord; i++){
			for(int j=0; j<dictionary.length; j++){
				for(int k=j+1; k<dictionary.length; k++){
					if(j!=k){
						String temp1 = null;
						String temp2 = null;
						if(dictionary[j].length() >= i){
							temp1 = dictionary[j].substring(0, i);
						}
						if(dictionary[k].length() >= i){
							temp2 = dictionary[k].substring(0, i);
						}
						if(temp1==null || temp2==null){
							continue;
						}
						else if((temp1.equals("") && temp2.equals("")) || temp1.equals(temp2)){
							Character c1 = dictionary[j].charAt(i);
							Character c2 = dictionary[k].charAt(i);
							if(c1!=c2){
								addEdge(c1, c2);
							}
						}
					}
				}
			}

		}
	}


	public String topologicalSort(){
		String result = "";
		boolean[] visited = new boolean[256];

		dependentCount = getDependentCount();

		Iterator<Map.Entry<Character, Vertex>> itr =  map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Character, Vertex> e =  itr.next();
			Character c  = e.getValue().val;
			result = dfs(c,visited,result);
		}
		return result;
	}

	private String  dfs(Character src, boolean[] visited, String result){
		if(dependentCount[(int)src]==0 && !visited[(int)src]){
			result += src;
			visited[(int)src] =true;
		}
		List<Vertex> neighbhour = map.get(src).neighbhourList;
		for(Vertex temp : neighbhour){
			if(dependentCount[(int)src]==0 && !visited[(int)temp.val]){
				dependentCount[(int)temp.val] = dependentCount[(int)temp.val] - 1;
			}
			result = dfs(temp.val,visited,result);
		}
		return result;
	}

	private  int[] getDependentCount() {
		int[] dependentCount = new int[256];//better use 26 length array, always char-'a' for index
		for(int i=0; i<dependentCount.length; i++){
			dependentCount[i]=-1;

		}
		Iterator<Map.Entry<Character, Vertex>> itr =  map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Character, Vertex> e =  itr.next();
			if(dependentCount[(int)e.getKey()]==-1){
				dependentCount[(int)e.getKey()] = 0;
			}
			List<Vertex> list = e.getValue().neighbhourList;
			for(int j=0;j<list.size();j++){
				char c = list.get(j).val;
				if(dependentCount[(int)c] == -1){
					dependentCount[(int)c] = 1;
				}
				else{
					dependentCount[(int)c] = dependentCount[(int)c] +1 ;
				}
			}
		}
		return dependentCount;
	}
}


