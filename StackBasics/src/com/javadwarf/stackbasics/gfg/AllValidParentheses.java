package com.javadwarf.stackbasics.gfg;

import java.util.ArrayList;
import java.util.List;

public class AllValidParentheses {

	public static List<String> ll = null;
	
	public static void main(String[] args) {
		generateParenthesis(2);
	}

		public static List<String> generateParenthesis(int n) {
			ll = new ArrayList<>();
			parenthesisChecker(new StringBuffer(), 2, 0);
			return ll;
		}
	
		public static StringBuffer parenthesisChecker(StringBuffer word, int k, int count){
			if( count < 0) {
				return word;
			}
	
			if(word.length()==2*k  ) {
				if(count == 0)
					ll.add(word.toString());
				return word;
			}
	
			word.append("(");
			count = count + 1;
			parenthesisChecker(word,k, count);
			word.deleteCharAt(word.length()-1);
			count = count - 1;
	
			word.append(")");
			count = count - 1;
			parenthesisChecker(word,k, count);
			word.deleteCharAt(word.length()-1);
			count = count + 1;
	
			return word;
		}


}

