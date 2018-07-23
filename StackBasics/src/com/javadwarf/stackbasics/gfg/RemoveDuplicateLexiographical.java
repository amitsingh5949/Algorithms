package com.javadwarf.stackbasics.gfg;

import java.util.Stack;

public class RemoveDuplicateLexiographical {

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
	}
	
	public static String removeDuplicateLetters(String s) {
		char[] cArr = s.toCharArray();
		int[] charCount = new int[26];
		boolean[] visited = new boolean[26];
		Stack<Character> stack = new Stack<>();
		
		for(char c : cArr) {
			charCount[c-'a']++;
		}
		for(char c : cArr) {
			int index = c - 'a';
			charCount[index]--;
			
			if(visited[index]) {
				continue;
			}
			while(!stack.isEmpty() && c<stack.peek() && charCount[stack.peek()-'a'] != 0){
				char ch = stack.pop();
				visited[ch-'a'] = false;
				
			}
			stack.push(c);
			visited[index] = true;
		}
		
		
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

}
