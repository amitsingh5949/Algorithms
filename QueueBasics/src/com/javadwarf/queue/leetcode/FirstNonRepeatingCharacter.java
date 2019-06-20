package com.javadwarf.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	//leetcode type solution
	 public static  int firstUniqChar(String s) {
	 
		 int i = -1;
		 int index = 0;
		 
		 boolean[] visited = new boolean[26];
		 Queue<Character> q = new LinkedList<>();
		 
		 while(index<s.length()) {
			 char ch = s.charAt(index);
			 if(!visited[ch-'a']) {
				 visited[ch-'a'] = true;
				 q.add(Character.valueOf(ch));
			 }
			 else {
				q.remove(Character.valueOf(ch)); 
			 }
			 index++;
		 }
		 if(!q.isEmpty()) {
			 char ch = q.poll();
			 index = 0;
			 while(index < s.length()) {
				 if(ch == s.charAt(index)) {
					 i = index;
					 break;
				 }
				 index++;
			 }
		 }
		 return i;
	 }

}
