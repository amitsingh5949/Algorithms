package com.javadwarf.string.leetcode;

public class _468_ValidateIPAddress {

	public static void main(String[] args) {

	}
	
	// one pass solution and o(1)
	public String validIPAddress(String queryIP) {
        int type = getIPType(queryIP);
        if(type == -1) return "Neither";
        
        if(queryIP.charAt(queryIP.length()-1) == '.' || queryIP.charAt(queryIP.length()-1) == ':')return "Neither";
        
        
        if( type == 0){
            
            int subnetBit = 0;
            int i=0; 

            while( i<queryIP.length() ){
                
                int val = -1;
                boolean firstBit = true;
                
                while(i<queryIP.length() && queryIP.charAt(i) != '.'){
                    char ch = queryIP.charAt(i);
                    if(!Character.isDigit(ch)) return "Neither";
                    if(ch == '0' && firstBit && i<queryIP.length()-1 && Character.isDigit(queryIP.charAt(i+1))) return "Neither";
                    firstBit = false;
                    if(val ==-1) val=0;
                    val = val*10 + (ch-'0');    
                    i++;
                }
                if(val < 0 || val > 255) return "Neither";         
                if(i<queryIP.length() && queryIP.charAt(i) == '.') subnetBit++;
                i++;
            }
            if(subnetBit != 3) return "Neither";
            return "IPv4";
        }
        else{
            
            int subnetBit = 0;
            int i=0; 
            
            while( i<queryIP.length() ){
                int len = 0;
                while(i<queryIP.length() && queryIP.charAt(i) != ':'){
                    char ch = queryIP.charAt(i);
                    if(!(Character.isDigit(ch) || (ch == 'a' || ch == 'b' ||ch == 'c'||ch == 'd'||ch == 'e'||ch == 'f'||ch == 'A'||ch == 'B'||ch == 'C'||ch == 'D'||ch == 'E'||ch == 'F'))){
                        return "Neither";
                    }   
                    i++;
                    len++;
                    if(len > 4) return "Neither";
                }
                if(len == 0) return "Neither";
                if(i<queryIP.length() && queryIP.charAt(i) == ':')subnetBit++;
                i++;
            }
            if(subnetBit != 7) return "Neither";
            return "IPv6";
        }
        
    }
    
    public int getIPType(String s ){
        for(int i=0; i<5 && i<s.length(); i++){
            char ch = s.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                if(ch == '.') return 0;
                if(ch == ':') return 1;
                return -1;
            }
        }
        return -1;
    }

}
