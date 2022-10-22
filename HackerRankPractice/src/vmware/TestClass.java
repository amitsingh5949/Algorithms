package vmware;

import java.util.*;


class TestClass2 {
    public static void main(String args[] ) throws Exception {
        
       /* Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
           
            int num = s.nextInt();
            for(int j = 1; j <= num; j++){
                if(j%3!=0 && j%5!=0 ){
                 System.out.println(j);   
                }
                else if(j%3==0 && j%5!=0 ){
                 System.out.println("Fizz");   
                }
                else if(j%3!=0 && j%5==0 ){
                 System.out.println("Buzz");   
                }
                else if(j%3==0 && j%5==0 ){
                 System.out.println("FizzBuzz");   
                }
            
            }
        }
        s.close();*/
    	
    	System.out.println(swap("amit", 0, 1));
    	//System.out.println("amit".substring(0,0));
    }
    
    public static String swap(String s , int src, int dest) {
    	if( src == dest) return s;
    	StringBuffer sb = new StringBuffer(s);
    	String srcChar = s.charAt(src) + "" ;
    	String destChar = s.charAt(dest) + "" ;
    	sb.replace(src, src+1, destChar);
    	sb.replace(dest, dest+1, srcChar);
    	return sb.toString();

	}
}
