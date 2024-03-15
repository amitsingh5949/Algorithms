package com.javadwarf.dynamicprogramming.leetcode.choosenotchoose;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _301_RemoveInvalidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Set<String> res;
    int maxLength;
    
    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>();
        maxLength = 0;
        helper(s, 0, 0, new StringBuilder());
        return new ArrayList<>(res);
    }
    
    public void helper(String s, int i, int count, StringBuilder sb){
        
        if(i == s.length()){
            if(count == 0 && sb.length() >= maxLength) {
                if(sb.length() > maxLength){
                    maxLength = sb.length();
                    res.clear();
                }
                res.add(sb.toString());
            }
            return;
        }
        
        if(count < 0) return;
        
        char ch = s.charAt(i);
        
        helper(s, i+1, count, sb);// not choose
        
        //choose
        sb.append(ch);
        if(ch == '('){
             helper(s, i+1, count+1,sb);
        }
        else if(ch == ')'){
            helper(s, i+1, count-1,sb);
        }
        else{
             helper(s, i+1, count,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}
