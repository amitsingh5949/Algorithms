package com.javadwarf.trie.leetcode.implementation;

public class _208_ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		
		Trie obj = new Trie();
		
		obj.insertRec("abc");
		obj.insertRec("abgl");
		obj.insertRec("cdf");
		obj.insertRec("abcd");
		obj.insertRec("lmn");
		
		obj.deleteWordRec("abc");
		System.out.println(obj.startsWith("abc"));
		System.out.println(obj.search("abc"));
		obj.deleteWordRec("abgl");
		System.out.println(obj.search("abgl"));
		obj.deleteWordRec("abcd");
		System.out.println(obj.search("abcd"));
		
		System.out.println();
		
		
		
		
	}
}


