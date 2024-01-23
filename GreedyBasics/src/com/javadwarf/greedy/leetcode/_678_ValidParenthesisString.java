package com.javadwarf.greedy.leetcode;

import java.util.Stack;

public class _678_ValidParenthesisString {

	/*********************************************************************************************************************************************/
	
	//There is a DP solution also given in DP project.
	
	
	//Two Stack approach
	public boolean checkValidString(String s) {

		Stack<Integer> leftPar = new Stack<>();
		Stack<Integer> star = new Stack<>();

		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '('){
				leftPar.push(i);
			}
			else if(s.charAt(i) == '*'){
				star.push(i);
			}
			else{
				if(leftPar.size() == 0 && star.size() == 0) return false; // neither left parenthesis or star is present to balance right parenthesis
				if(leftPar.size() != 0) leftPar.pop();
				else star.pop();
			}
		}

		while(leftPar.size() !=0 && star.size() != 0){
			int leftParIndex = leftPar.pop();
			int starIndex = star.pop();
			if(starIndex < leftParIndex) return false;// this means star cannot be used to balance left parenthesis 
		}
		return leftPar.size() == 0 ;
	}
	/*********************************************************************************************************************************************/
	
    // So we only have 3 possible scenarios here:
    // 1. We had the same amount of '(' and ')'
    // 2. We had more '(' than ')' but enough '*' to substitute
    // 3. We had more ')' than '(' but enough '*' to substitute
	
	//Approach is 
	//1: Find unbalanced parenthesis from left to right , substituting '*' as '(', we might end up with more ( but we will have all ')' balanced 
	//2: Find unbalanced parenthesis from right to left , substituting '*' as ')', we might end up with more ) but we will have all '(' balanced 
	//if balance checking form both sides does not give false  that means we do not have extra ( or ) and the answer is true
	
	public boolean checkValidStringOn(String s) {

		int left = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '*') left++;
			else left --;
			if(left < 0) return false;
		}

		int right = 0;
		for( int i=s.length()-1; i>=0; i--){
			if(s.charAt(i) == ')' || s.charAt(i) == '*') right++;
			else right--;
			if(right < 0) return false;
		}

		return true;
	}


	/*********************************************************************************************************************************************/
	//Wrong logic
	public boolean checkValidString1(String s) {
		String str1 = s.replaceAll("\\*","(");
		String str2 = s.replaceAll("\\*",")");
		String str3 = s.replaceAll("\\*","");
		return isValid(str1) || isValid(str2) ||  isValid(str3);
	}

	public boolean isValid(String s){
		int count = 0;
		for( int i=0;i<s.length(); i++){
			count = s.charAt(i) == '(' ?  count+1 : count-1;
			if(count < 0) return false;
		}
		return count == 0;
	}

}
