package com.javadwarf.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _387_FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	
	
	
	//leetcode type solution
	 public static  int firstUniqChar1(String s) {
	 
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
	 
	// If q.remove() is not allowed 
		 public static  int firstUniqChar(String s) {
			 
			 if(s== null || s.length() == 0) return -1;
			 
			 int i = -1;
			 int index = 0;
			 
			 int[] visited = new int[26];
			 Queue<Character> q = new LinkedList<>();
			 
			 while(index<s.length()) {
				 
				 char ch = s.charAt(index++);
				 if(visited[ch-'a'] == 0) {
					 visited[ch-'a'] = 1 ;
					 q.add(ch);
				 }
				 else {
					 visited[ch-'a'] += 1 ;
					 while(!q.isEmpty() && visited[q.peek()-'a'] != 1) {
						 q.poll();
					 }
				 }
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
