package com.javadwarf.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _588_DesignInMemoryFileSystem {

	public static void main(String[] args) {
		System.out.println("/".split("/").length);//0
		System.out.println("/a".split("/").length);//2
		System.out.println("/a/".split("/").length);//2
		
	}

	Dir root = null;

	public _588_DesignInMemoryFileSystem() {
		root = new Dir();
	}

	public List<String> ls(String path) {

		List<String> res = new ArrayList<>();
		
		Dir curr = root;
		
		if(path.equals("/")) {
			res.addAll(curr.directories.keySet());
			res.addAll(curr.files.keySet());
			Collections.sort(res);
			return res;
		}

		String[] arr = path.split("/");


		for(int i=1; i<arr.length-1; i++) {
			curr = curr.directories.get(arr[i]);
		}
		
		if(curr.files.containsKey(arr[arr.length-1])) {
			res.add(arr[arr.length-1]);
		}
		else {
			curr = curr.directories.get(arr[arr.length-1]);
			res.addAll(curr.directories.keySet());
			res.addAll(curr.files.keySet());
			Collections.sort(res);
		}
		return res;
	}

	public void mkdir(String path) {
		Dir curr = root;
		String[] arr = path.split("/");
		for(int i=1; i<arr.length; i++) {
			if(curr.directories.get(arr[i]) == null) {
				Dir d = new Dir();
				curr.directories.put(arr[i], d);
			}
			curr = curr.directories.get(arr[i]);
		}
	}

	public void addContentToFile(String filePath, String content) {
		Dir curr = root;
		String[] arr = filePath.split("/");
		for(int i=1; i<arr.length-1; i++) {
			curr = curr.directories.get(arr[i]);
		}
		String data = curr.files.getOrDefault(arr[arr.length-1], "");
		curr.files.put(arr[arr.length-1], data+content);
	}

	public String readContentFromFile(String filePath) {
		Dir curr = root;
		String[] arr = filePath.split("/");
		for(int i=1; i<arr.length-1; i++) {
			curr = curr.directories.get(arr[i]);
		}
		return curr.files.getOrDefault(arr[arr.length-1], "");
	}

	class Dir {
		Map<String, Dir> directories = null;
		Map<String, String> files = null;

		public Dir() {
			directories = new HashMap<>();
			files = new HashMap<>();
		}
	}

}
