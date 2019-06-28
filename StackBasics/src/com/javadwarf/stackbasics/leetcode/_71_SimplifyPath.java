package com.javadwarf.stackbasics.leetcode;

import java.util.Stack;

public class _71_SimplifyPath {

	public static void main(String[] args) {
		System.out.println(new _71_SimplifyPath().simplifyPath("/home/"));
		System.out.println(new _71_SimplifyPath().simplifyPath("/../"));
		System.out.println(new _71_SimplifyPath().simplifyPath("/home//foo/"));
		System.out.println(new _71_SimplifyPath().simplifyPath("/a/./b/../../c/"));
		System.out.println(new _71_SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
		System.out.println(new _71_SimplifyPath().simplifyPath("/a//b////c/d//././/.."));

	}

	public String simplifyPath(String path) {

		if(path == null || path.length() == 0) return path;

		String[] arr = path.split("/");

		Stack<String> s = new Stack<>();

		for(String curr : arr) {
			if(curr.length()>0 && curr.equals("..") && !s.isEmpty() ) {
				s.pop();
			}
			else if(curr.length()>0 && !curr.equals("..") && !curr.equals(".")) {
				s.push(curr);
			}
		}

		StringBuffer sb = new StringBuffer();
		while(!s.isEmpty()) {
			sb.insert(0,s.pop());
			sb.insert(0,"/");
		}
		return (sb.toString().length()==0) ? "/" : sb.toString();

	}
}