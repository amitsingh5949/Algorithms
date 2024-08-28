package com.javadwarf.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(new _22_GenerateParentheses().generateParenthesis(3));

	}

	public List<String> generateParenthesis(int n) {
		return helper(n, 0, new StringBuilder(), new ArrayList<>());
	}

	public List<String> helper(int n, int count, StringBuilder sb, List<String> result){
		
		if(count < 0) return result;
		if(count > n) return result;

		if( 2*n == sb.length()  ){
			if(count == 0)
				result.add(sb.toString());
			return result;
		}

		sb.append("(");
		helper(n, count+1, sb, result);
		sb.deleteCharAt(sb.length()-1);

		sb.append(")");
		helper(n, count-1, sb, result);
		sb.deleteCharAt(sb.length()-1);

		return result;
	}

}
