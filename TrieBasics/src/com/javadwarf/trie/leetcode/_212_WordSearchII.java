package com.javadwarf.trie.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _212_WordSearchII {


	public static void main(String[] args) {
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};

		String[] words = {"oath","pea","eat","rain"};
		
		char[][] board1 = {
				{'a'}
		};

		String[] words1 = {"a"};
		
		char[][] board2 = {{'a','b'},{'a','a'}};
		String[] words2 ={"aba","baa","bab","aaab","aaa","aaaa","aaba"};


		List<String> x  = new _212_WordSearchII().findWords(board1, words1);
		System.out.println(x);
	}

	class TrieNode {

		public Map<Character,TrieNode> map = null;
		public boolean endOfWord = false;

		public TrieNode() {
			map = new HashMap<>();
			endOfWord = false;
		}
	}

	class Pos{
		int x,y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	TrieNode root = new TrieNode();
	Set<String> l = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {

		this.l = new HashSet<String>();

		if(board == null || board.length == 0 || words == null || words.length == 0) {
			return new ArrayList<String>(this.l);
		}

		for(String word : words) {
			insert(word);
		}

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				dfsTrieSearch(new Pos(i,j), board, new boolean[board.length][board[i].length], root, "");
			}
		}
		return new ArrayList<String>(this.l);
	}

	private void insert(String word) {

		TrieNode curr = root;

		int i= 0;
		while(i < word.length()) {
			Character ch = word.charAt(i);
			if(!curr.map.containsKey(ch)) {
				curr.map.put(ch, new TrieNode());
			}
			curr = curr.map.get(ch);
			i++;
		}
		curr.endOfWord = true;
	}

	public void dfsTrieSearch(Pos p, char[][] board, boolean[][] visited, TrieNode curr, String currWord ) {
		
		visited[p.x][p.y] = true;
		Character ch = board[p.x][p.y];
		currWord += ch;
		
		if(curr != null && curr.map.get(ch)!= null && curr.map.get(ch).endOfWord) {
			this.l.add(currWord);
		}

		if(!curr.map.containsKey(ch)) {
			return;
		}

		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};

		for(int i=0; i<xArr.length; i++) {

			int x = p.x + xArr[i];
			int y = p.y + yArr[i];

			if(x>=0 && x<board.length && y>=0 && y<board[x].length && !visited[x][y]) {
				dfsTrieSearch(new Pos(x,y), board, visited, curr.map.get(ch), currWord);
				visited[x][y] = false;
			}
		}
	}
}
