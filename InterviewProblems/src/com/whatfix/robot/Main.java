package com.whatfix.robot;

import java.util.HashMap;
import java.util.Map;

public class Main {

	private static Map<Integer,int[]> neighbhours = new HashMap<Integer,int[]>();
	
	static{
		neighbhours.put(Integer.valueOf(0),new int[]{1,4,5});
		neighbhours.put(Integer.valueOf(1),new int[]{0,2,4,5,6});
		neighbhours.put(Integer.valueOf(2),new int[]{1,3,5,6,7});
		neighbhours.put(Integer.valueOf(3),new int[]{2,6,7});
		neighbhours.put(Integer.valueOf(4),new int[]{0,1,5,8,9});
		neighbhours.put(Integer.valueOf(5),new int[]{0,1,2,4,6,8,9,10});
		neighbhours.put(Integer.valueOf(6),new int[]{1,2,3,5,7,9,10,11});
		neighbhours.put(Integer.valueOf(7),new int[]{2,3,6,10,11});
		neighbhours.put(Integer.valueOf(8),new int[]{4,5,9,12,13});
		neighbhours.put(Integer.valueOf(9),new int[]{4,5,6,8,10,12,13,14});
		neighbhours.put(Integer.valueOf(10),new int[]{5,6,7,9,11,13,14,15});
		neighbhours.put(Integer.valueOf(11),new int[]{6,7,10,14,15});
		neighbhours.put(Integer.valueOf(12),new int[]{8,9,13});
		neighbhours.put(Integer.valueOf(13),new int[]{8,9,10,12,14});
		neighbhours.put(Integer.valueOf(14),new int[]{9,10,11,13,15});
		neighbhours.put(Integer.valueOf(15),new int[]{10,11,14});
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(16);
		
		for(int i= 0; i<=15; i++){
			graph.insertVertices(Integer.valueOf(i).toString());
		}
		//graph.printGraph();
		graph.dfs(1,15);
	}
	
	public static Map<Integer, int[]> getNeighbhours() {
		return neighbhours;
	}

}
