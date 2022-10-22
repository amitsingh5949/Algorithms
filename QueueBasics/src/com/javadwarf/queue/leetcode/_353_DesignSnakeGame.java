package com.javadwarf.queue.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _353_DesignSnakeGame {

	public static void main(String[] args) {}

}

class SnakeGame {

    List<Pair<Integer, Integer>> q;
    boolean[][] visited;
    int width, height;
    int[][] food;
    int i = 0;
    Map<String, int[]> dirs;

    public SnakeGame(int width, int height, int[][] food) {
        
        q = new LinkedList<>();
        q.add(new Pair<>(0,0));
        visited = new boolean[height][width];
        visited[0][0] = true;

        this.width = width;
        this.height = height;
        this.food = food;
        
        i = 0;
        
        dirs = new HashMap<>();
        dirs.put("L", new int[]{0,-1});
        dirs.put("R", new int[]{0,1});
        dirs.put("U", new int[]{-1,0});
        dirs.put("D", new int[]{1,0});
        
    }
    
    public int move(String direction) {
        int[] dir = dirs.get(direction);
        Pair<Integer, Integer> head = q.get(0);
        Pair<Integer, Integer> tail = q.get(q.size()-1);
        int x = head.getKey();
        int y = head.getValue();
        
        int xNew = x + dir[0];
        int yNew = y + dir[1];
        
        if(xNew<0 || xNew>=height || yNew<0 || yNew>= width) return -1;
        
        if( !(xNew == tail.getKey() && yNew == tail.getValue()) &&  visited[xNew][yNew]) return -1;
        
        if(i < food.length && xNew == food[i][0] && yNew == food[i][1]){
            visited[xNew][yNew] = true;
            q.add(0,new Pair<>(xNew,yNew));
            i++;
        }
        else{
            q.remove(q.size()-1);
            visited[tail.getKey()][tail.getValue()] = false;
            visited[xNew][yNew] = true;
            q.add(0,new Pair<>(xNew,yNew));
        }
        
        return q.size()-1;
        
    }
    
}

class Pair<K, V>{
	int k,v;
	public Pair(int k, int v) {
		this.k = k;
		this.v= v;
	}
	
	public int getKey() {
		return k;
	}
	public int getValue() {
		return v;
	}
}



