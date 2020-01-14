package leetcodecontest.jan4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem3 {

	public static void main(String[] args) {
		int[][] arr = {{1,2},{0,3},{0,3},{1,2}};
		System.out.println(new Problem3().watchedVideosByFriends(null, arr, 0, 1));

	}
	
	Set<Integer> friendsAtLevelK = null;
	 List<String> res = null;

	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		
		res = new ArrayList<>();
		friendsAtLevelK = new HashSet<>();
		
		boolean[][] visited = new boolean[friends.length][friends.length];
		dfs(friends, id, level, visited);
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i : friendsAtLevelK) {
			res.addAll(watchedVideos.get(i));
		}
		
		for(String temp : res) {
			int count = map.getOrDefault(temp, 0);
			map.put(temp, count+1);
		}
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, (e1,e2) ->{
			int x = Integer.compare(e2.getValue(), e1.getValue());
			if(x == 0) {
				return e1.getKey().compareTo(e2.getKey());
			}
			return x;
		});
		List<String> resFinal = new ArrayList<String>();
		for(Map.Entry<String, Integer> e  : list) {
			resFinal.add(e.getKey());
		}
		return resFinal;
	}
	
	public void dfs(int[][] friends, int id, int level, boolean[][] visited) {
		
		if(level == 0) {
			friendsAtLevelK.add(id);
			return;
		}
		
		int[] friend = friends[id];
		
		for(int i=0; i<friend.length; i++) {
			
			int newFriend  = friend[i];
			
			if(!visited[id][newFriend] && !visited[newFriend][id] ) {
				visited[id][newFriend] = true;
				visited[newFriend][id] = true;
				dfs(friends,newFriend, level-1, visited);
				visited[id][newFriend] = false;
				visited[newFriend][id] = false;
			}
		}
		
	}

}
