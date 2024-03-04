package com.javadwarf.dynamicprogramming.leetcode.twostring;

public class _161_OneEditDistance {
	
public boolean isOneEditDistance(String s, String t) {
        
        if(s.equals(t)) return false;
        if(Math.abs(s.length()-t.length()) > 1) return false;
        if(s.length() > t.length()) return isOneEditDistance(t,s);
        
        int i=0, j=0;
        
        while(j < t.length()){
            
            if(i == s.length() || s.charAt(i) != t.charAt(j)){
                if(s.length() == t.length()){
                    return isValid(s, t, i+1, j+1);
                }
                else{
                    return isValid(s, t, i, j+1);
                }
            }
            i++;
            j++;
        }
        
        return true;
    }
    
    public boolean isValid(String s, String t, int i , int j){
        while(i<s.length()){
            if(s.charAt(i++) != t.charAt(j++)) return false;
        }
        return true;
    }

}
