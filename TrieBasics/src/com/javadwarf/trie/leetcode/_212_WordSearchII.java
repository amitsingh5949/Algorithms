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

	TrieNode root;
    List<String> res;
    
    int[] xArr = {-1,0,0,1};
    int[] yArr = {0,-1,1,0};
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        res = new ArrayList<>();
        if(board == null || words == null || board.length == 0 || words.length==0) return res;
        
        for(String word : words){
            insert(word);
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, i, j, new boolean[board.length][board[0].length], root, new StringBuilder());
            }  
        }  
        
        return res;
    }
    
    public void dfs(char[][] board, int x, int y, boolean[][] visited, TrieNode curr, StringBuilder sb){
        
        char ch = board[x][y];
        if(curr.map[ch-'a'] == null) return;
        
        sb.append(ch);
        visited[x][y] = true;
        
        if(curr.map[ch-'a'] != null &&  curr.map[ch-'a'].end){
            curr.map[ch-'a'].end = false;
            res.add(new String(sb.toString()));
        }
      
        for(int i=0;i<xArr.length; i++){
            int xNew = x + xArr[i];
            int yNew = y + yArr[i];
            if(xNew>=0 && xNew<board.length  && yNew>=0 && yNew<board[0].length && !visited[xNew][yNew]){
                dfs(board, xNew, yNew, visited, curr.map[ch-'a'],sb);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        visited[x][y] = false;
    }
    
    public void insert(String word){
        TrieNode curr = root;
        int i=0;
        while(i<word.length()){
            char ch = word.charAt(i);
            if(curr.map[ch-'a'] == null) curr.map[ch-'a'] = new TrieNode();
            curr = curr.map[ch-'a'];
            i++;
        }
        curr.end = true;
    }
    
    
    class TrieNode{
        TrieNode[] map;
        boolean end;
        public TrieNode(){
            map = new TrieNode[26];
            end = false;
        }
    }
}
